package com.example.subsense.manage_expences.presentation.manager.event

import com.example.subsense.core.model.Expense
import com.example.subsense.core.model.ExpenseCategory
import com.example.subsense.setting.data.model.Frequency

sealed interface ManageExpenseEvent {
    data object SaveExpense : ManageExpenseEvent
    data class DeleteExpense(val expense: Expense) : ManageExpenseEvent
    data class SetAmountInput(val input: String) : ManageExpenseEvent
    data class SetCategory(val category: ExpenseCategory) : ManageExpenseEvent
    data class SetDate(val date: Long) : ManageExpenseEvent
    data class SetNote(val note: String?) : ManageExpenseEvent
    data class SetRecurring(val recurring: Boolean) : ManageExpenseEvent
    data class SetFrequency(val frequency: Frequency?) : ManageExpenseEvent
    data class SetInterval(val interval: String) : ManageExpenseEvent

}