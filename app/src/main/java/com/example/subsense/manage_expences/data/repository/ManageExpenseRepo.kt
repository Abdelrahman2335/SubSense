package com.example.subsense.manage_expences.data.repository

import com.example.subsense.core.data.model.Expense

interface ManageExpenseRepo {
    suspend fun upSertExpense(expense: Expense)
}