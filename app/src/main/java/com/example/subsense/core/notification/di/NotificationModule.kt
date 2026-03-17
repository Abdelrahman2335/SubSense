package com.example.subsense.core.notification.di

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.R.drawable
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.subsense.core.notification.model.NotificationType
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    @Provides
    @Singleton
    fun provideNotificationBuilder(
        @ApplicationContext context: Context
    ): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, NotificationType.DAILY.name)
            .setContentTitle("SubSense")
            .setContentText("This is a text notification")
            .setSmallIcon(drawable.notification_icon_background)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
    }

    @Provides
    @Singleton
    fun provideNotificationManager(
        @ApplicationContext context: Context
    ): NotificationManagerCompat {
        val notificationManager = NotificationManagerCompat.from(context)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                NotificationType.DAILY.name,
                "Main Channel",
                NotificationManager.IMPORTANCE_HIGH

            )
            notificationManager.createNotificationChannel(channel)

        }
        return notificationManager
    }
}