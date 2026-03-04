package com.example.subsense.manage_expences.data.repository

import com.example.subsense.core.data.model.Expense
import com.example.subsense.manage_expences.data.local.dao.ManageExpensesDao
import javax.inject.Inject

class ManageExpenseRepoImpl @Inject constructor(
    private val dao: ManageExpensesDao
) : ManageExpenseRepo {
    override suspend fun upSertExpense(expense: Expense) {
        dao.upSertExpense(expense)
    }


}