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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.subsense.manage_expences.presentation.manager.event.ManageExpenseEvent
import com.example.subsense.manage_expences.presentation.manager.view_model.ManageExpenseViewModel


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategorySelector(
    viewModel: ManageExpenseViewModel

) {
    val state by viewModel.state.collectAsStateWithLifecycle()
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
                .padding(16.dp)
        ) {

            Text(
                text = "Category",
                fontWeight = FontWeight.SemiBold,
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
                            .clickable { viewModel.onEvent(ManageExpenseEvent.SetCategory(category)) }
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