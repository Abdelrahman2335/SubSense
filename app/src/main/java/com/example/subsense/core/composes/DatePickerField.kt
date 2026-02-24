package com.example.subsense.core.composes

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.subsense.core.ui.LightColors.mutedForeground
import com.example.subsense.core.ui.LightColors.secondaryForeground
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerField(
    selectedDate: String,
    onDateSelected: (Long) -> Unit,
    label: String = "Date",
) {

    var showDatePicker by remember { mutableStateOf(false) } // ← UI state, not ViewModel

    // Parse current date or use today
    val calendar = Calendar.getInstance()
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis
    )

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
                .padding(vertical = 26.dp, horizontal = 16.dp)
        ) {
            Text(
                text = label,
                color = secondaryForeground,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .border(
                        width = 1.dp,
                        color = mutedForeground,
                        shape = RoundedCornerShape(14.dp)

                    )
                    .clickable { showDatePicker = true }

            ) {
                OutlinedTextField(
                    value = selectedDate,
                    onValueChange = { }, // Read-only
                    readOnly = true,
                    enabled = false, // ← Disable interaction
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Select date",
                            tint = mutedForeground,
                        )
                    },

                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .border(
                            width = 1.dp,
                            color = mutedForeground,
                            shape = RoundedCornerShape(14.dp)
                        )


                )
            }

        }
    }

    // Show DatePicker Dialog
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let { millis ->

                            onDateSelected(millis)
                        }
                        showDatePicker = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}