package com.example.subsense.expense.presentation.manager.state

import com.example.subsense.core.model.Budget
import com.example.subsense.core.model.Expense

data class ExpenseState(
    val totalSpend: Long = 0,
    val expenses: List<Expense> = emptyList(),
    val budgetLimit: List<Budget> = emptyList(),
    val isLoading: Boolean = false
)
