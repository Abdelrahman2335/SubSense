package com.example.subsense.core.notification.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notification")
data class Notification(
    @PrimaryKey
    val notificationType: NotificationType,
    val isEnabled: Boolean
)
