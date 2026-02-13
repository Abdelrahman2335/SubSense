package com.example.subsense.manage_expences.presentation.manager.event

import com.example.subsense.core.model.Expense
import com.example.subsense.core.model.ExpenseCategory
import com.example.subsense.setting.data.model.RecurringPattern

sealed interface ExpenseEvent {
    data class SaveExpenseEvent(val expense: Expense) : ExpenseEvent
    data class DeleteExpense(val expense: Expense) : ExpenseEvent
    data class SetAmount(val amount: Long) : ExpenseEvent
    data class SetCategory(val category: ExpenseCategory) : ExpenseEvent
    data class SetDate(val date: Long) : ExpenseEvent
    data class SetNote(val note: String?) : ExpenseEvent
    data class SetRecurring(val recurring: Boolean) : ExpenseEvent
    data class SetRecurringPattern(val recurringPattern: RecurringPattern?) : ExpenseEvent

}