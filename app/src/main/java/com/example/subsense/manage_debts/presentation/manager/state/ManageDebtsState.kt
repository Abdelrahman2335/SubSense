package com.example.subsense.manage_debts.presentation.manager.state

import com.example.subsense.debts.data.model.DebtModel
import com.example.subsense.debts.data.model.DebtStatus
import com.example.subsense.debts.data.model.DebtType

data class ManageDebtsState(
    val debt: DebtModel = DebtModel(
        id = 0,
        debtType = DebtType.LENT,
        name = "",
        amount = 0.0,
        dueDate = System.currentTimeMillis(),
        note = "",
        status = DebtStatus.Pending
    ),
    val amountError: String? = null,
    val nameError: String? = null,
    val dueDateError: String? = null,
    val isSaved: Boolean = false
)
