package com.example.subsense.expense.presentation.manager.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.subsense.core.model.Expense
import com.example.subsense.expense.data.repository.ExpenseRepo
import com.example.subsense.expense.presentation.manager.event.ExpenseEvent
import com.example.subsense.expense.presentation.manager.state.ExpenseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(
    private val repository: ExpenseRepo
) : ViewModel() {


    private val _state = MutableStateFlow(ExpenseState())

    val state: StateFlow<ExpenseState> = _state.asStateFlow()

    companion object {
        private const val TAG = "ExpenseViewModel"
    }

    init {
        Log.d(TAG, "🚀 ExpenseViewModel initialized")
        getExpenses()
    }

    fun onEvent(event: ExpenseEvent) {
        Log.d(TAG, "📩 onEvent called | event=${event::class.simpleName}")
        when (event) {
            is ExpenseEvent.DeleteExpense -> {
                deleteExpense(event.expense)
            }
        }
    }

    private fun getExpenses() {
        Log.d(TAG, "📥 getExpenses() called")
        viewModelScope.launch {
            Log.d(TAG, "⏳ Setting isLoading = true")
            _state.update { it.copy(isLoading = true) }
            Log.d(TAG, "🔄 Collecting expenses from repository...")
            repository.getAllExpenses().collect { expenses ->
                val total = expenses.sumOf { it.amount ?: 0 }
                Log.d(TAG, "📊 Expenses received | count=${expenses.size} | totalSpend=$total")
                _state.update {
                    it.copy(
                        expenses = expenses,
                        totalSpend = total,
                        isLoading = false
                    )
                }
                Log.d(
                    TAG,
                    "✅ State updated | isLoading=false | expenses=${expenses.size} | total=$total"
                )
            }
        }

    }

    private fun deleteExpense(expense: Expense) {
        Log.d(TAG, "📍 Event: DeleteExpense | id=${expense.id}")
        viewModelScope.launch {
            try {
                Log.d(TAG, "🗑️ Deleting expense from database...")
                repository.deleteExpense(expense)
                Log.d(TAG, "✅ Expense deleted successfully | id=${expense.id}")
            } catch (e: Exception) {
                Log.e(TAG, "❌ Failed to delete expense | id=${expense.id}", e)
            }
        }
    }

}