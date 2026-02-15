package com.example.subsense.expense.data.repository

import com.example.subsense.core.model.Expense
import kotlinx.coroutines.flow.Flow

interface ExpenseRepo {
    fun getAllExpenses(): Flow<List<Expense>>
}