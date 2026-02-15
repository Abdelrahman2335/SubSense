package com.example.subsense.manage_expences.presentation.manager.state

import com.example.subsense.core.model.Expense
import com.example.subsense.core.model.ExpenseCategory

data class ManageExpenseState(

    val expense: Expense = Expense(
        id = 0,
        amount = null,
        category = ExpenseCategory.getAllCategories().first(),
        date = System.currentTimeMillis(),
        note = null,
        isRecurring = false,
        recurringPattern = null
    ),
    val categories: List<ExpenseCategory> = ExpenseCategory.getAllCategories(),
    val amountError: String? = null,
    val intervalError: String? = null,
    val isSaved: Boolean = false,
)