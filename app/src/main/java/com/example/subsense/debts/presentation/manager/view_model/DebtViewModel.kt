package com.example.subsense.debts.presentation.manager.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.subsense.debts.data.repository.DebtRepo
import com.example.subsense.debts.presentation.manager.event.DebtEvent
import com.example.subsense.debts.presentation.manager.state.DebtState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DebtViewModel @Inject constructor(
    private val repository: DebtRepo
) : ViewModel() {
    private val _state = MutableStateFlow(DebtState())

    val state: StateFlow<DebtState> = _state.asStateFlow()

    init {
        getMoneyLent()
        getMoneyBorrowed()
    }

    companion object {
        private const val TAG = "DebtViewModel"
    }

    private fun getMoneyLent() {
        viewModelScope.launch {
            Log.d(TAG, "getMoneyLent: fetching money lent")
            _state.update { it.copy(isLoading = true) }
            repository.getMoneyLent().collect { lent ->
                val total = lent.sumOf { it.amount ?: 0.0 }
                Log.d(TAG, "getMoneyLent: received ${lent.size} items, total = $total")
                _state.update { it.copy(moneyLent = lent, totalLent = total, isLoading = false) }
            }
        }
    }

    private fun getMoneyBorrowed() {
        viewModelScope.launch {
            Log.d(TAG, "getMoneyBorrowed: fetching money borrowed")
            _state.update { it.copy(isLoading = true) }
            repository.getMoneyBorrowed().collect { borrow ->
                val total = borrow.sumOf { it.amount ?: 0.0 }
                Log.d(TAG, "getMoneyBorrowed: received ${borrow.size} items, total = $total")
                _state.update {
                    it.copy(moneyBorrow = borrow, totalBorrowed = total, isLoading = false)
                }
            }
        }
    }

    fun onEvent(event: DebtEvent) {
        Log.d(TAG, "onEvent: $event")
        when (event) {
            is DebtEvent.ChangeStatus -> {
                Log.d(TAG, "onEvent: ChangeStatus → id=${event.id}, status=${event.status}")
                viewModelScope.launch {
                    repository.changeStatus(event.id, event.status)
                }
            }

            is DebtEvent.DeleteDebt -> {
                Log.d(TAG, "onEvent: DeleteDebt → debt=${event.debt}")
                viewModelScope.launch {
                    repository.deleteDebt(event.debt)
                }
            }
        }
    }
}