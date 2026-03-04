package com.example.subsense.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.subsense.core.data.model.Budget
import com.example.subsense.core.data.model.Expense
import com.example.subsense.expense.data.local.converter.Converters
import com.example.subsense.expense.data.local.dao.ExpenseDao
import com.example.subsense.manage_expences.data.local.dao.ManageExpensesDao
import com.example.subsense.setting.data.local.dao.SettingDao

@Database(
    entities = [Expense::class, Budget::class],
    version = 5,
)

@TypeConverters(Converters::class)
abstract class ExpensesDatabase : RoomDatabase() {
    abstract val manageExpensesDao: ManageExpensesDao
    abstract val expenseDao: ExpenseDao

    abstract val settingDao: SettingDao
}