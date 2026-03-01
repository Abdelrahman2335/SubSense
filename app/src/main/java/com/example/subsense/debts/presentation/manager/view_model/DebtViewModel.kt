package com.example.subsense.debts.presentation.manager.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.subsense.debts.data.repository.DebtRepo
import com.example.subsense.debts.presentation.manager.state.DebtState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class DebtViewModel @Inject constructor(
    private val repository: DebtRepo
) : ViewModel() {
    private val _state = MutableStateFlow(DebtState())

    val state: StateFlow<DebtState> = _state.asStateFlow()

    private fun getMoneyLent() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            repository.getMoneyLent().collect { lent ->
                val total = lent.sumOf { it.amount ?: 0.0 }
                _state.update { it.copy(moneyLent = lent, totalLent = total, isLoading = false) }
            }
        }
    }

    private fun getMoneyBorrowed() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            repository.getMoneyBorrowed().collect { borrow ->
                val total = borrow.sumOf { it.amount ?: 0.0 }
                _state.update {
                    it.copy(moneyBorrow = borrow, totalBorrowed = total, isLoading = false)
                }
            }
        }
    }
}