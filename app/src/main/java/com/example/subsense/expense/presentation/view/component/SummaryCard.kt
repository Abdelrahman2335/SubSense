package com.example.subsense.expense.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.subsense.core.ui.LightColors.accent
import com.example.subsense.core.ui.LightColors.mutedForeground
import com.example.subsense.core.util.formatCurrency

@Composable
fun SummaryCard(
    totalSpent: Int
) {
    val amount2 = 1500 // dummy

    val formattedAmount = totalSpent.formatCurrency()
    val formattedAmount2 = amount2.formatCurrency()

    Box(
        modifier = Modifier
            .padding(top = 19.dp)
            .fillMaxWidth()
            .height(220.dp)
            .shadow(elevation = 9.dp, shape = RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .clip(RoundedCornerShape(16.dp))

    ) {

        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 19.dp, end = 16.dp)

        ) {

            Text(
                "Total Spent This Month",
                style = MaterialTheme.typography.titleMedium,
                color = mutedForeground
            )
            Spacer(Modifier.padding(bottom = 4.dp))
            Text(
                formattedAmount,
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.padding(bottom = 13.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween


            ) {
                Text(
                    "Budget Usage",
                    style = MaterialTheme.typography.bodyLarge,
                    color = mutedForeground
                )
                Text("82%", style = MaterialTheme.typography.bodyLarge, color = accent)

            }
            Spacer(Modifier.padding(bottom = 6.dp))

            LinearProgressIndicator(
                color = accent,
                progress = { 0.65f }, // 65% progress
                modifier = Modifier
                    .fillMaxWidth()
                    .height(9.dp)
            )
            Spacer(Modifier.padding(bottom = 8.dp))
            Text(
                "$formattedAmount of $formattedAmount2 budget",
                style = MaterialTheme.typography.labelLarge,
                color = mutedForeground
            )


        }

    }
}