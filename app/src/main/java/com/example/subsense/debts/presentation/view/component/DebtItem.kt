package com.example.subsense.debts.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.subsense.core.util.toDateString
import com.example.subsense.debts.data.model.DebtModel


@Composable
fun DebtItem(
    debtModel: DebtModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
            .shadow(9.dp, shape = RoundedCornerShape(16.dp), clip = false)
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp, vertical = 24.dp),
        verticalAlignment = Alignment.CenterVertically


    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                debtModel.name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                debtModel.dueDate.toDateString(),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
            Row(
                Modifier
                    .fillMaxWidth(0.5f)
                    .clip(RoundedCornerShape(16.dp))
                    .background(debtModel.status.color.copy(0.2f))

                    .padding(6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Icon(
                    imageVector = debtModel.status.icon,
                    contentDescription = null,
                    tint = debtModel.status.color,
                    modifier = Modifier
                        .size(16.dp)

                )

                Text(debtModel.status.displayName, color = debtModel.status.color)
            }


        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            debtModel.amount.toString(),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,

            modifier = Modifier.padding(end = 16.dp)
        )


    }

}
