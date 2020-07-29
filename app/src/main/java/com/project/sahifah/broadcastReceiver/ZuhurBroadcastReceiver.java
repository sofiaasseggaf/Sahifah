package com.project.sahifah.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.project.sahifah.R;

public class ZuhurBroadcastReceiver extends BroadcastReceiver {

    public static final String TITLE = "Notifikasi Shalat";

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builderZuhur = new NotificationCompat.Builder(context, "zuhur")
                .setSmallIcon(R.drawable.ic_alarm)
                .setContentTitle(TITLE)
                .setContentText("Memasuki Waktu Sholat Zuhur")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManagerCompat notificationManagerZuhur = NotificationManagerCompat.from(context);
        notificationManagerZuhur.notify(2, builderZuhur.build());
        Vibrator vibratorZuhur = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibratorZuhur.vibrate(3000);

    }
}
