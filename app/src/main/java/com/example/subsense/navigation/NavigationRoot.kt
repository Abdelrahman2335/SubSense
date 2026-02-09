package com.example.subsense.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.subsense.expense.presentation.view.screen.ExpensesScreen
import com.example.subsense.manage_expences.presentation.view.screen.ManageExpenseScreen
import kotlinx.serialization.Serializable


@Serializable
data object ExpenseScreen : NavKey

@Serializable
data object AddExpensesScreen : NavKey

@Serializable
data class EditExpenseScreen(val id: String) : NavKey

@Composable
fun NavigationRoot(
    modifier: Modifier
) {

    val backStack = rememberNavBackStack(ExpenseScreen)

    NavDisplay(
        modifier = modifier,
        backStack = backStack,

        entryProvider = { key ->
            when (key) {
                is ExpenseScreen -> {
                    NavEntry(
                        key = key,
                    ) {
                        ExpensesScreen(
                            onFABClick = {
                                backStack.add(AddExpensesScreen)
                            }
                        )
                    }

                }

                is AddExpensesScreen -> {
                    NavEntry(
                        key = key,
                    ) {
                        ManageExpenseScreen(
                            onClick = { backStack.removeLastOrNull() }
                        )
                    }
                }

                else -> throw RuntimeException("Invalid NavKey.")
            }
        }
    )


}