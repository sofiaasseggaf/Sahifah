package com.project.sahifah.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.project.sahifah.R;

public class IsyaBroadcastReceiver extends BroadcastReceiver {

    public static final String TITLE = "Notifikasi Shalat";

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builderIsya = new NotificationCompat.Builder(context, "isya")
                .setSmallIcon(R.drawable.ic_alarm)
                .setContentTitle(TITLE)
                .setContentText("Memasuki Waktu Sholat Isya")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSound(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.azan));
        NotificationManagerCompat notificationManagerIsya = NotificationManagerCompat.from(context);
        notificationManagerIsya.notify(4, builderIsya.build());
        Vibrator vibratorIsya = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibratorIsya.vibrate(3000);

    }
}
