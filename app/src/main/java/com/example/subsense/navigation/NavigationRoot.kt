package com.example.subsense.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.subsense.expense.presentation.view.screen.ExpensesScreen
import com.example.subsense.manage_expences.presentation.view.screen.ManageExpenseScreen
import kotlinx.serialization.Serializable


@Serializable
data object ExpenseScreen

@Serializable
data object AddExpensesScreen

@Serializable
data class EditExpenseScreen(val id: String)

@Composable
fun NavigationRoot(
    modifier: Modifier
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ExpenseScreen,
        modifier = modifier
    ) {
        composable<ExpenseScreen> {
            ExpensesScreen(
                onFABClick = {
                    navController.navigate(AddExpensesScreen)
                }
            )
        }

        composable<AddExpensesScreen> {
            ManageExpenseScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}