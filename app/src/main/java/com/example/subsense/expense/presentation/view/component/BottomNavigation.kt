package com.example.subsense.expense.presentation.view.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.Handshake
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BottomNavigation(
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {

    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == "expense",
            onClick = { onNavigate("expense") },
            icon = {
                Icon(
                    imageVector = if (currentRoute == "expense") Icons.Filled.AccountBalanceWallet else Icons.Outlined.AccountBalanceWallet,
                    contentDescription = "expense"
                )
            },
            label = { Text("Expense") }
        )
        NavigationBarItem(
            selected = currentRoute == "debts",
            onClick = { onNavigate("debts") },
            icon = {
                Icon(
                    imageVector = if (currentRoute == "debts") Icons.Filled.Handshake else Icons.Outlined.Handshake,
                    contentDescription = "Debts"
                )
            },
            label = { Text("Debts") }
        )
        NavigationBarItem(
            selected = currentRoute == "settings",
            onClick = { onNavigate("settings") },
            icon = {
                Icon(
                    imageVector = if (currentRoute == "settings") Icons.Filled.Settings else Icons.Outlined.Settings,
                    contentDescription = "Settings"
                )
            },
            label = { Text("Settings") }
        )

    }
}