package com.example.subsense.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.subsense.debts.presentation.view.screen.DebtScreen
import com.example.subsense.expense.presentation.view.screen.ExpensesScreen
import com.example.subsense.manage_debts.presentation.view.screen.ManageDebtsScreen
import com.example.subsense.manage_expences.presentation.view.screen.ManageExpenseScreen
import com.example.subsense.setting.presentation.view.screen.SettingScreen
import kotlinx.serialization.Serializable


@Serializable
data object ExpenseScreen


@Serializable
data object ManageExpensesScreen

@Serializable
data object DebtScreen

@Serializable
data object ManageDebtScreen


@Serializable
data object SettingScreen


@Serializable
data class EditExpenseScreen(val id: String) // will be removed later

@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier
) {

    NavHost(
        navController = navController,
        startDestination = ExpenseScreen,
        modifier = modifier
    ) {
        composable<ExpenseScreen> {
            ExpensesScreen(
                onFABClick = {
                    navController.navigate(ManageExpensesScreen)
                }
            )
        }

        composable<DebtScreen> {
            DebtScreen(onFABClick = {
                navController.navigate(ManageDebtScreen)
            })
        }

        composable<ManageExpensesScreen> {
            ManageExpenseScreen(
                onBack = { navController.popBackStack() }
            )
        }
        composable<ManageDebtScreen> {
            ManageDebtsScreen(
                onBack = { navController.popBackStack() }
            )
        }
        composable<SettingScreen> {
            SettingScreen()
        }
    }
}