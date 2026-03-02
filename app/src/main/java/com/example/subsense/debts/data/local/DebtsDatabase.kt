package com.example.subsense.debts.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.subsense.debts.data.local.converter.DebtConverters
import com.example.subsense.debts.data.local.dao.DebtDao
import com.example.subsense.debts.data.model.DebtModel
import com.example.subsense.debts.data.model.DebtStatus
import com.example.subsense.debts.data.model.DebtType

@Database(
    entities = [DebtModel::class, DebtType::class, DebtStatus::class],
    version = 1,
)
@TypeConverters(DebtConverters::class)
abstract class DebtsDatabase : RoomDatabase() {
    abstract val debtDao: DebtDao
}