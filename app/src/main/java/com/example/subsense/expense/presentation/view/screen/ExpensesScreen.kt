package com.example.subsense.expense.presentation.view.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.subsense.core.composes.CustomFloatingButton
import com.example.subsense.core.composes.CustomTopBar
import com.example.subsense.core.ui.Constraints.TITLE_HOME
import com.example.subsense.expense.presentation.view.component.HomeScreenBody


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpensesScreen(
    onFABClick: () -> Unit,
) {
    Scaffold(

        containerColor = MaterialTheme.colorScheme.background,
        topBar = { CustomTopBar(TITLE_HOME, onClick = {}) },
        floatingActionButton = {
            CustomFloatingButton(
                onClick = onFABClick,
                Icons.Outlined.Add,
                "Add Expense"
            )
        },
        bottomBar = {},
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        HomeScreenBody(innerPadding = innerPadding)

    }
}