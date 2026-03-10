package com.example.subsense.setting.presentation.manager.event

import com.example.subsense.core.data.model.Budget

sealed interface SettingEvent {
    data class UpsertBudget(val budget: Budget) : SettingEvent
}