package com.example.subsense.expense.presentation.manager.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.subsense.expense.data.repository.ExpenseRepo
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

    init {
        getExpenses()
    }

    private fun getExpenses() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            repository.getAllExpenses().collect { expenses ->
                _state.update { it.copy(expenses = expenses, isLoading = false) }
            }
        }


    }


}