package com.example.subsense.expense.presentation.view.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.subsense.core.ui.Constraints.TITLE_HOME
import com.example.subsense.core.ui.LightColors.primary
import com.example.subsense.core.ui.LightColors.primaryForeground


@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar() {
    TopAppBar(
        title = { Text(TITLE_HOME, style = MaterialTheme.typography.titleLarge) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = primary,
            titleContentColor = primaryForeground
        )
    )
}