package org.example.project

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.NotificationCompat
import kotlin.random.Random

@Composable
actual fun Notify(message: String) {
    val context = LocalContext.current
    val notificationUtil = remember { NotificationUtil(context) }

    LaunchedEffect(message) {
        notificationUtil.showNotification(message)
    }
}

class NotificationUtil(private val context: Context) {
    private val channelId = "task_channel_01"
    private val notificationId = Random.nextInt(1000, 9999)

    init {
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            channelId,
            "Уведомления о задачах",
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = "Канал для уведомлений"
            enableVibration(true)
            vibrationPattern = longArrayOf(100, 200, 100)
        }

        val manager = context.getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)
    }

    fun showNotification(message: String) {
        val builder = NotificationCompat.Builder(context, channelId)
            .setContentTitle("Создана новая задача")
            .setContentText(message)
            .setVibrate(longArrayOf(100, 200, 100))
            .setSmallIcon(R.drawable.ic_task_notification)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)

        val manager = context.getSystemService(NotificationManager::class.java)
        manager.notify(notificationId, builder.build())
    }
}