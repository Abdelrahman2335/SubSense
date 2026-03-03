package com.example.subsense.manage_debts.presentation.manager.event

import com.example.subsense.debts.data.model.DebtType

sealed interface ManageDebtsEvent {
    data class SetDebtType(val type: DebtType) : ManageDebtsEvent
    data class SetName(val name: String) : ManageDebtsEvent
    data class SetAmount(val amount: String) : ManageDebtsEvent
    data class SetDueDate(val date: Long) : ManageDebtsEvent
    data class SetNote(val note: String) : ManageDebtsEvent
    data object SaveDebt : ManageDebtsEvent
}
