package com.example.subsense.setting.presentation.manager.view_model

import android.util.Log
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.subsense.core.data.model.Budget
import com.example.subsense.core.data.model.ExpenseCategory
import com.example.subsense.core.notification.model.Notification
import com.example.subsense.core.notification.model.NotificationType
import com.example.subsense.setting.data.repository.SettingRepo
import com.example.subsense.setting.presentation.manager.event.SettingEvent
import com.example.subsense.setting.presentation.manager.state.SettingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val repository: SettingRepo,
    private val notificationManager: NotificationManagerCompat
) : ViewModel() {
    private val _state = MutableStateFlow(SettingState())
    val state: StateFlow<SettingState> = _state.asStateFlow()

    init {
        initBudgetCategories()
        initNotifications()
    }

    companion object {
        private const val TAG = "SettingViewModel"
    }

    fun onEvent(event: SettingEvent) {
        when (event) {
            is SettingEvent.UpsertBudget -> {
                viewModelScope.launch {
                    repository.upsertBudget(event.budget)
                }
            }

            is SettingEvent.UpdateNotification -> {
                viewModelScope.launch {
                    Log.d(
                        TAG,
                        "New notification: ${event.notification.notificationType}, status is ${event.notification.isEnabled}"
                    )
                    // Write to DB; state will be refreshed by initNotifications() collector.
                    repository.upsertNotification(event.notification)
                }
            }
        }
    }

    private fun initBudgetCategories() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            repository.getBudgets().collect { budgets ->
                val categories = ExpenseCategory.getAllCategories()
                if (budgets.isEmpty()) {
                    val defaults = categories.map {
                        Budget(
                            categoryId = it.id,
                            limitAmount = 0,
                        )
                    }
                    repository.upsertBudget(defaults)
                    _state.update {
                        it.copy(
                            budgetCategories = categories,
                            budgetValues = defaults,
                            isLoading = false
                        )
                    }

                } else {

                    _state.update {
                        it.copy(
                            budgetCategories = categories,
                            budgetValues = budgets,
                            isLoading = false
                        )
                    }
                }
            }

        }
    }

    private fun initNotifications() {
        viewModelScope.launch {
            repository.getNotifications().collect { notifications ->

                if (notifications.none { it.notificationType == NotificationType.BUDGET }) {
                    repository.upsertNotification(
                        Notification(notificationType = NotificationType.BUDGET, isEnabled = false)
                    )
                }
                if (notifications.none { it.notificationType == NotificationType.DAILY }) {
                    repository.upsertNotification(
                        Notification(notificationType = NotificationType.DAILY, isEnabled = false)
                    )
                }

                val budget =
                    notifications.firstOrNull { it.notificationType == NotificationType.BUDGET }
                val daily =
                    notifications.firstOrNull { it.notificationType == NotificationType.DAILY }

                _state.update { state ->
                    state.copy(
                        budgetNotification = budget ?: state.budgetNotification,
                        dailyNotification = daily ?: state.dailyNotification,
                    )
                }
            }
        }
    }
}