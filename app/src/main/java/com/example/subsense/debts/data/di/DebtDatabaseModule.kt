package com.example.subsense.debts.data.di

import android.content.Context
import androidx.room.Room
import com.example.subsense.debts.data.local.DebtsDatabase
import com.example.subsense.debts.data.local.dao.DebtDao
import com.example.subsense.manage_debts.data.dao.ManageDebtsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DebtDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): DebtsDatabase {
        return Room.databaseBuilder(
            context,
            DebtsDatabase::class.java,
            "debts_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providerDebtDao(database: DebtsDatabase): DebtDao {
        return database.debtDao
    }

    @Provides
    @Singleton
    fun provideManageDebtsDao(database: DebtsDatabase): ManageDebtsDao {
        return database.manageDebtsDao
    }

}