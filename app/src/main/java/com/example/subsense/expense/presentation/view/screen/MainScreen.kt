package com.example.subsense.expense.presentation.view.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.subsense.expense.presentation.view.component.BottomNavigation
import com.example.subsense.expense.presentation.view.component.HomeFloatingButton
import com.example.subsense.expense.presentation.view.component.HomeScreenBody
import com.example.subsense.expense.presentation.view.component.HomeTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = { HomeTopBar() },
        floatingActionButton = { HomeFloatingButton() },
        bottomBar = {
            BottomNavigation(
                currentRoute = currentRoute,
                onNavigate = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "expense",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("expense") {
                HomeScreenBody(modifier = Modifier)
            }
            composable("debts") {
                // your profile composable
            }
            composable("settings") {
                // your settings composable
            }
        }
    }
}