package com.example.subsense.setting.presentation.manager.event

import com.example.subsense.core.data.model.Budget
import com.example.subsense.core.notification.model.Notification

sealed interface SettingEvent {
    data class UpsertBudget(val budget: Budget) : SettingEvent
    data class UpdateNotification(val notification: Notification) : SettingEvent
}