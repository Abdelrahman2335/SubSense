package com.example.subsense.setting.presentation.manager.view_model

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.subsense.core.data.model.Budget
import com.example.subsense.core.data.model.ExpenseCategory
import com.example.subsense.setting.data.repository.SettingRepo
import com.example.subsense.setting.presentation.manager.event.SettingEvent
import com.example.subsense.setting.presentation.manager.state.SettingState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val repository: SettingRepo,
) : ViewModel() {

    private val _state = MutableStateFlow(SettingState())
    val state: StateFlow<SettingState> = _state.asStateFlow()

    init {
        initBudgetCategories()
    }

    companion object {
        private const val TAG = "SettingViewModel"
    }

    fun onEvent(event: SettingEvent) {
        when (event) {
            is SettingEvent.UpsertBudget -> {
                viewModelScope.launch {
                    repository.upsertBudget(event.budget)
                }
            }
        }
    }

    private fun initBudgetCategories() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            repository.getBudgets().collect { budgets ->
                val categories = ExpenseCategory.getAllCategories()
                if (budgets.isEmpty()) {
                    val defaults = categories.map {
                        Budget(
                            categoryId = it.id,
                            limitAmount = 0,
                        )
                    }
                    repository.upsertBudget(defaults)
                    _state.update {
                        it.copy(
                            budgetCategories = categories,
                            budgetValues = defaults,
                            isLoading = false
                        )
                    }
                } else {
                    _state.update {
                        it.copy(
                            budgetCategories = categories,
                            budgetValues = budgets,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }

}