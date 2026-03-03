package com.example.subsense.manage_debts.data.repository

import ManageDebtsDao
import com.example.subsense.debts.data.model.DebtModel
import javax.inject.Inject

class ManageDebtRepoImpl @Inject constructor(
    private val dao: ManageDebtsDao
) : ManageDebtRepo {
    override suspend fun upsertDebt(debt: DebtModel) {
        dao.upsertDebt(debt)
    }
}
