package com.example.subsense.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.subsense.setting.data.model.RecurringPattern

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val amount: Float?,
    val category: ExpenseCategory,
    val date: Long = System.currentTimeMillis(), // timestamp in milliseconds
    val note: String?,
    val isRecurring: Boolean,
    val recurringPattern: RecurringPattern?  // null if not recurring
)