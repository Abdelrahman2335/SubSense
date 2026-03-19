package com.example.subsense.core.notification.scheduler

import android.Manifest
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.subsense.MainActivity
import com.example.subsense.R
import com.example.subsense.core.notification.model.NotificationType
import java.time.LocalTime
import kotlin.math.abs

class DailyNotificationWorker(
    context: Context,
    params: WorkerParameters
) : Worker(context, params) {

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    override fun doWork(): Result {
        return try {
            val title = inputData.getString("title") ?: return Result.failure()
            val message = inputData.getString("message") ?: return Result.failure()
            val type = inputData.getString("type") ?: return Result.failure()
            val times =
                inputData.getStringArray("times")?.map { LocalTime.parse(it) } ?: emptyList()

            Log.d("DailyNotificationWorker", "Checking if should show notification")

            if (shouldShowNotification(times)) {
                Log.d("DailyNotificationWorker", "Showing notification at ${LocalTime.now()}")
                showNotification(title, message, NotificationType.valueOf(type))
            }

            Result.success()
        } catch (e: Exception) {
            Log.e("DailyNotificationWorker", "Error showing notification", e)
            Result.retry()
        }
    }

    private fun shouldShowNotification(times: List<LocalTime>): Boolean {
        val now = LocalTime.now()
        return times.any { scheduledTime ->
            val diff = abs(now.toSecondOfDay() - scheduledTime.toSecondOfDay())
            diff <= 60
        }
    }

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    private fun showNotification(title: String, message: String, type: NotificationType) {
        val notificationManager = NotificationManagerCompat.from(applicationContext)

        val pendingIntent = PendingIntent.getActivity(
            applicationContext,
            0,
            Intent(applicationContext, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                putExtra("source", "notification")
            },
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(applicationContext, type.name)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(type.ordinal, notification)
    }
}