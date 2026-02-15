package com.example.subsense.manage_expences.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.subsense.core.ui.LightColors.muted
import com.example.subsense.core.ui.LightColors.mutedForeground
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

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(26.dp))
            .background(muted)
            .padding(vertical = 14.dp, horizontal = 14.dp) // Control internal spacing
    ) {
        Text(
            text = label,
            color = mutedForeground,
            fontWeight = FontWeight.Bold,
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
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Red
                ),
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