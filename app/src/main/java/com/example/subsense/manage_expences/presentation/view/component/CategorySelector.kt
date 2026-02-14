package com.example.subsense.manage_expences.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.subsense.core.ui.LightColors.muted
import com.example.subsense.core.ui.LightColors.mutedForeground
import com.example.subsense.manage_expences.presentation.manager.event.ExpenseEvent
import com.example.subsense.manage_expences.presentation.manager.view_model.ExpenseViewModel


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategorySelector(
    viewModel: ExpenseViewModel

) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(26.dp))

            .background(muted)
            .drawBehind {
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.3f)
                        ),
                        startY = size.height,
                        endY = size.height + 16.dp.toPx()

                    ),
                    topLeft = Offset(0f, size.height),
                    size = size.copy(height = 16.dp.toPx())
                )
            }
            .fillMaxWidth()
            .heightIn(min = 230.dp),

        contentAlignment = Alignment.Center

    ) {

        Column(modifier = Modifier.padding(top = 16.dp, start = 22.dp, bottom = 4.dp)) {

            Text(
                text = "Category",
                color = mutedForeground,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,

                )
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
//                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                state.categories.forEach { category ->
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(category.color)
                            .clickable { viewModel.onEvent(ExpenseEvent.SetCategory(category)) }
                            .then(
                                if (state.expense.category == category) {
                                    Modifier.border(
                                        width = 3.dp,
                                        color = MaterialTheme.colorScheme.primary,
                                        shape = CircleShape
                                    )
                                } else {
                                    Modifier
                                }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = category.icon,
                            contentDescription = category.displayName,
                            tint = Color.White,
                        )
                    }
                }
            }
        }
    }
}