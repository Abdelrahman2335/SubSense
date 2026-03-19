package com.example.subsense.setting.presentation.manager.view_model

import android.Manifest
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.subsense.core.data.model.Budget
import com.example.subsense.core.data.model.ExpenseCategory
import com.example.subsense.core.notification.model.Notification
import com.example.subsense.core.notification.model.NotificationType
import com.example.subsense.core.notification.scheduler.NotificationScheduler
import com.example.subsense.setting.data.repository.SettingRepo
import com.example.subsense.setting.presentation.manager.event.SettingEvent
import com.example.subsense.setting.presentation.manager.state.SettingState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalTime
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val repository: SettingRepo,
    private val notificationScheduler: NotificationScheduler
) : ViewModel() {

    private val _state = MutableStateFlow(SettingState())
    val state: StateFlow<SettingState> = _state.asStateFlow()

    // State to trigger permission request from UI

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
                Log.d(TAG, "Notification Permission is: ${hasNotificationPermission()}")
                if (hasNotificationPermission()) {

                    // Permission granted, proceed with scheduling
                    if (event.notification.isEnabled) {
                        Log.d(TAG, "Notification Enabled?: ${event.notification.isEnabled}")
                        viewModelScope.launch {
                            repository.upsertNotification(event.notification)

                            scheduleNotification(event.notification)
                        }

                    } else {
                        viewModelScope.launch {
                            repository.upsertNotification(event.notification)

                            disableNotification(event.notification)
                        }
                    }
                } else {
                    // Request permission
                    requestNotificationPermission(event.notification)
                    // Don't enable yet, wait for permission callback
                }

            }
        }
    }

    private fun hasNotificationPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == android.content.pm.PackageManager.PERMISSION_GRANTED
        } else {
            // Pre-Android 13, no runtime permission needed
            true
        }
    }

    private fun requestNotificationPermission(notification: Notification) {
        viewModelScope.launch {
            repository.upsertNotification(notification)

            Log.d(TAG, "Requesting POST_NOTIFICATIONS permission")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                Log.d(TAG, "Check Build Version: ${Build.VERSION.SDK_INT}")

                _state.update { it.copy(notificationPermissionRequest = true) }
            }
        }
    }

    fun onPermissionResult(permission: String, granted: Boolean) {
        Log.d(TAG, "Permission result: $permission = $granted")

        if (permission == Manifest.permission.POST_NOTIFICATIONS && granted) {
            // User granted permission, now enable notification
            val currentDaily = _state.value.dailyNotification
            scheduleNotification(currentDaily)

        } else if (permission == Manifest.permission.POST_NOTIFICATIONS) {
            // User denied permission, disable the toggle
            Log.w(TAG, "User denied POST_NOTIFICATIONS permission")
        }
        _state.update { it.copy(notificationPermissionRequest = false) }

    }

    private fun scheduleNotification(notification: Notification) {
        Log.d(TAG, "Scheduling notification")

        if (notification.notificationType == NotificationType.DAILY) {
            notificationScheduler.scheduleDailyNotification(
                times = listOf(
                    LocalTime.of(14, 0),  // 2 PM
                    LocalTime.of(19, 0)   // 7 PM
                ),
                title = "Daily Reminder",
                message = "Don't forget to add your expenses"
            )

        }
    }

    private fun disableNotification(notification: Notification) {
        Log.d(TAG, "Disabling notification")


        if (notification.notificationType == NotificationType.DAILY) {
            notificationScheduler.cancelDailyNotification()

        }
    }

    private fun initNotifications() {
        viewModelScope.launch {
            repository.getNotifications().collect { notifications ->

                if (notifications.none { it.notificationType == NotificationType.DAILY }) {
                    repository.upsertNotification(
                        Notification(notificationType = NotificationType.DAILY, isEnabled = false)
                    )
                }

                val daily =
                    notifications.firstOrNull { it.notificationType == NotificationType.DAILY }

                _state.update { state ->
                    state.copy(
                        dailyNotification = daily ?: state.dailyNotification,
                    )

                }
                Log.d(TAG, "init value: ${_state.value.dailyNotification.isEnabled}")

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

}