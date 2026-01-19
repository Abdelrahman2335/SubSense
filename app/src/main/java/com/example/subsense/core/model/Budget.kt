package com.example.subsense.core.model

data class Budget(
    val id: Long,
    val category:  ExpenseCategory,
    val limitAmount: Long, // cents
    val month: Int, // 1-12
    val year: Int
)