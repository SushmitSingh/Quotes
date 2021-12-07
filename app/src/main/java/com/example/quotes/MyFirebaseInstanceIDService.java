package com.example.quotes;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseInstanceIDService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotifications(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());


    }
    public void showNotifications(String title, String message)
    {
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this,"myNotification")
                .setContentTitle(title)
                .setSound(Uri.parse("android.resource://"+this.getPackageName()+"/"+ R.drawable.ic_notifcation))
                .setSmallIcon(R.drawable.ic_notifcation)
                .setAutoCancel(true)
                .setContentText(message);
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
        managerCompat.notify(999,builder.build());
    }
}
