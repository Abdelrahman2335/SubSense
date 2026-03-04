package com.example.subsense.setting.data.repository

import com.example.subsense.core.data.model.Budget
import com.example.subsense.setting.data.local.dao.SettingDao
import javax.inject.Inject


class SettingRepoImpl @Inject constructor(
    private val settingDao: SettingDao
) : SettingRepo {
    override fun getBudgets(): List<Budget> {
        return settingDao.getBudgets()
    }

    override fun upsertBudget(budget: Budget) {
        return settingDao.upsertBudget(budget)
    }
}