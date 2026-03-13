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
import com.example.subsense.setting.data.model.Notification

@Database(
    entities = [Expense::class, Budget::class, Notification::class],
    version = 6,
)

@TypeConverters(Converters::class)
abstract class ExpensesDatabase : RoomDatabase() {
    abstract val manageExpensesDao: ManageExpensesDao
    abstract val expenseDao: ExpenseDao

    abstract val settingDao: SettingDao
}