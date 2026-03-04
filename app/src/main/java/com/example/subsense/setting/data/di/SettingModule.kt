package com.example.subsense.setting.data.di

import com.example.subsense.setting.data.repository.SettingRepo
import com.example.subsense.setting.data.repository.SettingRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class SettingModule {

    @Binds
    @Singleton
    abstract fun BindSettingRepo(
        settingRepoImpl: SettingRepoImpl
    ): SettingRepo
}