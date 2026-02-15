package com.example.subsense.manage_expences.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.subsense.core.ui.LightColors.muted
import com.example.subsense.core.ui.LightColors.mutedForeground
import com.example.subsense.manage_expences.presentation.manager.event.ManageExpenseEvent
import com.example.subsense.manage_expences.presentation.manager.state.ManageExpenseState
import com.example.subsense.setting.data.model.Frequency

@Composable
fun RepeatExpense(
    state: ManageExpenseState,
    onEvent: (ManageExpenseEvent) -> Unit
) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(26.dp))
            .background(muted)
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),

        ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                "Repeat this expense",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )


            Switch(
                checked = state.expense.isRecurring,
                onCheckedChange = { onEvent(ManageExpenseEvent.SetRecurring(it)) }
            )

        }
        if (state.expense.isRecurring) {
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

                        modifier = Modifier

                            .padding(4.dp),
                        colors =
                            if (state.expense.recurringPattern?.frequency == frequency)
                                ButtonColors(

                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = MaterialTheme.colorScheme.surface,
                                    disabledContainerColor = mutedForeground,
                                    disabledContentColor = mutedForeground
                                ) else ButtonColors(

                                containerColor = MaterialTheme.colorScheme.surface,
                                contentColor = MaterialTheme.colorScheme.primary,
                                disabledContainerColor = mutedForeground,
                                disabledContentColor = mutedForeground
                            ),
                        onClick = {
                            onEvent(
                                ManageExpenseEvent.SetFrequency(
                                    frequency = frequency,
                                )
                            )

                        },

                        ) {
                        Text(frequency.name)
                    }
                }

            }
            CounterTextField(
                value = state.expense.recurringPattern!!.interval.toString(),
                onValueChange = { value ->
                    onEvent(
                        ManageExpenseEvent.SetInterval(value)
                    )
                },
                errorMessage = state.amountError
            )
        }


    }
}