package com.antigravity.linguapulse

import android.app.Application
import com.antigravity.linguapulse.data.AppDatabase
import com.antigravity.linguapulse.data.CardRepository
import com.antigravity.linguapulse.notifications.CardNotificationWorker
import com.antigravity.linguapulse.notifications.NotificationHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class LinguaPulseApp : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { CardRepository(database.flashcardDao()) }

    override fun onCreate() {
        super.onCreate()

        // Create notification channel for Android 8.0+
        NotificationHelper.createNotificationChannel(this)

        // Ensure database is populated and start background work
        applicationScope.launch {
            repository.ensureInitialDataLoaded()
            // Schedule periodic notifications every 4 hours by default
            CardNotificationWorker.schedulePeriodic(this@LinguaPulseApp, 4)
        }
    }
}
