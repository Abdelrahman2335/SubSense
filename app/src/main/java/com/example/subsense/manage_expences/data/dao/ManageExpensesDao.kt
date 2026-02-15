package com.example.subsense.manage_expences.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert
import com.example.subsense.core.model.Expense

@Dao
interface ManageExpensesDao {
    @Upsert
    suspend fun upSertExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Expense)
}