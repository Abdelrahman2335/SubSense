package com.example.subsense.debts.presentation.manager.state

import com.example.subsense.debts.data.model.DebtModel

data class DebtState(
    val totalLent: Int = 0,
    val totalLentPending: Int = 0,
    val totalBorrowPending: Int = 0,
    val totalBorrow: Int = 0,
    val moneyLent: List<DebtModel> = emptyList(),
    val moneyBorrow: List<DebtModel> = emptyList(),
    val isLoading: Boolean = false,
)