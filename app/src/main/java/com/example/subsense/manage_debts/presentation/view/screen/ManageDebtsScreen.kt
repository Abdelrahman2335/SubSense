package com.example.subsense.manage_debts.presentation.view.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.subsense.core.composes.CustomTopBar
import com.example.subsense.core.ui.Constraints.TITLE_ADD_DEBIT
import com.example.subsense.manage_debts.presentation.view.component.ManageDebtsScreenBody

@Composable
fun ManageDebtsScreen(
    onBack: () -> Unit

) {
    Scaffold(
        topBar = {
            CustomTopBar(TITLE_ADD_DEBIT, true) {
                onBack()
            }
        }
    ) { innerPadding ->
        ManageDebtsScreenBody(Modifier.padding(innerPadding))
    }
}

