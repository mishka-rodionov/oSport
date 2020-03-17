//package com.rodionov.osport.app.services
//
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.app.PendingIntent
//import android.content.Context
//import android.content.Intent
//import android.media.RingtoneManager
//import android.os.Build
//import androidx.core.app.NotificationCompat
//import androidx.core.content.ContextCompat
//import com.google.firebase.messaging.FirebaseMessagingService
//import com.google.firebase.messaging.RemoteMessage
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import me.leolin.shortcutbadger.ShortcutBadger
//import org.greenrobot.eventbus.EventBus
//import org.koin.android.ext.android.inject
//
//class FirebaseMessagingService : FirebaseMessagingService() {
//
//    private val pref: Pref by inject()
//    private val authRepository: AuthRepository by inject()
//    private val serviceScope = CoroutineScope(Dispatchers.IO)
//
//    override fun onMessageReceived(remoteMessage: RemoteMessage) {
//
//        val title = remoteMessage.data["title"]
//        val message = remoteMessage.data["body"]
//        val number = remoteMessage.data["badge"]
//
//        sendNotification(title, message, number)
//        EventBus.getDefault().postSticky(UpdateNotifications)
//        EventBus.getDefault().postSticky(UpdateDotNotifications)
//    }
//
//    override fun onNewToken(token: String) {
//        if (!pref.authToken.isNullOrEmpty()) {
//            serviceScope.launch {
//                authRepository.updatePushToken(PushTokenRequest(token))
//            }
//        }
//    }
//
//    private fun sendNotification(title: String?, message: String?, number: String?) {
//        val intent = Intent(this, MainActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        intent.putExtra(FIREBASE_TAG, FIREBASE_TAG)
//        val pendingIntent = PendingIntent.getActivity(
//            this, 0, intent,
//            PendingIntent.FLAG_ONE_SHOT
//        )
//
//        val channelId = getString(R.string.default_notification_channel_id)
//        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
//        val notificationBuilder = NotificationCompat.Builder(this, channelId)
//            .setSmallIcon(R.drawable.ic_logo_push)
//            .setColor(ContextCompat.getColor(this, R.color.colorPrimary))
//            .setContentTitle(title)
//            .setContentText(message)
//            .setAutoCancel(true)
//            .setNumber(number?.toInt() ?: 0)
//            .setSound(defaultSoundUri)
//            .setContentIntent(pendingIntent)
//
//        val notificationManager =
//            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channel = NotificationChannel(
//                channelId,
//                getString(R.string.default_notification_name_channel),
//                NotificationManager.IMPORTANCE_DEFAULT
//            )
//            notificationManager.createNotificationChannel(channel)
//        }
//
//        ShortcutBadger.applyCount(this, number?.toInt() ?: 0)
//        notificationManager.notify(0, notificationBuilder.build())
//    }
//
//    companion object {
//        const val FIREBASE_TAG = "FirebaseMsgService"
//    }
//}