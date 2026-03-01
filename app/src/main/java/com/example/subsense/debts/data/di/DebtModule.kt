package com.example.subsense.debts.data.di

import com.example.subsense.debts.data.repository.DebtRepo
import com.example.subsense.debts.data.repository.DebtRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DebtModule {

    @Binds
    @Singleton
    abstract fun BindDebtRepo(
        repoImpl: DebtRepoImpl
    ): DebtRepo
}