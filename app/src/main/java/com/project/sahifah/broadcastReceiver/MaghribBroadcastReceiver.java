package com.project.sahifah.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.project.sahifah.R;

public class MaghribBroadcastReceiver extends BroadcastReceiver {

    public static final String TITLE = "Notifikasi Shalat";

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builderMaghrib = new NotificationCompat.Builder(context, "maghrib")
                .setSmallIcon(R.drawable.ic_alarm)
                .setContentTitle(TITLE)
                .setContentText("Memasuki Waktu Sholat Maghrib")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManagerCompat notificationManagerMaghrib = NotificationManagerCompat.from(context);
        notificationManagerMaghrib.notify(4, builderMaghrib.build());
        Vibrator vibratorMaghrib = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibratorMaghrib.vibrate(3000);

    }
}
