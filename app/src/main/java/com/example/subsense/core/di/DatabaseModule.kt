package com.example.subsense.core.di

import android.content.Context
import androidx.room.Room
import com.example.subsense.core.model.ExpensesDatabase
import com.example.subsense.manage_expences.data.repository.ManageExpensesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ExpensesDatabase {
        return Room.databaseBuilder(
            context,
            ExpensesDatabase::class.java,
            "expenses_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideManageExpensesDao(
        database: ExpensesDatabase
    ): ManageExpensesDao {
        return database.dao
    }
}