package com.example.subsense.debts.data.model

fun getDummyDebtData(): List<DebtModel> {
    return listOf(
        DebtModel(
            1,
            DebtType.BORROW,
            "John Loan",
            500.0,
            System.currentTimeMillis(),
            "Borrowed for rent",
            DebtStatus.Pending
        ),
        DebtModel(
            2,
            DebtType.LENT,
            "Visa Bill",
            1200.0,
            System.currentTimeMillis(),
            "Monthly expenses",
            DebtStatus.Overdue
        ),
        DebtModel(
            3,
            DebtType.BORROW,
            "Sarah Debt",
            300.0,
            System.currentTimeMillis(),
            "Dinner money",
            DebtStatus.Paid
        ),
        DebtModel(
            4,
            DebtType.LENT,
            "Home Loan",
            150000.0,
            System.currentTimeMillis(),
            "Mortgage payment",
            DebtStatus.PartiallyPaid
        ),
        DebtModel(
            5,
            DebtType.BORROW,
            "Mike Loan",
            750.0,
            System.currentTimeMillis(),
            "Car repair",
            DebtStatus.Pending
        ),
        DebtModel(
            6,
            DebtType.LENT,
            "Mastercard",
            850.0,
            System.currentTimeMillis(),
            "Shopping",
            DebtStatus.Overdue
        ),
        DebtModel(
            7,
            DebtType.BORROW,
            "Emma Debt",
            200.0,
            System.currentTimeMillis(),
            "Book purchase",
            DebtStatus.Paid
        ),
        DebtModel(
            8,
            DebtType.LENT,
            "Student Loan",
            25000.0,
            System.currentTimeMillis(),
            "Education",
            DebtStatus.PartiallyPaid
        ),
        DebtModel(
            9,
            DebtType.BORROW,
            "Amex",
            2500.0,
            System.currentTimeMillis(),
            "Travel expenses",
            DebtStatus.Cancelled
        ),
        DebtModel(
            10,
            DebtType.LENT,
            "Alex Loan",
            450.0,
            System.currentTimeMillis(),
            "Medical bills",
            DebtStatus.Pending
        )
    )
}
