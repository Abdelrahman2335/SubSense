package com.example.subsense.setting.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Notification")
data class Notification(
    @PrimaryKey
    val notificationType: String,
    val isEnabled: Boolean
)
