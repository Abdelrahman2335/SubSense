package com.example.subsense.core.notification.manager

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.subsense.MainActivity
import com.example.subsense.R
import com.example.subsense.core.notification.model.NotificationType
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val notificationManagerCompat: NotificationManagerCompat
) {
    fun showNotification(
        title: String,
        message: String,
        notificationType: NotificationType
    ) {
        val pendingIntent = createPendingIntent()
        val notification = NotificationCompat.Builder(
            context,
            notificationType.name
        )
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()
        val notificationId = notificationType.ordinal
        notificationManagerCompat.notify(notificationId, notification)
    }

    private fun createPendingIntent(): PendingIntent {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            putExtra("source", "notification")
        }
        return PendingIntent.getActivity(
            context,
            PENDING_INTENT_REQUEST_CODE,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }

    companion object {
        private const val PENDING_INTENT_REQUEST_CODE = 0
    }
}