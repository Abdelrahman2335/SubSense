package com.example.subsense.setting.presentation.manager.state

import com.example.subsense.core.data.model.Budget
import com.example.subsense.core.data.model.ExpenseCategory
import com.example.subsense.setting.data.model.Notification

data class SettingState(
    val budgetCategories: List<ExpenseCategory> = emptyList(),
    val budgetValues: List<Budget> = emptyList(),
    val isLoading: Boolean = false,
    val budgetNotification: Notification = Notification(
        notificationType = "budgetNotification",
        isEnabled = false
    ),
    val dailyNotification: Notification = Notification(
        notificationType = "dailyNotification",
        isEnabled = false
    )
)