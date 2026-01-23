package com.example.subsense.expense.data.dummy_data

import com.example.subsense.core.model.Expense
import com.example.subsense.core.model.ExpenseCategory

/**
 * Provides a small set of sample expenses for previews, tests and UI mockups.
 * All amounts are stored as cents (Long). Dates are based on System.currentTimeMillis()
 * with offsets so they look like recent expenses.
 */
val DummyData: List<Expense> by lazy {
    val now = System.currentTimeMillis()
    val dayMs = 24 * 60 * 60 * 1000L

    listOf(
        Expense(
            1001L,
            12_345L,
            ExpenseCategory.FoodDining,
            now - 1 * dayMs,
            "Lunch at cafe",
            false,
            null
        ),
        Expense(
            1002L,
            2_500L,
            ExpenseCategory.Groceries,
            now - 2 * dayMs,
            "Milk & eggs",
            false,
            null
        ),
        Expense(
            1003L,
            7_599L,
            ExpenseCategory.Transportation,
            now - 3 * dayMs,
            "Taxi to office",
            false,
            null
        ),
        Expense(
            1004L,
            123_450L,
            ExpenseCategory.Shopping,
            now - 4 * dayMs,
            "New headphones",
            false,
            null
        ),
        Expense(
            1005L,
            5_000L,
            ExpenseCategory.BillsUtilities,
            now - 5 * dayMs,
            "Electricity bill",
            false,
            null
        ),
        Expense(
            1006L,
            15_000L,
            ExpenseCategory.Healthcare,
            now - 6 * dayMs,
            "Pharmacy",
            false,
            null
        ),
        Expense(
            1007L,
            45_000L,
            ExpenseCategory.Education,
            now - 7 * dayMs,
            "Online course",
            false,
            null
        ),
        Expense(
            1008L,
            89_900L,
            ExpenseCategory.Travel,
            now - 8 * dayMs,
            "Weekend trip",
            false,
            null
        ),
        Expense(
            1009L,
            3_250L,
            ExpenseCategory.PersonalCare,
            now - 9 * dayMs,
            "Haircut",
            false,
            null
        ),
        Expense(
            1010L,
            250_000L,
            ExpenseCategory.HomeGarden,
            now - 10 * dayMs,
            "Small furniture",
            false,
            null
        ),
        Expense(
            1011L,
            6_450L,
            ExpenseCategory.FitnessSports,
            now - 11 * dayMs,
            "Gym gear",
            false,
            null
        ),
        Expense(
            1012L,
            1_299L,
            ExpenseCategory.Subscriptions,
            now - 12 * dayMs,
            "Streaming",
            false,
            null
        ),
        Expense(1013L, 9_900L, ExpenseCategory.PetCare, now - 13 * dayMs, "Vet visit", false, null),
        Expense(1014L, 499L, ExpenseCategory.Other, now - 14 * dayMs, "Parking", false, null),
        Expense(
            1015L,
            3_000L,
            ExpenseCategory.GiftsDonations,
            now - 15 * dayMs,
            "Birthday gift",
            false,
            null
        ),
        Expense(
            1016L,
            4_200L,
            ExpenseCategory.Entertainment,
            now - 16 * dayMs,
            "Movie night",
            false,
            null
        ),
        Expense(
            1017L,
            29_990L,
            ExpenseCategory.FoodDining,
            now - 17 * dayMs,
            "Dinner with friends",
            false,
            null
        ),
        Expense(
            1018L,
            799L,
            ExpenseCategory.Groceries,
            now - 18 * dayMs,
            "Snacks & drinks",
            false,
            null
        ),
        Expense(1019L, 14_500L, ExpenseCategory.Shopping, now - 19 * dayMs, "Clothes", false, null),
        Expense(
            1020L,
            65_000L,
            ExpenseCategory.Travel,
            now - 20 * dayMs,
            "Flight booking",
            false,
            null
        )
    )
}