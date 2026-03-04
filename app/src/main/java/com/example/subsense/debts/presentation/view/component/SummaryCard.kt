package com.example.subsense.debts.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.subsense.core.ui.LightColors.mutedForeground
import com.example.subsense.core.util.formatCurrency


@Composable
fun SummaryCard(
    title: String,
    icon: ImageVector,
    color: Color,
    amount: Int,
    pending: Int,
) {

    val formattedAmount = amount.formatCurrency()

    Box(
        modifier = Modifier
            .padding(top = 19.dp)
            .fillMaxWidth()
            .shadow(elevation = 9.dp, shape = RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .clip(RoundedCornerShape(16.dp))

    ) {
        Column(Modifier.padding(21.dp)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(9.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = color
                )
                Text(
                    title,
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            Spacer(Modifier.padding(bottom = 4.dp))
            Text(
                formattedAmount,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.SemiBold,
                color = color
            )
            Text(
                "$pending pending",
                style = MaterialTheme.typography.bodyLarge,
                color = mutedForeground
            )
        }
    }
}