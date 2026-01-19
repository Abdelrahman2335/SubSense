package com.example.subsense.home.presentation.view.screen

import android.provider.CalendarContract
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.subsense.core.ui.Constraints.TITLE_HOME
import com.example.subsense.home.presentation.view.component.HomeScreenBody


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen(){

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(TITLE_HOME) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    )
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            HomeScreenBody(
                modifier = Modifier.padding(innerPadding
                )
            )
        }
}