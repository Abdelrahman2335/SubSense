package com.example.subsense.manage_expences.presentation.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ManageExpenseBody(modifier: Modifier) {

    LazyColumn(
        modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(23.dp)
    ) {
        item { CustomField("Amount", "0.00") }
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
                head = "Note",
                text = "Add a note (optional)"
            )
        }
        item { RepeatExpense() }

    }

}
