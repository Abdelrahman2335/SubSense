package com.example.subsense.core.notification.scheduler

import android.content.Context
import androidx.work.Data
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.subsense.core.notification.model.NotificationType
import dagger.hilt.android.qualifiers.ApplicationContext
import java.time.LocalTime
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationScheduler @Inject constructor(
    @param:ApplicationContext private val context: Context
) {

    fun scheduleDailyNotification(
        times: List<LocalTime>,
        title: String,
        message: String
    ) {
        val now = LocalTime.now()
        val firstScheduledTime = times.minByOrNull { time ->
            val diff = time.toSecondOfDay() - now.toSecondOfDay()
            if (diff > 0) diff else diff + 86400
        } ?: times.first()

        val initialDelaySeconds = calculateDelayToTime(firstScheduledTime)

        val workData = Data.Builder()
            .putString("title", title)
            .putString("message", message)
            .putString("type", NotificationType.DAILY.name)
            .putStringArray("times", times.map { it.toString() }.toTypedArray())
            .build()

        val periodicWork = PeriodicWorkRequestBuilder<DailyNotificationWorker>(
            24, TimeUnit.HOURS
        )
            .setInitialDelay(initialDelaySeconds, TimeUnit.SECONDS)
            .setInputData(workData)
            .addTag("daily_notification")
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "daily_notification",
            ExistingPeriodicWorkPolicy.REPLACE,
            periodicWork
        )
    }

    fun cancelDailyNotification() {
        WorkManager.getInstance(context).cancelUniqueWork("daily_notification")
    }

    private fun calculateDelayToTime(targetTime: LocalTime): Long {
        val now = LocalTime.now()
        val delaySeconds = targetTime.toSecondOfDay() - now.toSecondOfDay()
        return if (delaySeconds > 0) delaySeconds.toLong() else delaySeconds + 86400L
    }
}