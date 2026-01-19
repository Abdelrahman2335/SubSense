package com.example.subsense.core.model

import com.example.subsense.setting.data.model.RecurringPattern

data class Expense(
    val id: Long,
    val amount: Long, // cents
    val category: ExpenseCategory,
    val date:  Long, // timestamp
    val note: String,
    val isRecurring: Boolean,
    val recurringPattern: RecurringPattern?  // null if not recurring
)