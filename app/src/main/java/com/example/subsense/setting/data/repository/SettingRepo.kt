package com.example.subsense.setting.data.repository

import com.example.subsense.core.data.model.Budget
import com.example.subsense.core.notification.model.Notification
import kotlinx.coroutines.flow.Flow

interface SettingRepo {

    fun getBudgets(): Flow<List<Budget>>
    fun getNotifications(): Flow<List<Notification>>

    suspend fun upsertBudget(budget: Budget)
    suspend fun upsertBudget(budgets: List<Budget>)
    suspend fun upsertNotification(notification: Notification)
    suspend fun updateNotification(notification: Notification)


}