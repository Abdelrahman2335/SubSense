package com.example.subsense.core.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.subsense.manage_expences.data.repository.ManageExpensesDao

@Database(
    entities = [Expense::class],
    version = 1,
)
abstract class ExpensesDatabase : RoomDatabase() {
    abstract val dao: ManageExpensesDao
}