package com.example.subsense.setting.data.repository

import com.example.subsense.core.data.model.Budget
import com.example.subsense.core.notification.model.Notification
import com.example.subsense.setting.data.local.dao.SettingDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class SettingRepoImpl @Inject constructor(
    private val settingDao: SettingDao
) : SettingRepo {
    override fun getBudgets(): Flow<List<Budget>> {
        return settingDao.getBudgets()
    }

    override fun getNotifications(): Flow<List<Notification>> {
        return settingDao.getNotifications()
    }

    override suspend fun upsertBudget(budget: Budget) {
        return settingDao.upsertBudget(budget)
    }

    override suspend fun upsertBudget(budgets: List<Budget>) {
        return settingDao.upsertBudgets(budgets)
    }

    override suspend fun upsertNotification(notification: Notification) {
        return settingDao.upsertNotification(notification)
    }

    override suspend fun updateNotification(notification: Notification) {
        return settingDao.updateNotification(notification)
    }

}