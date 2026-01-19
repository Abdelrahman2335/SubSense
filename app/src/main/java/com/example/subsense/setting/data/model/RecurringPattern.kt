package com.example.subsense.setting.data.model

data class RecurringPattern(
    val frequency: Frequency, // DAILY, WEEKLY, MONTHLY
    val interval: Int, // every X days/weeks/months
    val endDate: Long?  // null = indefinite
)