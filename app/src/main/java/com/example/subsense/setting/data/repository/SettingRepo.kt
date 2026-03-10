package com.example.subsense.setting.data.repository

import com.example.subsense.core.data.model.Budget
import kotlinx.coroutines.flow.Flow

interface SettingRepo {

    fun getBudgets(): Flow<List<Budget>>

    suspend fun upsertBudget(budget: Budget)
    suspend fun upsertBudget(budgets: List<Budget>)
}