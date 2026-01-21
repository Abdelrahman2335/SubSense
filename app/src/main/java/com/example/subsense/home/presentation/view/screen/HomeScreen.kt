package com.example.subsense.home.presentation.view.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.subsense.home.presentation.view.component.HomeScreenBody
import com.example.subsense.home.presentation.view.component.HomeTopBar


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen(){

        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = { HomeTopBar() },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            HomeScreenBody(
                modifier = Modifier.padding(innerPadding
                )
            )
        }
}
