package com.example.subsense.manage_expences.presentation.manager.state

import com.example.subsense.core.model.Expense
import com.example.subsense.core.model.ExpenseCategory

data class ExpenseState(

    val expense: Expense = Expense(
        id = 0,
        amount = 0,
        category = ExpenseCategory.getAllCategories().first(),
        date = 0,
        note = null,
        isRecurring = false,
        recurringPattern = null
    ),
    val error: String? = null,
)