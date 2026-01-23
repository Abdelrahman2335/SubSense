package com.example.subsense.expense.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.subsense.core.model.Expense
import java.text.NumberFormat
import java.util.Locale


@Composable
fun ExpenseCard(
    expense: Expense,

    ) {


    val formattedAmount =
        NumberFormat.getCurrencyInstance(Locale.US).format(expense.amount) // Put it in the VM
    val category = expense.category
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
            .shadow(elevation = 9.dp, shape = RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .clip(RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp),

        verticalAlignment = Alignment.CenterVertically


    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .size(48.dp)
                .clip(CircleShape)
                .background(category.color),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = category.icon,
                contentDescription = category.displayName,
                tint = Color.White,
            )
        }
        Column {
            Text(
                expense.note ?: "",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                "Today",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            formattedAmount,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,

            modifier = Modifier.padding(end = 16.dp)
        )

    }
}