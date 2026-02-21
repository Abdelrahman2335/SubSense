package com.example.subsense.debits.data.model

fun getDummyDebtData(): List<DebtModel> {
    return listOf(
        DebtModel(1, DebtType.BORROWED, "John Loan", 500f, System.currentTimeMillis(), "Borrowed for rent", DebtStatus.Pending),
        DebtModel(2, DebtType.LENT, "Visa Bill", 1200f, System.currentTimeMillis(), "Monthly expenses", DebtStatus.Overdue),
        DebtModel(3, DebtType.BORROWED, "Sarah Debt", 300f, System.currentTimeMillis(), "Dinner money", DebtStatus.Paid),
        DebtModel(4, DebtType.LENT, "Home Loan", 150000f, System.currentTimeMillis(), "Mortgage payment", DebtStatus.PartiallyPaid),
        DebtModel(5, DebtType.BORROWED, "Mike Loan", 750f, System.currentTimeMillis(), "Car repair", DebtStatus.Pending),
        DebtModel(6, DebtType.LENT, "Mastercard", 850f, System.currentTimeMillis(), "Shopping", DebtStatus.Overdue),
        DebtModel(7, DebtType.BORROWED, "Emma Debt", 200f, System.currentTimeMillis(), "Book purchase", DebtStatus.Paid),
        DebtModel(8, DebtType.LENT, "Student Loan", 25000f, System.currentTimeMillis(), "Education", DebtStatus.PartiallyPaid),
        DebtModel(9, DebtType.BORROWED, "Amex", 2500f, System.currentTimeMillis(), "Travel expenses", DebtStatus.Cancelled),
        DebtModel(10, DebtType.LENT, "Alex Loan", 450f, System.currentTimeMillis(), "Medical bills", DebtStatus.Pending)
    )
}
