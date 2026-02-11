package com.example.subsense.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.subsense.setting.data.model.RecurringPattern

@Entity
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val amount: Long, // cents
    val category: ExpenseCategory,
    val date: Long, // timestamp
    val note: String?,
    val isRecurring: Boolean,
    val recurringPattern: RecurringPattern?  // null if not recurring
)