package com.example.subsense.setting.data.repository

import com.example.subsense.core.data.model.Budget

interface SettingRepo {

    fun getBudgets(): List<Budget>

    fun upsertBudget(budget: Budget)
}