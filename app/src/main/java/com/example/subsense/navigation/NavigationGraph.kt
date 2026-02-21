package com.example.subsense.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.subsense.debits.presentation.view.screen.DebtScreen
import com.example.subsense.expense.presentation.view.screen.ExpensesScreen
import com.example.subsense.manage_expences.presentation.view.screen.ManageExpenseScreen
import kotlinx.serialization.Serializable


@Serializable
data object ExpenseScreen

@Serializable
data object DebtScreen

@Serializable
data object AddExpensesScreen

@Serializable
data class EditExpenseScreen(val id: String)

@Composable
fun NavigationGraph(
    navController: NavHostController,

    modifier: Modifier
) {

    val navController = navController

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

        composable<DebtScreen> {
            DebtScreen(onFABClick = {})
        }

        composable<AddExpensesScreen> {
            ManageExpenseScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}