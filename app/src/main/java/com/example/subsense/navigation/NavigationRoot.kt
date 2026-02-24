package com.example.subsense.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.subsense.core.ui.Constraints.DEBT_SCREEN
import com.example.subsense.core.ui.Constraints.EXPENSE_SCREEN

@Composable
fun NavigationRoot(
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = currentRoute?.contains(EXPENSE_SCREEN) == true,
                    onClick = {
                        navController.navigate(ExpenseScreen) {

                            popUpTo(ExpenseScreen) { inclusive = true }
                            launchSingleTop = true

                        }
                    },
                    icon = { Icon(Icons.Default.AccountBalanceWallet, contentDescription = null) },
                    label = { Text("Expenses") }
                )
                NavigationBarItem(
                    selected = currentRoute?.contains(DEBT_SCREEN) == true,
                    onClick = {
                        navController.navigate(DebtScreen) {

                            popUpTo(ExpenseScreen) { inclusive = true }
                            launchSingleTop = true

                        }
                    },
                    icon = { Icon(Icons.Default.Handshake, contentDescription = null) },
                    label = { Text("Debt") }
                )
            }
        }
    ) { paddingValues ->
        NavigationGraph(
            navController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}