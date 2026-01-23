package com.example.subsense.expense.data.model

import com.example.subsense.core.model.ExpenseCategory

data class ExpenseSummary(
    val category: ExpenseCategory,
    val totalAmount: Long,
    val expenseCount: Int,
    val percentage: Float // of total spending
)