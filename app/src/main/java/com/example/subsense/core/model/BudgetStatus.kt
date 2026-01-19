package com.example.subsense.core.model

data class BudgetStatus(
    val category: ExpenseCategory,
    val spent: Long,
    val limit: Long,
    val percentage: Float,
    val isOverBudget: Boolean
)