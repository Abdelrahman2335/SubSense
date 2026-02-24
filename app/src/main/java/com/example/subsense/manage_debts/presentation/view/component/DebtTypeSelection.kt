package com.example.subsense.manage_debts.presentation.view.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingDown
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.subsense.core.ui.LightColors.accent
import com.example.subsense.core.ui.LightColors.destructive
import com.example.subsense.core.ui.LightColors.secondaryForeground


@Composable
fun DebtTypeSelection() {

    // Should add boolean to show the color of the button

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = "Debt Type",

                fontWeight = FontWeight.SemiBold,
                color = secondaryForeground,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(
                    24.dp,
                    alignment = Alignment.CenterHorizontally
                ),
            ) {
                OutlinedButton(

                    colors = ButtonColors(
                        containerColor = accent.copy(0.1f),
                        contentColor = accent,
                        disabledContainerColor = accent,
                        disabledContentColor = accent
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = accent,
                    ),
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.TrendingUp,
                        contentDescription = null,
                        tint = accent,
                        modifier = Modifier.size(18.dp)

                    )
                    Text(
                        "Lent", color = accent,
                        modifier = Modifier.padding(9.dp)
                    )
                }
                OutlinedButton(
                    colors = ButtonColors(
                        containerColor = destructive.copy(0.1f),
                        contentColor = destructive,
                        disabledContainerColor = destructive,
                        disabledContentColor = destructive
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = destructive,
                    ),
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.TrendingDown,
                        contentDescription = null,
                        tint = destructive,

                        modifier = Modifier.size(18.dp)
                    )

                    Text(
                        "Borrowed", color = destructive,
                        modifier = Modifier.padding(9.dp)

                    )
                }

            }
        }

    }
}