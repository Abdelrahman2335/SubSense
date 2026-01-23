package com.example.subsense.manage_expences.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.subsense.core.ui.LightColors.muted
import com.example.subsense.core.ui.LightColors.mutedForeground
import com.example.subsense.setting.data.model.Frequency

@Composable
fun RepeatExpense() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 200.dp)
            .drawWithContent {
                drawContent()
                // Bottom shadow (drawn outside below the content)
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.15f),
                            Color.Transparent
                        )
                    ),
                    topLeft = Offset(0f, size.height),
                    size = Size(width = size.width, height = 8.dp.toPx())
                )
                // Right shadow (drawn outside to the right)
                drawRect(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.15f),
                            Color.Transparent
                        )
                    ),
                    topLeft = Offset(size.width, 0f),
                    size = Size(width = 8.dp.toPx(), height = size.height)
                )
            }
            .padding(end = 8.dp, bottom = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 200.dp)
                .clip(RoundedCornerShape(26.dp))
                .background(muted),
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column {
                        Text(
                            "Repeat this expense",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "Set up a recurring expense",
                            style = MaterialTheme.typography.bodyMedium,
                            color = mutedForeground,
                        )
                    }
                    Switch(
                        checked = true,
                        onCheckedChange = { }
                    )

                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 51.dp, vertical = 4.dp)
                        .height(2.dp)
                        .background(mutedForeground.copy(alpha = 0.3f))
                )

                Text(
                    "Pattern",
                    style = MaterialTheme.typography.titleSmall,
                    color = mutedForeground
                )
                Row {
                    for (frequency in Frequency.entries) {
                        OutlinedButton(
                            modifier = Modifier.padding(4.dp),
                            onClick = {}
                        ) {
                            Text(frequency.name)
                        }
                    }
                }


            }

        }

    }
}