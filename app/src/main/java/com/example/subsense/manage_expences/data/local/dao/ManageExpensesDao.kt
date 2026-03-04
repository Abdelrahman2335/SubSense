package com.example.subsense.manage_expences.data.local.dao

import androidx.room.Dao
import androidx.room.Upsert
import com.example.subsense.core.data.model.Expense

@Dao
interface ManageExpensesDao {
    @Upsert
    suspend fun upSertExpense(expense: Expense)

}