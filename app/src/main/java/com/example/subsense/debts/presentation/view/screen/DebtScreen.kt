package com.example.subsense.debts.presentation.view.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.subsense.core.composes.CustomFloatingButton
import com.example.subsense.core.composes.CustomTopBar
import com.example.subsense.core.ui.Constraints.TITLE_DEBIT
import com.example.subsense.debts.presentation.view.component.DebtScreenBody


@Composable
fun DebtScreen(
    onFABClick: () -> Unit,

    ) {
    Scaffold(

        containerColor = MaterialTheme.colorScheme.background,
        topBar = { CustomTopBar(TITLE_DEBIT, onClick = {}) },
        floatingActionButton = {
            CustomFloatingButton(
                onClick = onFABClick,
                Icons.Outlined.Add,
                "Add Debit"
            )
        },
        bottomBar = {},
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        DebtScreenBody(innerPadding = innerPadding)
    }


}
