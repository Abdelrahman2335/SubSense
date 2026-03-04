package com.example.subsense.expense.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.example.subsense.core.model.Expense
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM expenses ORDER BY date DESC ")
    fun getAllExpenses(): Flow<List<Expense>>

    @Delete
    suspend fun deleteExpense(expense: Expense)
}