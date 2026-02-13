package com.example.subsense.manage_expences.presentation.manager.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.subsense.core.model.Expense
import com.example.subsense.manage_expences.data.repository.ManageExpensesDao
import com.example.subsense.manage_expences.presentation.manager.event.ExpenseEvent
import com.example.subsense.manage_expences.presentation.manager.state.ExpenseState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ExpenseViewModel(
    private val dao: ManageExpensesDao
) : ViewModel() {

    private val _state = MutableStateFlow(ExpenseState())
    val state: StateFlow<ExpenseState> = _state.asStateFlow()

    fun onEvent(event: ExpenseEvent) {
        when (event) {
            is ExpenseEvent.SetAmount -> {
                _state.update { it.copy(expense = it.expense.copy(amount = event.amount)) }
            }

            is ExpenseEvent.SetCategory -> {
                _state.update { it.copy(expense = it.expense.copy(category = event.category)) }
            }

            is ExpenseEvent.SetDate -> {
                _state.update { it.copy(expense = it.expense.copy(date = event.date)) }
            }

            is ExpenseEvent.SetNote -> {
                _state.update { it.copy(expense = it.expense.copy(note = event.note)) }
            }

            is ExpenseEvent.SetRecurring -> {
                _state.update { it.copy(expense = it.expense.copy(isRecurring = event.recurring)) }
            }

            is ExpenseEvent.SetRecurringPattern -> {
                _state.update { it.copy(expense = it.expense.copy(recurringPattern = event.recurringPattern)) }
            }

            is ExpenseEvent.SaveExpenseEvent -> {
                val result: Expense = _state.value.expense
                if (result.amount <= 0 || result.date <= 0) {
                    _state.update { it.copy(error = "Field is Required") }
                    return
                }
                viewModelScope.launch {
                    dao.upSertExpense(
                        expense = result
                    )
                }

            }

            is ExpenseEvent.DeleteExpense -> {
                viewModelScope.launch {
                    dao.deleteExpense(event.expense)
                }
            }
        }
    }
}