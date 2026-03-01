package com.example.subsense.debts.data.repository

import com.example.subsense.debts.data.model.DebtModel
import kotlinx.coroutines.flow.Flow

interface DebtRepo {
    fun getMoneyLent(): Flow<List<DebtModel>>
    fun getMoneyBorrowed(): Flow<List<DebtModel>>
}