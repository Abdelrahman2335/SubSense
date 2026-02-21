package com.example.subsense.debits.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.Block
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.PieChart
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Represents debt statuses with visual attributes for UI display.
 */
sealed class DebtStatus(
    val id: String,
    val displayName: String,
    val color: Color,
    val icon: ImageVector
) {
    data object Pending : DebtStatus(
        id = "pending",
        displayName = "Pending",
        color = Color(0xFFFBC02D), // Amber
        icon = Icons.Outlined.AccessTime
    )

    data object Overdue : DebtStatus(
        id = "overdue",
        displayName = "Overdue",
        color = Color(0xFFEF5350), // Red
        icon = Icons.Outlined.ErrorOutline
    )

    data object Paid : DebtStatus(
        id = "paid",
        displayName = "Paid",
        color = Color(0xFF4CAF50), // Green
        icon = Icons.Outlined.CheckCircle
    )

    data object PartiallyPaid : DebtStatus(
        id = "partially_paid",
        displayName = "Partially Paid",
        color = Color(0xFF29B6F6), // Light Blue
        icon = Icons.Outlined.PieChart
    )

    data object Cancelled : DebtStatus(
        id = "cancelled",
        displayName = "Cancelled",
        color = Color(0xFF9E9E9E), // Grey
        icon = Icons.Outlined.Block
    )

    companion object {
        fun getAllStatuses(): List<DebtStatus> = listOf(
            Pending,
            Overdue,
            Paid,
            PartiallyPaid,
            Cancelled
        )

        fun fromId(id: String): DebtStatus? = getAllStatuses().find { it.id == id }
    }
}
