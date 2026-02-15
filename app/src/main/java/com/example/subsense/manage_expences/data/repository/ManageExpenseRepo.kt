package com.example.subsense.manage_expences.data.repository

import com.example.subsense.core.model.Expense

interface ManageExpenseRepo {
    suspend fun upSertExpense(expense: Expense)
    suspend fun deleteExpense(expense: Expense)
}