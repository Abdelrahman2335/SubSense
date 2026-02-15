package com.example.subsense.manage_expences.data.di

import com.example.subsense.manage_expences.data.repository.ManageExpenseRepo
import com.example.subsense.manage_expences.data.repository.ManageExpenseRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class ManageExpenseModule {


    @Binds
    @ViewModelScoped
    abstract fun bindManageExpenseRepo(
        manageExpenseRepoImpl: ManageExpenseRepoImpl
    ): ManageExpenseRepo
}