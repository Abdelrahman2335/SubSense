package com.example.subsense.core.notification.di

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
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
    fun provideNotificationManager(
        @ApplicationContext context: Context
    ): NotificationManagerCompat {
        val notificationManager = NotificationManagerCompat.from(context)

        NotificationType.entries.forEach { type ->
            val importance = when (type) {
                NotificationType.BUDGET -> NotificationManager.IMPORTANCE_HIGH
                NotificationType.DAILY -> NotificationManager.IMPORTANCE_DEFAULT
            }

            val channel = NotificationChannel(
                type.name,
                type.displayName,
                importance
            )
            notificationManager.createNotificationChannel(channel)
        }

        return notificationManager
    }
}