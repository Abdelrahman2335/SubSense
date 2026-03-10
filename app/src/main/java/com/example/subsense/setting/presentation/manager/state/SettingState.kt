package com.example.subsense.setting.presentation.manager.state

import com.example.subsense.core.data.model.Budget
import com.example.subsense.core.data.model.ExpenseCategory

data class SettingState(
    val budgetCategories: List<ExpenseCategory> = emptyList(),
    val budgetValues: List<Budget> = emptyList(),
    val isLoading: Boolean = false,
)