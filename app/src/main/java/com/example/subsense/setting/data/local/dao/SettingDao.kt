package com.example.subsense.setting.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.subsense.core.data.model.Budget
import com.example.subsense.setting.data.model.Notification
import kotlinx.coroutines.flow.Flow

@Dao
interface SettingDao {

    @Query("SELECT * FROM budget")
    fun getBudgets(): Flow<List<Budget>>

    @Query("SELECT * FROM Notification")
    fun getNotifications(): Flow<List<Notification>>

    // Needed to seed + update notification rows (daily/budget)
    @Upsert
    suspend fun upsertNotification(notification: Notification)

    @Upsert
    suspend fun upsertBudget(budget: Budget)

    @Upsert
    suspend fun upsertBudgets(budgets: List<Budget>)

    @Update
    suspend fun updateNotification(notification: Notification)

}