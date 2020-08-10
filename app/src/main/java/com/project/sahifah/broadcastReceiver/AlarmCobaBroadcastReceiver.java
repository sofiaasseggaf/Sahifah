package com.project.sahifah.broadcastReceiver;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.project.sahifah.R;

public class AlarmCobaBroadcastReceiver extends BroadcastReceiver {

    public static final String TITLE = "Notifikasi Coba";

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builderCoba = new NotificationCompat.Builder(context, "coba")
                .setSmallIcon(R.drawable.ic_alarm)
                .setContentTitle(TITLE)
                .setContentText("Memasuki Waktu Sholat Coba")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                //.setDefaults(Notification.DEFAULT_ALL)
                //.setSound(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.azansubuh))
                //.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
                ;
        NotificationManagerCompat notificationManagerSubuh = NotificationManagerCompat.from(context);
       /* Notification notification = builderCoba.build();
        notification.sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notificationManagerSubuh.notify(10, notification);*/
        notificationManagerSubuh.notify(10, builderCoba.build());


        Vibrator vibratorSubuh = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibratorSubuh.vibrate(3000);

    }
}
