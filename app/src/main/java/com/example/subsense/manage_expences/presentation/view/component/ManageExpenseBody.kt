package com.example.subsense.manage_expences.presentation.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.subsense.core.ui.LightColors.mutedForeground
import com.example.subsense.core.util.toDateString
import com.example.subsense.manage_expences.presentation.manager.event.ManageExpenseEvent
import com.example.subsense.manage_expences.presentation.manager.view_model.ManageExpenseViewModel

@Composable
fun ManageExpenseBody(
    viewModel: ManageExpenseViewModel = hiltViewModel<ManageExpenseViewModel>(),
    modifier: Modifier,
    onBack: () -> Unit
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    // Navigate back when expense is saved successfully
    LaunchedEffect(state.isSaved) {
        if (state.isSaved) {
            onBack()
        }
    }

    LazyColumn(
        modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(23.dp)
    ) {
        item {
            CustomField(
                head = "Amount",
                placeholder = "0.00",
                onValueChange = { input ->
                    viewModel.onEvent(ManageExpenseEvent.SetAmountInput(input))
                },
                value = state.expense.amount?.toString() ?: "",
                errorMessage = state.amountError
            )
        }

        item {
            CategorySelector(
                viewModel = viewModel,
            )
        }

        item {
            DatePickerField(
                selectedDate = state.expense.date.toDateString(),
                onDateSelected = { millis ->
                    viewModel.onEvent(ManageExpenseEvent.SetDate(millis))
                },
            )
        }

        item {
            CustomField(
                head = "Note",
                placeholder = "Add a note (optional)",
                onValueChange = { input ->
                    viewModel.onEvent(ManageExpenseEvent.SetNote(input))
                },
                value = state.expense.note ?: "",
                errorMessage = null
            )
        }

        item {
            RepeatExpense(
                state = state,
                onEvent = viewModel::onEvent
            )
        }

        item {
            ElevatedButton(
                shape = RoundedCornerShape(14.dp),

                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .padding(bottom = 19.dp, start = 14.dp, end = 14.dp),
                onClick = {
                    viewModel.onEvent(ManageExpenseEvent.SaveExpense)

                },
                colors = ButtonColors(

                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.surface,
                    disabledContainerColor = mutedForeground,
                    disabledContentColor = mutedForeground
                )
            ) {
                Text("Save")
            }
        }
    }

}
