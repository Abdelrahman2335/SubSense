package com.example.subsense.expense.presentation.manager.event

import com.example.subsense.core.data.model.Expense

sealed interface ExpenseEvent {
    data class DeleteExpense(val expense: Expense) : ExpenseEvent
}