package com.example.subsense.expense.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.subsense.core.model.Expense
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM expenses ORDER BY date DESC ")
    fun getAllExpenses(): Flow<List<Expense>>
}