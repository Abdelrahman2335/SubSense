package com.example.subsense.expense.data.model

data class MonthlyOverview(
    val month: Int,
    val year: Int,
    val totalSpent: Long,
    val budgetTotal: Long,
    val byCategory: List<ExpenseSummary>
)
