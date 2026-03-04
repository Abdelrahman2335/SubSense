package com.example.subsense.core.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "budget")
data class Budget(
    @PrimaryKey
    val categoryId: String,
    val limitAmount: Int,
    val month: Int, // 1-12
    val year: Int
)