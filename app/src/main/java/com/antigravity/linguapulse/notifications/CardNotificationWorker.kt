package com.antigravity.linguapulse.notifications

import android.content.Context
import androidx.work.*
import com.antigravity.linguapulse.data.AppDatabase
import com.antigravity.linguapulse.data.CardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

class CardNotificationWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val database = AppDatabase.getDatabase(applicationContext, this)
            val repository = CardRepository(database.flashcardDao())
            repository.ensureInitialDataLoaded()

            val card = repository.getRandomCardForNotification()
            if (card != null) {
                NotificationHelper.showCardNotification(applicationContext, card)
            }
            Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            Result.retry()
        }
    }

    companion object {
        private const val WORK_NAME = "LinguaPulseNotificationWork"

        fun schedulePeriodic(context: Context, intervalHours: Long = 4) {
            val constraints = Constraints.Builder()
                .build()

            val periodicWork = PeriodicWorkRequestBuilder<CardNotificationWorker>(
                intervalHours, TimeUnit.HOURS
            )
                .setConstraints(constraints)
                .setInitialDelay(intervalHours, TimeUnit.HOURS)
                .build()

            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                WORK_NAME,
                ExistingPeriodicWorkPolicy.UPDATE,
                periodicWork
            )
        }

        fun cancelPeriodic(context: Context) {
            WorkManager.getInstance(context).cancelUniqueWork(WORK_NAME)
        }

        fun triggerImmediate(context: Context) {
            val oneTimeWork = OneTimeWorkRequestBuilder<CardNotificationWorker>()
                .build()
            WorkManager.getInstance(context).enqueue(oneTimeWork)
        }
    }
}
