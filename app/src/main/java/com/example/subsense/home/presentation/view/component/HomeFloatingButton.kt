package com.example.subsense.home.presentation.view.component

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun HomeFloatingButton() {
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.tertiary,
        shape = CircleShape,
        onClick = { }
    ) {

        Icon(
            imageVector = Icons.Outlined.Add,
            contentDescription = "Add Expense",
        )


    }
}