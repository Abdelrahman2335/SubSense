package com.example.subsense.setting.presentation.manager.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.subsense.core.data.model.Budget
import com.example.subsense.core.data.model.ExpenseCategory
import com.example.subsense.setting.data.model.Notification
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
) : ViewModel() {
    private val _state = MutableStateFlow(SettingState())
    val state: StateFlow<SettingState> = _state.asStateFlow()

    init {
        initBudgetCategories()
        initNotifications()
    }

    companion object {
        private const val TAG = "SettingViewModel"

        private const val BUDGET_NOTIFICATION = "budgetNotification"
        private const val DAILY_NOTIFICATION = "dailyNotification"
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
                // Seed defaults once (only if missing)
                if (notifications.none { it.notificationType == BUDGET_NOTIFICATION }) {
                    repository.upsertNotification(
                        Notification(notificationType = BUDGET_NOTIFICATION, isEnabled = false)
                    )
                }
                if (notifications.none { it.notificationType == DAILY_NOTIFICATION }) {
                    repository.upsertNotification(
                        Notification(notificationType = DAILY_NOTIFICATION, isEnabled = false)
                    )
                }

                val budget =
                    notifications.firstOrNull { it.notificationType == BUDGET_NOTIFICATION }
                val daily = notifications.firstOrNull { it.notificationType == DAILY_NOTIFICATION }

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