package com.project.sahifah.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.project.sahifah.R;

public class SubuhBroadcastReceiver extends BroadcastReceiver {

    public static final String TITLE = "Notifikasi Shalat";

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builderSubuh = new NotificationCompat.Builder(context, "subuh")
                .setSmallIcon(R.drawable.ic_alarm)
                .setContentTitle(TITLE)
                .setContentText("Memasuki Waktu Sholat Subuh")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSound(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.azansubuh))
                //.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
                ;
        NotificationManagerCompat notificationManagerSubuh = NotificationManagerCompat.from(context);
        notificationManagerSubuh.notify(1, builderSubuh.build());

        Vibrator vibratorSubuh = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibratorSubuh.vibrate(3000);
    }
}
