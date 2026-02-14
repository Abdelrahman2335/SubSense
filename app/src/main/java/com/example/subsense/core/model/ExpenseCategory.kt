package com.example.subsense.core.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DirectionsCar
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.Flight
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocalHospital
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Pets
import androidx.compose.material.icons.outlined.Receipt
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Spa
import androidx.compose.material.icons.outlined.Subscriptions
import androidx.compose.material.icons.outlined.TheaterComedy
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Represents expense categories with visual attributes for UI display
 */
sealed class ExpenseCategory(
    val id: String,
    val displayName: String,
    val icon: ImageVector,
    val color: Color
) {
    data object FoodDining : ExpenseCategory(
        id = "food_dining",
        displayName = "Food & Dining",
        icon = Icons.Outlined.Restaurant,
        color = Color(0xFF2196F3) // Blue
    )

    data object Transportation : ExpenseCategory(
        id = "transportation",
        displayName = "Transportation",
        icon = Icons.Outlined.DirectionsCar,
        color = Color(0xFF4CAF50) // Green
    )

    data object Entertainment : ExpenseCategory(
        id = "entertainment",
        displayName = "Entertainment",
        icon = Icons.Outlined.TheaterComedy,
        color = Color(0xFFEF5350) // Red
    )

    data object Shopping : ExpenseCategory(
        id = "shopping",
        displayName = "Shopping",
        icon = Icons.Outlined.ShoppingBag,
        color = Color(0xFFFBC02D) // Yellow/Amber
    )

    data object BillsUtilities : ExpenseCategory(
        id = "bills_utilities",
        displayName = "Bills & Utilities",
        icon = Icons.Outlined.Receipt,
        color = Color(0xFFFF5722) // Orange
    )

    data object Healthcare : ExpenseCategory(
        id = "healthcare",
        displayName = "Healthcare",
        icon = Icons.Outlined.LocalHospital,
        color = Color(0xFFE91E63) // Pink
    )

    data object Education : ExpenseCategory(
        id = "education",
        displayName = "Education",
        icon = Icons.Outlined.School,
        color = Color(0xFF9C27B0) // Purple
    )

    data object Travel : ExpenseCategory(
        id = "travel",
        displayName = "Travel",
        icon = Icons.Outlined.Flight,
        color = Color(0xFF00BCD4) // Cyan
    )

    data object Groceries : ExpenseCategory(
        id = "groceries",
        displayName = "Groceries",
        icon = Icons.Outlined.ShoppingCart,
        color = Color(0xFF8BC34A) // Light Green
    )

    data object PersonalCare : ExpenseCategory(
        id = "personal_care",
        displayName = "Personal Care",
        icon = Icons.Outlined.Spa,
        color = Color(0xFFFF9800) // Deep Orange
    )

    data object GiftsDonations : ExpenseCategory(
        id = "gifts_donations",
        displayName = "Gifts & Donations",
        icon = Icons.Outlined.FavoriteBorder,
        color = Color(0xFFF06292) // Light Pink
    )

    data object HomeGarden : ExpenseCategory(
        id = "home_garden",
        displayName = "Home & Garden",
        icon = Icons.Outlined.Home,
        color = Color(0xFF795548) // Brown
    )

    data object FitnessSports : ExpenseCategory(
        id = "fitness_sports",
        displayName = "Fitness & Sports",
        icon = Icons.Outlined.FitnessCenter,
        color = Color(0xFF009688) // Teal
    )

    data object Subscriptions : ExpenseCategory(
        id = "subscriptions",
        displayName = "Subscriptions",
        icon = Icons.Outlined.Subscriptions,
        color = Color(0xFF673AB7) // Deep Purple
    )

    data object PetCare : ExpenseCategory(
        id = "pet_care",
        displayName = "Pet Care",
        icon = Icons.Outlined.Pets,
        color = Color(0xFFFF5722) // Deep Orange
    )

    data object Other : ExpenseCategory(
        id = "other",
        displayName = "Other",
        icon = Icons.Outlined.Menu,
        color = Color(0xFF607D8B) // Blue Gray
    )

    companion object {
        /**
         * Returns a list of all available expense categories
         */
        fun getAllCategories(): List<ExpenseCategory> = listOf(
            FoodDining,
            Transportation,
            Entertainment,
            Shopping,
            BillsUtilities,
            Healthcare,
            Education,
            Travel,
            Groceries,
            PersonalCare,
            GiftsDonations,
            HomeGarden,
            FitnessSports,
            Subscriptions,
            PetCare,
            Other
        )

        /**
         * Finds a category by its ID
         */
        fun fromId(id: String): ExpenseCategory? =
            getAllCategories().find { it.id == id }

        /**
         * Finds a category by its display name
         */
        fun fromDisplayName(displayName: String): ExpenseCategory? =
            getAllCategories().find { it.displayName == displayName }
    }
}