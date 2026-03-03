package com.example.subsense.manage_debts.data.repository

import com.example.subsense.debts.data.model.DebtModel

interface ManageDebtRepo {
    suspend fun upsertDebt(debt: DebtModel)
}
