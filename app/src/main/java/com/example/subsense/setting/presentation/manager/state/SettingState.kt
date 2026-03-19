package com.example.subsense.setting.presentation.manager.state

import com.example.subsense.core.data.model.Budget
import com.example.subsense.core.data.model.ExpenseCategory
import com.example.subsense.core.notification.model.Notification
import com.example.subsense.core.notification.model.NotificationType

data class SettingState(
    val budgetCategories: List<ExpenseCategory> = emptyList(),
    val budgetValues: List<Budget> = emptyList(),
    val isLoading: Boolean = false,
    val notificationPermissionRequest: Boolean = false,

    val budgetNotification: Notification = Notification(
        notificationType = NotificationType.BUDGET,
        isEnabled = false
    ),
    val dailyNotification: Notification = Notification(
        notificationType = NotificationType.DAILY,
        isEnabled = false
    ),
)