package com.febian.knwoy.androidriderapp.Helper;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.febian.knwoy.androidriderapp.R;

public class NotificationHelper extends ContextWrapper {

    private static final String KNWY_CHANNEL_ID = "com.febian.knwoy.androidriderapp.KNWYDEV";
    private static final String KNWY_CHANNEL_NAME = "KNWYDEV Uber";

    private NotificationManager manager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            createChannels();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannels() {
        NotificationChannel knwyChannels = new NotificationChannel(KNWY_CHANNEL_ID,
                KNWY_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT);
        knwyChannels.enableLights(true);
        knwyChannels.enableVibration(true);
        knwyChannels.setLightColor(Color.GRAY);
        knwyChannels.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(knwyChannels);
    }

    public NotificationManager getManager() {
        if (manager == null)
            manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        return manager;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getUberNotification(String title, String content, PendingIntent contentIntent,
                                                    Uri soundUri)
    {
        return new Notification.Builder(getApplicationContext(),KNWY_CHANNEL_ID)
                .setContentText(content)
                .setContentTitle(title)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(contentIntent)
                .setSmallIcon(R.drawable.ic_car);
    }
}
