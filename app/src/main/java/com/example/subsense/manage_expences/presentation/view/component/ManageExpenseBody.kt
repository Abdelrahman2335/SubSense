package com.example.subsense.manage_expences.presentation.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.subsense.manage_expences.presentation.manager.event.ExpenseEvent
import com.example.subsense.manage_expences.presentation.manager.view_model.ExpenseViewModel

@Composable
fun ManageExpenseBody(
    viewModel: ExpenseViewModel = hiltViewModel<ExpenseViewModel>(),
    modifier: Modifier
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LazyColumn(
        modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(23.dp)
    ) {
        item {
            CustomField(
                "Amount",
                "0.00",
                onValueChange = { viewModel.onEvent(ExpenseEvent.SetAmount(it.toLong())) },
                value = state.expense.amount.toString(),
            )
        }
        item { CategorySelector() }
        item {
            DatePickerField(
                selectedDate = "",
                onDateSelected = { },
                label = "Date"
            )

        }
        item {
            CustomField(
                "Note",
                "Add a note (optional)",
                onValueChange = { viewModel.onEvent(ExpenseEvent.SetNote(it)) },
                value = state.expense.note ?: "",
            )
        }
        item { RepeatExpense() }

        item {
            ElevatedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ) { }
        }

    }

}
