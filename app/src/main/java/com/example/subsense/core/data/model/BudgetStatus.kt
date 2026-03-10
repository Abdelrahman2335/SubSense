package com.example.subsense.core.data.model

data class BudgetStatus(
    val category: ExpenseCategory,
    val spent: Int,
    val limit: Int,
    val percentage: Float,
    val isOverBudget: Boolean
)