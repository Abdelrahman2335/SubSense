package com.example.subsense.debits.presentation.view.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.subsense.core.composes.CustomFloatingButton
import com.example.subsense.core.composes.CustomTopBar
import com.example.subsense.core.ui.Constraints.TITLE_DEBIT
import com.example.subsense.debits.presentation.view.component.DebitScreenBody



@Composable
fun DebitScreen(
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
        DebitScreenBody(modifier = Modifier.padding(innerPadding))
    }


}

@Preview
@Composable
fun PreviewDebitScreen(){
    DebitScreen {  }
}