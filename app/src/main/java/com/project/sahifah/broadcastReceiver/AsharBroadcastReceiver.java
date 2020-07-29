package com.project.sahifah.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.project.sahifah.R;

public class AsharBroadcastReceiver extends BroadcastReceiver {

    public static final String TITLE = "Notifikasi Shalat";

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builderAshar = new NotificationCompat.Builder(context, "ashar")
                .setSmallIcon(R.drawable.ic_alarm)
                .setContentTitle(TITLE)
                .setContentText("Memasuki Waktu Sholat Ashar")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManagerCompat notificationManagerAshar = NotificationManagerCompat.from(context);
        notificationManagerAshar.notify(3, builderAshar.build());
        Vibrator vibratorAshar = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibratorAshar.vibrate(3000);

    }
}
