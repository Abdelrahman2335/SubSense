package com.example.subsense.manage_debts.data.dao

import androidx.room.Dao
import androidx.room.Upsert
import com.example.subsense.debts.data.model.DebtModel


@Dao
interface ManageDebtsDao {

    @Upsert
    suspend fun upsertDebt(debt: DebtModel)
}