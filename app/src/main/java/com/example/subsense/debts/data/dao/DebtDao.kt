package com.example.subsense.debts.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.subsense.debts.data.model.DebtModel
import com.example.subsense.debts.data.model.DebtType
import kotlinx.coroutines.flow.Flow

@Dao
interface DebtDao {

    @Query("SELECT * FROM debt WHERE debtType = :debtType ORDER BY dueDate DESC ")
    fun getDebtsByType(debtType: DebtType): Flow<List<DebtModel>>
}