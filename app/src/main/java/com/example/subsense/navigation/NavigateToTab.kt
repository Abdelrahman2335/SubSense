package com.example.subsense.navigation

import androidx.navigation.NavController

fun NavController.navigateToTab(screen: Any) {
    navigate(screen) {
        popUpTo(graph.startDestinationId) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}