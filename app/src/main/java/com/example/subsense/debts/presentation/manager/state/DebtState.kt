package com.example.subsense.debts.presentation.manager.state

import com.example.subsense.debts.data.model.DebtModel

data class DebtState(
    val totalLent: Double = 0.0,
    val totalBorrowed: Double = 0.0,
    val moneyLent: List<DebtModel> = emptyList(),
    val moneyBorrow: List<DebtModel> = emptyList(),
    val isLoading: Boolean = false,
)