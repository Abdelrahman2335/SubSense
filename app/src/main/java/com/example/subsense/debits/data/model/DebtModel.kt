package com.example.subsense.debits.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "debt")
data class DebtModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val debtType: DebtType,
    val name: String,
    val amount: Float?,
    val dueDate: Long = System.currentTimeMillis(),
    val note: String?,
    val status: DebtStatus = DebtStatus.Pending
)
