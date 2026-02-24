package com.example.subsense.manage_expences.presentation.manager.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.subsense.core.model.Expense
import com.example.subsense.manage_expences.data.repository.ManageExpenseRepo
import com.example.subsense.manage_expences.presentation.manager.event.ManageExpenseEvent
import com.example.subsense.manage_expences.presentation.manager.state.ManageExpenseState
import com.example.subsense.setting.data.model.Frequency
import com.example.subsense.setting.data.model.RecurringPattern
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManageExpenseViewModel @Inject constructor(
    private val repository: ManageExpenseRepo
) : ViewModel() {

    private val _state = MutableStateFlow(ManageExpenseState())
    val state: StateFlow<ManageExpenseState> = _state.asStateFlow()

    companion object {
        private const val TAG = "ManageExpenseViewModel"
    }

    fun onEvent(event: ManageExpenseEvent) {
        when (event) {
            is ManageExpenseEvent.SetAmountInput -> {
                handleAmountInput(event.input)
            }

            is ManageExpenseEvent.SetCategory -> {
                Log.d(TAG, "📍 Event: SetCategory | category=${event.category.displayName}")
                _state.update {
                    it.copy(
                        expense = it.expense.copy(category = event.category),
                        amountError = null
                    )
                }
                Log.d(TAG, "✅ State Updated: category=${_state.value.expense.category.displayName}")
            }

            is ManageExpenseEvent.SetDate -> {
                Log.d(TAG, "📍 Event: SetDate | dateMillis=${event.date}")
                val oldDate = _state.value.expense.date
                _state.update {
                    it.copy(
                        expense = it.expense.copy(date = event.date),
                        amountError = null
                    )
                }
                Log.d(TAG, "✅ State Updated: date changed from $oldDate to ${event.date}")
            }

            is ManageExpenseEvent.SetNote -> {
                Log.d(TAG, "📍 Event: SetNote | note='${event.note}'")
                _state.update {
                    it.copy(
                        expense = it.expense.copy(note = event.note),
                        amountError = null
                    )
                }
                Log.d(TAG, "✅ State Updated: note set")
            }

            is ManageExpenseEvent.SetRecurring -> {
                Log.d(TAG, "📍 Event: SetRecurring | isRecurring=${event.recurring}")
                _state.update {
                    it.copy(
                        expense = it.expense.copy(
                            isRecurring = event.recurring,
                            recurringPattern = RecurringPattern(
                                frequency = Frequency.Daily,
                                interval = 1,

                                )
                        )
                    )
                }
                Log.d(
                    TAG,
                    "📍 Event: SetRecurring | isRecurring=${_state.value.expense.isRecurring}| recurringPattern=${_state.value.expense.recurringPattern}"
                )
            }

            is ManageExpenseEvent.SetFrequency -> {
                Log.d(TAG, "📍 Event: SetFrequency | frequency=${event.frequency}")
                _state.update {
                    it.copy(
                        expense = it.expense.copy(
                            recurringPattern = it.expense.recurringPattern?.copy(
                                frequency = event.frequency,
                            )
                        )
                    )
                }
            }

            is ManageExpenseEvent.SetInterval -> {
                Log.d(TAG, "📍 Event: SetInterval | interval=${event.interval}")
                val parsedInterval = event.interval.toIntOrNull()

                if (parsedInterval == null) {
                    Log.w(TAG, "❌ Invalid interval: ${event.interval}")
                    _state.update { it.copy(intervalError = "Interval must be at least 1") }
                    return
                }

                Log.d(TAG, "✅ Valid interval: $parsedInterval")
                _state.update {
                    it.copy(
                        expense = it.expense.copy(
                            recurringPattern = it.expense.recurringPattern?.copy(
                                interval = parsedInterval
                            )
                        ),
                        intervalError = null // Clear error on valid input
                    )
                }
            }

            is ManageExpenseEvent.SaveExpense -> {
                saveExpense()
            }

            is ManageExpenseEvent.DeleteExpense -> {
                deleteExpense(event.expense)
            }


        }
    }

    private fun handleAmountInput(input: String) {
        Log.d(TAG, "📍 Event: SetAmountInput | raw input='$input'")

        try {
            // Parse the input string to Float
            val amount = if (input.isEmpty() || input.isBlank()) {
                Log.d(TAG, "⚠️ Amount input is empty, setting to null")
                null
            } else {
                val parsedAmount = input.toFloatOrNull()
                if (parsedAmount == null) {
                    Log.w(TAG, "⚠️ Failed to parse amount: '$input' is not a valid number")
                    // Keep current amount, don't update
                    return
                }
                Log.d(TAG, "✅ Amount parsed successfully: $parsedAmount")
                parsedAmount
            }

            val oldAmount = _state.value.expense.amount
            _state.update {
                it.copy(
                    expense = it.expense.copy(amount = amount),
                    amountError = null
                )
            }
            Log.d(TAG, "✅ State Updated: amount changed from $oldAmount to $amount")

        } catch (e: Exception) {
            Log.e(TAG, "❌ Unexpected error parsing amount: '$input'", e)
            // Don't update state on error
        }
    }

    private fun saveExpense() {
        val expense = _state.value.expense
        Log.d(TAG, "📍 Event: SaveExpense")
        Log.d(
            TAG,
            "📊 Expense Data: amount=${expense.amount}, category=${expense.category.displayName}, date=${expense.date}, isRecurring=${expense.isRecurring}, note='${expense.note}'"
        )

        // Validate expense data
        val validationError = validateExpense(expense)
        if (validationError != null) {
            Log.e(TAG, "❌ Validation Failed: $validationError")


            if (validationError.contains("Amount")) {
                _state.update { it.copy(amountError = validationError, intervalError = null) }
                return
            }
            if (validationError.contains("interval")) {

                _state.update { it.copy(intervalError = validationError, amountError = null) }
                return
            }

        }


        Log.d(TAG, "✅ Validation Passed")

        viewModelScope.launch {
            try {
                Log.d(TAG, "💾 Saving expense to database...")
                repository.upSertExpense(expense)
                Log.d(TAG, "✅ Expense saved successfully | id=${expense.id}")

                // Clear all errors and mark as saved
                _state.update { it.copy(amountError = null, intervalError = null, isSaved = true) }

            } catch (e: Exception) {
                val errorMsg = "Failed to save expense"
                Log.e(TAG, "❌ $errorMsg", e)
                _state.update { it.copy(amountError = errorMsg) }
            }
        }
    }

    private fun validateExpense(expense: Expense): String? {
        // Validate amount
        if (expense.amount == null) {
            return "Amount is required"
        }
        if (expense.amount <= 0) {
            return "Amount must be greater than 0"
        }

        // Validate date
        if (expense.date <= 0) {
            return "Valid date is required"
        }

        // All validations passed
        return null
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
                _state.update { it.copy(amountError = "Failed to delete expense") }
            }
        }
    }
}