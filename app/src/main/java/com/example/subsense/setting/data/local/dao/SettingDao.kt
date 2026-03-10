package com.example.subsense.setting.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.subsense.core.data.model.Budget
import kotlinx.coroutines.flow.Flow

@Dao
interface SettingDao {

    @Query("SELECT * FROM budget")
    fun getBudgets(): Flow<List<Budget>>

    @Upsert
    suspend fun upsertBudget(budget: Budget)

    @Upsert
    suspend fun upsertBudgets(budgets: List<Budget>)

}