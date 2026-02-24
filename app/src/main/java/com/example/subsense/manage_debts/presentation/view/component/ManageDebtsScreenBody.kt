package com.example.subsense.manage_debts.presentation.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.subsense.core.composes.CustomButton
import com.example.subsense.core.composes.CustomField
import com.example.subsense.core.composes.DatePickerField

@Composable
fun ManageDebtsScreenBody(modifier: Modifier) {
    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(top = 21.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(23.dp)

    ) {
        item {
            DebtTypeSelection()
        }
        item {
            CustomField(
                head = "Person's Name",
                placeholder = "Enter name",
                onValueChange = {},
                value = "",
                errorMessage = null,
                enableLeadingIcon = false
            )

        }
        item {
            CustomField(
                head = "Amount",
                placeholder = "0.00",
                onValueChange = {},
                value = "",
                errorMessage = null,
            )
        }
        item {
            DatePickerField(
                selectedDate = "",
                onDateSelected = { }
            )
        }
        item {
            CustomField(
                head = "Note",
                placeholder = "What was this for?",
                onValueChange = {},
                value = "",
                errorMessage = null,
            )
        }
        item {
            CustomButton(
                onClick = {

                },
            )
        }
    }
}

