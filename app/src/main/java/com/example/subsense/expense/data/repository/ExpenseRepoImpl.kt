package com.example.subsense.expense.data.repository

import com.example.subsense.core.model.Expense
import com.example.subsense.expense.data.dao.ExpenseDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExpenseRepoImpl @Inject constructor(
    private val expenseDao: ExpenseDao,
) : ExpenseRepo {
    override fun getAllExpenses(): Flow<List<Expense>> {
        return expenseDao.getAllExpenses()
    }

}