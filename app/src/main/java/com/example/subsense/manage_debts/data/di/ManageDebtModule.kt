package com.example.subsense.manage_debts.data.di

import com.example.subsense.manage_debts.data.repository.ManageDebtRepo
import com.example.subsense.manage_debts.data.repository.ManageDebtRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ManageDebtModule {
    @Binds
    @ViewModelScoped
    abstract fun bindManageDebtRepo(
        manageDebtRepoImpl: ManageDebtRepoImpl
    ): ManageDebtRepo
}
