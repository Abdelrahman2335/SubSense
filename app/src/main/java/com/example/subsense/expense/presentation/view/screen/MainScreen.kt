package com.example.subsense.expense.presentation.view.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.subsense.core.composes.CustomTopBar
import com.example.subsense.core.ui.Constraints.TITLE_HOME
import com.example.subsense.expense.presentation.view.component.HomeFloatingButton
import com.example.subsense.expense.presentation.view.component.HomeScreenBody
import com.example.subsense.manage_expences.presentation.view.component.ManageExpenseBody

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var navigate by remember { mutableStateOf(false) }
    Scaffold(

        containerColor = MaterialTheme.colorScheme.background,
        topBar = { CustomTopBar(TITLE_HOME, onClick = {}) },
        floatingActionButton = { HomeFloatingButton(onClick = { navigate = !navigate }) },
        bottomBar = {},
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        if (navigate) {
            ManageExpenseBody(modifier = Modifier.padding(innerPadding))

        } else {
            HomeScreenBody(modifier = Modifier.padding(innerPadding))

        }
    }
}