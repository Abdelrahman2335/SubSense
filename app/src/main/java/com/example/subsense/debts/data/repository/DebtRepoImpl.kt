package com.example.subsense.debts.data.repository

import com.example.subsense.debts.data.dao.DebtDao
import com.example.subsense.debts.data.model.DebtModel
import com.example.subsense.debts.data.model.DebtStatus
import com.example.subsense.debts.data.model.DebtType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class DebtRepoImpl @Inject constructor(
    private val debtDao: DebtDao
) : DebtRepo {
    override fun getMoneyLent(): Flow<List<DebtModel>> {
        return debtDao.getDebtsByType(DebtType.LENT)
    }

    override fun getMoneyBorrowed(): Flow<List<DebtModel>> {
        return debtDao.getDebtsByType(DebtType.BORROW)
    }

    override suspend fun changeStatus(
        id: Long,
        status: DebtStatus
    ) {
        debtDao.changeStatus(id, status)
    }

    override suspend fun deleteDebt(debt: DebtModel) {
        debtDao.deleteDebt(debt)
    }
}