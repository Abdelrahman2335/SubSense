package com.example.subsense.core.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.subsense.core.util.Converters
import com.example.subsense.expense.data.dao.ExpenseDao
import com.example.subsense.manage_expences.data.dao.ManageExpensesDao

@Database(
    entities = [Expense::class, Budget::class],
    version = 1,
)

@TypeConverters(Converters::class)
abstract class ExpensesDatabase : RoomDatabase() {
    abstract val manageExpensesDao: ManageExpensesDao
    abstract val expenseDao: ExpenseDao
}