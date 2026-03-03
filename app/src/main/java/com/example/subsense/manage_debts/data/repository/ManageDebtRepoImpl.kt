package com.example.subsense.manage_debts.data.repository

import com.example.subsense.debts.data.model.DebtModel
import com.example.subsense.manage_debts.data.dao.ManageDebtsDao
import javax.inject.Inject

class ManageDebtRepoImpl @Inject constructor(
    private val dao: ManageDebtsDao
) : ManageDebtRepo {
    override suspend fun upsertDebt(debt: DebtModel) {
        dao.upsertDebt(debt)
    }
}
