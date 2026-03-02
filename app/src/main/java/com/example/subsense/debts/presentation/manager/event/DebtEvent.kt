package com.example.subsense.debts.presentation.manager.event

import com.example.subsense.debts.data.model.DebtModel
import com.example.subsense.debts.data.model.DebtStatus

sealed interface DebtEvent {
    data class DeleteDebt(val debt: DebtModel) : DebtEvent
    data class ChangeStatus(val id: Long, val status: DebtStatus) : DebtEvent
}