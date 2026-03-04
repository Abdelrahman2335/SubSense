package com.example.subsense.manage_debts.presentation.manager.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.subsense.debts.data.model.DebtModel
import com.example.subsense.manage_debts.data.repository.ManageDebtRepo
import com.example.subsense.manage_debts.presentation.manager.event.ManageDebtsEvent
import com.example.subsense.manage_debts.presentation.manager.state.ManageDebtsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManageDebtViewModel @Inject constructor(
    private val repository: ManageDebtRepo
) : ViewModel() {
    private val _state = MutableStateFlow(ManageDebtsState())
    val state: StateFlow<ManageDebtsState> = _state.asStateFlow()

    companion object {
        private const val TAG = "ManageDebtViewModel"
    }

    fun onEvent(event: ManageDebtsEvent) {
        Log.d(TAG, "onEvent: $event")
        when (event) {
            is ManageDebtsEvent.SetAmount -> {
                Log.d(TAG, "Handling SetAmount event with value: ${event.amount}")
                handleAmountInput(event.amount)
            }

            is ManageDebtsEvent.SetDebtType -> {
                Log.d(TAG, "Handling SetDebtType event with type: ${event.type}")
                _state.update {
                    it.copy(
                        debt = it.debt.copy(
                            debtType = event.type
                        )
                    )
                }
                Log.d(TAG, "DebtType updated to: ${event.type}")
            }

            is ManageDebtsEvent.SetDueDate -> {
                Log.d(TAG, "Handling SetDueDate event with date: ${event.date}")
                _state.update {
                    it.copy(
                        debt = it.debt.copy(
                            dueDate = event.date
                        )
                    )
                }
                Log.d(TAG, "DueDate updated to: ${event.date}")
            }

            is ManageDebtsEvent.SetName -> {
                Log.d(TAG, "Handling SetName event with name: ${event.name}")
                _state.update {
                    it.copy(
                        debt = it.debt.copy(
                            name = event.name
                        )
                    )
                }
                Log.d(TAG, "Name updated to: ${event.name}")
            }

            is ManageDebtsEvent.SetNote -> {
                Log.d(TAG, "Handling SetNote event with note: ${event.note}")
                _state.update {
                    it.copy(
                        debt = it.debt.copy(
                            note = event.note
                        )
                    )
                }
                Log.d(TAG, "Note updated to: ${event.note}")
            }

            ManageDebtsEvent.SaveDebt -> {
                Log.d(TAG, "Handling SaveDebt event")
                onSave()
            }
        }
        Log.d(TAG, "onEvent completed: $event")
    }

    private fun handleAmountInput(input: String) {
        Log.d(TAG, "📍 Event: SetAmountInput | raw input='$input'")
        try {

            val parsedAmount = input.toIntOrNull()
            if (input.contains(Regex("[.,+/-]+$"))) {
                Log.w(TAG, "❌ Invalid input: $input")
                return
            }

            val oldAmount = _state.value.debt.amount
            _state.update {
                it.copy(
                    debt = it.debt.copy(amount = parsedAmount)
                )
            }
            Log.d(TAG, "✅ State Updated: amount changed from $oldAmount to $parsedAmount")
        } catch (e: Exception) {
            Log.e(TAG, "❌ Unexpected error parsing amount: '$input'", e)
            // Don't update state on error
        }
        Log.d(TAG, "handleAmountInput completed for input='$input'")
    }

    private fun onSave() {
        val debt = _state.value.debt
        Log.d(TAG, "onSave called with debt: $debt")
        val validationError = validation(debt)
        if (validationError != null) {
            Log.w(TAG, "Validation failed: $validationError")
            if (validationError.contains("Amount")) {
                _state.update { it.copy(amountError = validationError) }
                Log.d(TAG, "Amount error set: $validationError")
                return
            }
            if (validationError.contains("Name")) {
                _state.update { it.copy(nameError = validationError) }
                Log.d(TAG, "Name error set: $validationError")
                return
            }
            if (validationError.contains("date")) {
                _state.update { it.copy(dueDateError = validationError) }
                Log.d(TAG, "DueDate error set: $validationError")
                return
            }
        }
        viewModelScope.launch {
            Log.d(TAG, "Saving debt to repository: $debt")
            repository.upsertDebt(debt = debt)
            Log.d(TAG, "Debt saved successfully: $debt")
            _state.update {
                it.copy(
                    amountError = null,
                    nameError = null,
                    dueDateError = null,
                    isSaved = true
                )
            }
            Log.d(TAG, "State updated after save: isSaved=true")
        }
    }

    private fun validation(debt: DebtModel): String? {
        Log.d(TAG, "Validating debt: $debt")
        if (debt.amount == null) {
            Log.w(TAG, "Validation error: Amount is required")
            return "Amount is required"
        }
        if (debt.amount <= 0) {
            Log.w(TAG, "Validation error: Amount must be greater than 0")
            return "Amount must be greater than 0"
        }
        if (debt.dueDate <= 0) {
            Log.w(TAG, "Validation error: Valid date is required")
            return "Valid date is required"
        }
        if (debt.name == "") {
            Log.w(TAG, "Validation error: Name is required")
            return "Name is required"
        }
        Log.d(TAG, "Validation passed for debt: $debt")
        return null

    }
}