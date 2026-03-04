package com.example.subsense.manage_debts.presentation.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.subsense.core.composes.CustomButton
import com.example.subsense.core.composes.CustomField
import com.example.subsense.core.composes.DatePickerField
import com.example.subsense.core.util.toDateString
import com.example.subsense.manage_debts.presentation.manager.event.ManageDebtsEvent
import com.example.subsense.manage_debts.presentation.manager.view_model.ManageDebtViewModel

@Composable
fun ManageDebtsScreenBody(
    viewModel: ManageDebtViewModel = hiltViewModel<ManageDebtViewModel>(),
    modifier: Modifier,
    onBack: () -> Unit
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val onEvent: (ManageDebtsEvent) -> Unit = viewModel::onEvent

    LaunchedEffect(state.isSaved) {
        if (state.isSaved) {
            onBack()
        }
    }

    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(top = 21.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(23.dp)

    ) {
        item {
            DebtTypeSelection(state, onEvent = onEvent)
        }
        item {
            CustomField(
                head = "Person's Name",
                placeholder = "Enter name",
                onValueChange = { onEvent(ManageDebtsEvent.SetName(it)) },
                value = state.debt.name,
                errorMessage = state.nameError,
                enableLeadingIcon = false
            )
        }
        item {
            CustomField(
                head = "Amount",
                placeholder = "Enter Amount",
                onValueChange = { onEvent(ManageDebtsEvent.SetAmount(it)) },
                value = state.debt.amount?.toString() ?: "",
                errorMessage = state.amountError,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                )
            )
        }
        item {
            DatePickerField(
                selectedDate = state.debt.dueDate.toDateString(),
                onDateSelected = { onEvent(ManageDebtsEvent.SetDueDate(it)) }
            )
        }
        item {
            CustomField(
                head = "Note",
                placeholder = "What was this for?",
                onValueChange = { onEvent(ManageDebtsEvent.SetNote(it)) },
                value = state.debt.note ?: "",
                errorMessage = null,
            )
        }
        item {
            CustomButton(
                onClick = { onEvent(ManageDebtsEvent.SaveDebt) },
            )
        }
    }
}
