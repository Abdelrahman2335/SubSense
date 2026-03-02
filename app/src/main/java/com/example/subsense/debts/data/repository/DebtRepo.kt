package com.example.subsense.debts.data.repository

import com.example.subsense.debts.data.model.DebtModel
import com.example.subsense.debts.data.model.DebtStatus
import kotlinx.coroutines.flow.Flow

interface DebtRepo {
    fun getMoneyLent(): Flow<List<DebtModel>>
    fun getMoneyBorrowed(): Flow<List<DebtModel>>
    suspend fun changeStatus(id: Long, status: DebtStatus)

    suspend fun deleteDebt(debt: DebtModel)

}