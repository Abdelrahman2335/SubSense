package com.example.subsense.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "budget")
data class Budget(
    @PrimaryKey(true)
    val id: Long,
    val category: ExpenseCategory,
    val limitAmount: Long, // cents
    val month: Int, // 1-12
    val year: Int
)