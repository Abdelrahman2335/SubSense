package com.example.subsense.core.notification.handler

import android.content.Intent

object NotificationIntentHandler {

    fun isFromNotification(intent: Intent?): Boolean {
        return intent?.getStringExtra("source") == "notification"
    }

    fun handleNotificationIntent(intent: Intent) {
        // Optional: log analytics, navigate to specific screen, etc.
        // For now, just navigating to home (MainActivity already displayed)
    }
}