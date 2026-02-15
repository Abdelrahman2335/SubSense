package com.example.subsense.expense.data.di

import com.example.subsense.expense.data.repository.ExpenseRepo
import com.example.subsense.expense.data.repository.ExpenseRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ExpenseModule {

    @Binds
    @Singleton
    abstract fun BindExpenseRepo(
        repoImpl: ExpenseRepoImpl
    ): ExpenseRepo
}