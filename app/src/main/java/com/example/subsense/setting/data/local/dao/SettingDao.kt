package com.example.subsense.setting.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.subsense.core.data.model.Budget

@Dao
interface SettingDao {

    @Query("SELECT * FROM budget")
    fun getBudgets(): List<Budget>

    @Upsert
    fun upsertBudget(budget: Budget)

}