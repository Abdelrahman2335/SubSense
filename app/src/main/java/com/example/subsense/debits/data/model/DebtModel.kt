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
    val date: Long = System.currentTimeMillis(),
    val note: String?,
    val status: DebtStatus = DebtStatus.PENDING

)

enum class DebtStatus {
    PENDING,
    OVERDUE,
    PAID,
    PARTIALLY_PAID,
    CANCELLED
}

enum class DebtType {
    LENT,
    BORROWED
}