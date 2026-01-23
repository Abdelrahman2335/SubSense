package com.example.subsense.manage_expences.presentation.view.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.subsense.core.composes.CustomTopBar
import com.example.subsense.core.ui.Constraints.TITLE_ADD_EXPENSE
import com.example.subsense.manage_expences.presentation.view.component.ManageExpenseBody

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageExpenseScreen() {
    Scaffold(

        topBar = {
            CustomTopBar(TITLE_ADD_EXPENSE, true) {}
        }
    ) { innerPadding ->
        ManageExpenseBody(modifier = Modifier.padding(innerPadding))

    }
}