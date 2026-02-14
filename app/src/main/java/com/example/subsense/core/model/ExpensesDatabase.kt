package com.example.subsense.core.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.subsense.core.data.Converters
import com.example.subsense.manage_expences.data.repository.ManageExpensesDao

@Database(
    entities = [Expense::class],
    version = 1,
)

@TypeConverters(Converters::class)
abstract class ExpensesDatabase : RoomDatabase() {
    abstract val dao: ManageExpensesDao
}