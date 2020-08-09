package com.project.sahifah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Telephony;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.msarhan.ummalqura.calendar.UmmalquraCalendar;
import com.project.sahifah.APIService.APIClient;
import com.project.sahifah.APIService.APIInterfacesRest;
import com.project.sahifah.broadcastReceiver.AlarmCobaBroadcastReceiver;
import com.project.sahifah.broadcastReceiver.AsharBroadcastReceiver;
import com.project.sahifah.broadcastReceiver.IsyaBroadcastReceiver;
import com.project.sahifah.broadcastReceiver.MaghribBroadcastReceiver;
import com.project.sahifah.broadcastReceiver.SubuhBroadcastReceiver;
import com.project.sahifah.broadcastReceiver.ZuhurBroadcastReceiver;
import com.project.sahifah.model.jadwalsolat.Date;
import com.project.sahifah.model.jadwalsolat.ModelJadwalSolat;
import com.project.sahifah.oase.OaseActivity;
import com.project.sahifah.utility.PreferenceUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WaktuSalatActivity extends AppCompatActivity {

    ImageButton btn_back;
    ImageButton btn_home, btn_hikmah, btn_search, btn_oase, btn_profile;
    ImageButton notif_subuh, notif_zuhur, notif_ashar, notif_maghrib, notif_isya, btn_setting_soundazan, notif_terbit;
    TextView btn_home2, btn_hikmah2, btn_search2, btn_oase2, btn_profile2;
    LinearLayout btn_home3, btn_hikmah3, btn_search3, btn_oase3, btn_profile3;
    TextView txt_now, txtTanggalMasehi, txtTanggalHijriyah, txtCity, waktuSubuh, waktuTerbit, waktuZuhur, waktuAshar, waktuMagrib, waktuIsya;
    ModelJadwalSolat dataJadwalSolat;
    Time today;
    String subuhalarm, zuhuralarm, asharalarm, maghribalarm, isyaalarm;
    int subuhalarmjam, subuhalarmmnt, zuhuralarmjam, zuhuralarmmnt, asharalarmjam, asharalarmmnt,
            maghribalarmjam, maghribalarmmnt, isyaalarmjam, isyaalarmmnt;
    String city;
    int valid;

    Calendar now;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    Intent intent;

    NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waktu_salat);

        btn_back = findViewById(R.id.btn_back);
        btn_home = findViewById(R.id.btn_home);
        btn_hikmah = findViewById(R.id.btn_hikmah);
        btn_search = findViewById(R.id.btn_search);
        btn_oase = findViewById(R.id.btn_oase);
        btn_profile = findViewById(R.id.btn_profile);
        btn_home2 = findViewById(R.id.btn_home2);
        btn_hikmah2 = findViewById(R.id.btn_hikmah2);
        btn_search2 = findViewById(R.id.btn_search2);
        btn_oase2 = findViewById(R.id.btn_oase2);
        btn_profile2 = findViewById(R.id.btn_profile2);
        btn_home3 = findViewById(R.id.btn_home3);
        btn_hikmah3 = findViewById(R.id.btn_hikmah3);
        btn_search3 = findViewById(R.id.btn_search3);
        btn_oase3 = findViewById(R.id.btn_oase3);
        btn_profile3 = findViewById(R.id.btn_profile3);

        txt_now = findViewById(R.id.txt_now);
        txtTanggalMasehi = findViewById(R.id.txtTanggalMasehi);
        txtTanggalHijriyah = findViewById(R.id.txtTanggalHijriyah);
        txtCity = findViewById(R.id.txtCity);
        waktuSubuh = findViewById(R.id.waktuSubuh);
        waktuTerbit = findViewById(R.id.waktuTerbit);
        waktuZuhur = findViewById(R.id.waktuZuhur);
        waktuAshar = findViewById(R.id.waktuAshar);
        waktuMagrib = findViewById(R.id.waktuMagrib);
        waktuIsya = findViewById(R.id.waktuIsya);

        notif_terbit = findViewById(R.id.notif_terbit);
        notif_subuh = findViewById(R.id.notif_subuh);
        notif_zuhur = findViewById(R.id.notif_zuhur);
        notif_ashar = findViewById(R.id.notif_ashar);
        notif_maghrib = findViewById(R.id.notif_maghrib);
        notif_isya = findViewById(R.id.notif_isya);
        //btn_setting_soundazan = findViewById(R.id.btn_setting_soundazan);
        notificationManagerCompat = NotificationManagerCompat.from(this);

        city = getIntent().getStringExtra("city");
        txtCity.setText(city);

        thread();

        sendNotifCoba();
        sendNotifSubuh();
        sendNotifZuhur();
        sendNotifAshar();
        sendNotifMaghrib();
        sendNotifIsyaa();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WaktuSalatActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });
        btn_hikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WaktuSalatActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });
        // BTN SEARCH
        btn_oase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WaktuSalatActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WaktuSalatActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });
        btn_home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WaktuSalatActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });
        btn_hikmah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WaktuSalatActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });
        // BTN SEARCH
        btn_oase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WaktuSalatActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });
        btn_profile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WaktuSalatActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });
        btn_home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WaktuSalatActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });
        btn_hikmah3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WaktuSalatActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });
        // BTN SEARCH
        btn_oase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WaktuSalatActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });
        btn_profile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WaktuSalatActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyClock(), 0, 1000);

        Date today = new Date();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat formatMasehi = new SimpleDateFormat("dd MMMM yyyy");
        String dateToStr = formatMasehi.format(today);
        txtTanggalMasehi.setText(dateToStr);

        Locale en = Locale.ENGLISH;
        UmmalquraCalendar uCal = new UmmalquraCalendar(en);
        int thn = uCal.get(Calendar.YEAR);                                      // 1436
        String bln = uCal.getDisplayName(Calendar.MONTH, Calendar.LONG, en);       // Jumada al-Ula
        int tgl = uCal.get(Calendar.DAY_OF_MONTH);                             // 10
        txtTanggalHijriyah.setText(tgl+" "+bln+" "+thn);


        notif_terbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (PreferenceUtils.getAlarmCoba(getApplicationContext()).equalsIgnoreCase("off")) {
                    PreferenceUtils.saveAlarmCoba("on", getApplicationContext());
                    notif_terbit.setImageDrawable(getDrawable(R.drawable.icon_notification_blue));
                    Toast.makeText(WaktuSalatActivity.this, "Reminder Coba Set!", Toast.LENGTH_SHORT).show();
                    intent = new Intent(WaktuSalatActivity.this, AlarmCobaBroadcastReceiver.class);
                    //intent.putExtra("Ringtone", Uri.parse("getResources().getResourceName(R.raw.azansubuh)"));
                    pendingIntent = PendingIntent.getBroadcast(WaktuSalatActivity.this,
                            0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    intent.setData((Uri.parse("Custom://"+System.currentTimeMillis())));
                    alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    //alarmManager.cancel(pendingIntent);

                    Calendar alarmtime = Calendar.getInstance();
                    now = Calendar.getInstance();
                    alarmtime.set(Calendar.HOUR_OF_DAY, 21);
                    alarmtime.set(Calendar.MINUTE, 25);
                    alarmtime.set(Calendar.SECOND, 00);

                    if (now.after(alarmtime)) {
                        Log.d("Hey","Added a day");
                        alarmtime.add(Calendar.DATE, 1);
                    }

                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                            alarmtime.getTimeInMillis(),
                            AlarmManager.INTERVAL_DAY,
                            pendingIntent);
                    Log.d("Alarm Coba", "Alarm Coba set for Everyday");
                }
                else if(PreferenceUtils.getAlarmCoba(getApplicationContext()).equalsIgnoreCase("on")){
                    PreferenceUtils.saveAlarmCoba("off", getApplicationContext());
                    notif_terbit.setImageDrawable(getDrawable(R.drawable.icon_notification_white));
                    Toast.makeText(WaktuSalatActivity.this, "Reminder Coba Stopped!", Toast.LENGTH_SHORT).show();
                    intent = new Intent(WaktuSalatActivity.this, AlarmCobaBroadcastReceiver.class);
                    pendingIntent = PendingIntent.getBroadcast(WaktuSalatActivity.this,
                            0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    intent.setData((Uri.parse("Custom://"+System.currentTimeMillis())));
                    alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.cancel(pendingIntent);
                }
            }
        });

        notif_subuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (notif_subuh.getBackground().getConstantState()
                        .equals(getResources().getDrawable(R.drawable.icon_notification_white).getConstantState())){
                    valid = 0;
                } else if (notif_subuh.getBackground().getConstantState()
                        .equals(getResources().getDrawable(R.drawable.icon_notification_blue).getConstantState())){
                    valid = 1;
                }

                if (valid==0) {
                    notif_subuh.setImageDrawable(getDrawable(R.drawable.icon_notification_blue));
                    Toast.makeText(WaktuSalatActivity.this, "Reminder Subuh Set!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(WaktuSalatActivity.this, SubuhBroadcastReceiver.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(WaktuSalatActivity.this,
                            0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    intent.setData((Uri.parse("Custom://"+System.currentTimeMillis())));
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.cancel(pendingIntent);

                    Calendar alarmtime = Calendar.getInstance();
                    now = Calendar.getInstance();
                    alarmtime.set(Calendar.HOUR_OF_DAY, subuhalarmjam);
                    alarmtime.set(Calendar.MINUTE, subuhalarmmnt);
                    alarmtime.set(Calendar.SECOND, 0);

                    if (now.after(alarmtime)) {
                        Log.d("Hey","Added a day");
                        alarmtime.add(Calendar.DATE, 1);
                    }

                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                            alarmtime.getTimeInMillis(),
                            AlarmManager.INTERVAL_DAY,
                            pendingIntent);
                    Log.d("Alarm Subuh", "Alarm Subuh set for Everyday");
                }
                else if(valid==1){
                    notif_subuh.setImageDrawable(getDrawable(R.drawable.icon_notification_white));
                    Toast.makeText(WaktuSalatActivity.this, "Reminder Subuh Stopped!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        notif_zuhur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (notif_zuhur.getBackground().getConstantState()
                        .equals(getResources().getDrawable(R.drawable.icon_notification_white).getConstantState())){
                    valid = 2;
                } else if (notif_zuhur.getBackground().getConstantState()
                        .equals(getResources().getDrawable(R.drawable.icon_notification_blue).getConstantState())){
                    valid = 3;
                }

                if (valid==2){
                    notif_zuhur.setImageDrawable(getDrawable(R.drawable.icon_notification_blue));
                    Toast.makeText(WaktuSalatActivity.this, "Reminder Zuhur Set!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(WaktuSalatActivity.this, ZuhurBroadcastReceiver.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(WaktuSalatActivity.this,
                            0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    intent.setData((Uri.parse("Custom://"+System.currentTimeMillis())));
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.cancel(pendingIntent);

                    Calendar alarmtime = Calendar.getInstance();
                    Calendar now = Calendar.getInstance();
                    alarmtime.set(Calendar.HOUR_OF_DAY, zuhuralarmjam);
                    alarmtime.set(Calendar.MINUTE, zuhuralarmmnt);
                    alarmtime.set(Calendar.SECOND, 0);

                    if (now.after(alarmtime)) {
                        Log.d("Hey","Added a day");
                        alarmtime.add(Calendar.DATE, 1);
                    }

                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                            alarmtime.getTimeInMillis(),
                            AlarmManager.INTERVAL_DAY,
                            pendingIntent);
                    Log.d("Alarm Zuhur", "Alarm Zuhur set for Everyday");
                }
                else if (valid==3){
                    notif_zuhur.setImageDrawable(getDrawable(R.drawable.icon_notification_white));
                    Toast.makeText(WaktuSalatActivity.this, "Reminder Zuhur Stopped!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        notif_ashar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (notif_ashar.getBackground().getConstantState()
                        .equals(getResources().getDrawable(R.drawable.icon_notification_white).getConstantState())){
                    valid = 4;
                } else if (notif_ashar.getBackground().getConstantState()
                        .equals(getResources().getDrawable(R.drawable.icon_notification_blue).getConstantState())){
                    valid = 5;
                }

                if (valid==4){
                    notif_ashar.setImageDrawable(getDrawable(R.drawable.icon_notification_blue));
                    Toast.makeText(WaktuSalatActivity.this, "Reminder Ashar Set!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(WaktuSalatActivity.this, AsharBroadcastReceiver.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(WaktuSalatActivity.this,
                            0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    intent.setData((Uri.parse("Custom://"+System.currentTimeMillis())));
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.cancel(pendingIntent);

                    Calendar alarmtime = Calendar.getInstance();
                    Calendar now = Calendar.getInstance();
                    alarmtime.set(Calendar.HOUR_OF_DAY, asharalarmjam);
                    alarmtime.set(Calendar.MINUTE, asharalarmmnt);
                    alarmtime.set(Calendar.SECOND, 0);

                    if (now.after(alarmtime)) {
                        Log.d("Hey","Added a day");
                        alarmtime.add(Calendar.DATE, 1);
                    }

                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                            alarmtime.getTimeInMillis(),
                            AlarmManager.INTERVAL_DAY,
                            pendingIntent);
                    Log.d("Alarm Ashar", "Alarm Ashar set for Everyday");
                }
                else if (valid==5){
                    notif_ashar.setImageDrawable(getDrawable(R.drawable.icon_notification_white));
                    Toast.makeText(WaktuSalatActivity.this, "Reminder Ashar Stopped!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        notif_maghrib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (notif_maghrib.getBackground().getConstantState()
                        .equals(getResources().getDrawable(R.drawable.icon_notification_white).getConstantState())){
                    valid = 6;
                } else if (notif_maghrib.getBackground().getConstantState()
                        .equals(getResources().getDrawable(R.drawable.icon_notification_blue).getConstantState())){
                    valid = 7;
                }

                if (valid==6) {
                    notif_maghrib.setImageDrawable(getDrawable(R.drawable.icon_notification_blue));
                    Toast.makeText(WaktuSalatActivity.this, "Reminder Maghrib Set!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(WaktuSalatActivity.this, MaghribBroadcastReceiver.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(WaktuSalatActivity.this,
                            0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    intent.setData((Uri.parse("Custom://"+System.currentTimeMillis())));
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.cancel(pendingIntent);

                    Calendar alarmtime = Calendar.getInstance();
                    Calendar now = Calendar.getInstance();
                    alarmtime.set(Calendar.HOUR_OF_DAY, maghribalarmjam);
                    alarmtime.set(Calendar.MINUTE, maghribalarmmnt);
                    alarmtime.set(Calendar.SECOND, 0);

                    if (now.after(alarmtime)) {
                        Log.d("Hey","Added a day");
                        alarmtime.add(Calendar.DATE, 1);
                    }

                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                            alarmtime.getTimeInMillis(),
                            AlarmManager.INTERVAL_DAY,
                            pendingIntent);
                    Log.d("Alarm Maghrib", "Alarm Maghrib set for Everyday");
                }
                else if (valid==7) {
                    notif_maghrib.setImageDrawable(getDrawable(R.drawable.icon_notification_white));
                    Toast.makeText(WaktuSalatActivity.this, "Reminder Maghrib Stopped!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        notif_isya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (notif_isya.getBackground().getConstantState()
                        .equals(getResources().getDrawable(R.drawable.icon_notification_white).getConstantState())){
                    valid = 8;
                } else if (notif_isya.getBackground().getConstantState()
                        .equals(getResources().getDrawable(R.drawable.icon_notification_blue).getConstantState())){
                    valid = 9;
                }

                if (valid==8){
                    notif_isya.setImageDrawable(getDrawable(R.drawable.icon_notification_blue));
                    Toast.makeText(WaktuSalatActivity.this, "Reminder Isya Set!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(WaktuSalatActivity.this, IsyaBroadcastReceiver.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(WaktuSalatActivity.this,
                            0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    intent.setData((Uri.parse("Custom://"+System.currentTimeMillis())));
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.cancel(pendingIntent);

                    Calendar alarmtime = Calendar.getInstance();
                    Calendar now = Calendar.getInstance();
                    alarmtime.set(Calendar.HOUR_OF_DAY, isyaalarmjam);
                    alarmtime.set(Calendar.MINUTE, isyaalarmmnt);
                    alarmtime.set(Calendar.SECOND, 0);

                    if (now.after(alarmtime)) {
                        Log.d("Hey","Added a day");
                        alarmtime.add(Calendar.DATE, 1);
                    }

                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                            alarmtime.getTimeInMillis(),
                            AlarmManager.INTERVAL_DAY,
                            pendingIntent);
                    Log.d("Alarm Isya", "Alarm Isya set for Everyday");
                }
                else if (valid==9){
                    notif_isya.setImageDrawable(getDrawable(R.drawable.icon_notification_blue));
                    Toast.makeText(WaktuSalatActivity.this, "Reminder Isya Stopped!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    public void sendNotifCoba(){
        String msg = "Memasuki Waktu Sholat Coba";
        AudioAttributes att = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build();
        NotificationChannel channel = new NotificationChannel("coba", "Notif Coba", NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription(msg);
        channel.setSound(Uri.parse("android.resource://"+this.getPackageName()+"/" + R.raw.azansubuh), att);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    public void sendNotifSubuh(){
        String msg = "Memasuki Waktu Sholat Subuh";
        NotificationChannel channel = new NotificationChannel("subuh", "Notif Subuh", NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription(msg);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
    public void sendNotifZuhur(){
        String msg = "Memasuki Waktu Sholat Zuhur";
        NotificationChannel channel = new NotificationChannel("zuhur", "Notif Zuhur", NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription(msg);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
    public void sendNotifAshar(){
        String msg = "Memasuki Waktu Sholat Ashar";
        NotificationChannel channel = new NotificationChannel("ashar", "Notif Ashar", NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription(msg);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
    public void sendNotifMaghrib(){
        String msg = "Memasuki Waktu Sholat Maghrib";
        NotificationChannel channel = new NotificationChannel("maghrib", "Notif Maghrib", NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription(msg);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
    public void sendNotifIsyaa(){
        String msg = "Memasuki Waktu Sholat Isya";
        NotificationChannel channel = new NotificationChannel("isya", "Notif Isya", NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription(msg);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }


    public class MyClock extends TimerTask{
        @Override
        public void run() {
            WaktuSalatActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    today = new Time(Time.getCurrentTimezone());
                    today.setToNow();
                    txt_now.setText(today.format("%k:%M:%S"));
                }
            });
        }
    }

    private  void thread(){
        findViewById(R.id.framelayout).setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                getJadwalSolat();
            }
        }).start();
    }

    public void setWaktuSolat() {
        waktuSubuh.setText(dataJadwalSolat.getResults().getDatetime().get(0).getTimes().getFajr());
        waktuTerbit.setText(dataJadwalSolat.getResults().getDatetime().get(0).getTimes().getSunrise());
        waktuZuhur.setText(dataJadwalSolat.getResults().getDatetime().get(0).getTimes().getDhuhr());
        waktuAshar.setText(dataJadwalSolat.getResults().getDatetime().get(0).getTimes().getAsr());
        waktuMagrib.setText(dataJadwalSolat.getResults().getDatetime().get(0).getTimes().getMaghrib());
        waktuIsya.setText(dataJadwalSolat.getResults().getDatetime().get(0).getTimes().getIsha());

        if (PreferenceUtils.getAlarmCoba(getApplicationContext()).equalsIgnoreCase("on")){
            notif_terbit.setImageDrawable(getDrawable(R.drawable.icon_notification_blue));
        } else if(PreferenceUtils.getAlarmCoba(getApplicationContext()).equalsIgnoreCase("off")){
            notif_terbit.setImageDrawable(getDrawable(R.drawable.icon_notification_white));
        }

        if (PreferenceUtils.getAlarmSubuh(getApplicationContext()).equalsIgnoreCase("on")){
            notif_subuh.setImageDrawable(getDrawable(R.drawable.icon_notification_blue));
        } else if(PreferenceUtils.getAlarmSubuh(getApplicationContext()).equalsIgnoreCase("off")){
            notif_subuh.setImageDrawable(getDrawable(R.drawable.icon_notification_white));
        }

        if (PreferenceUtils.getAlarmZuhur(getApplicationContext()).equalsIgnoreCase("on")){
            notif_zuhur.setImageDrawable(getDrawable(R.drawable.icon_notification_blue));
        } else if(PreferenceUtils.getAlarmZuhur(getApplicationContext()).equalsIgnoreCase("off")){
            notif_zuhur.setImageDrawable(getDrawable(R.drawable.icon_notification_white));
        }

        if (PreferenceUtils.getAlarmAshar(getApplicationContext()).equalsIgnoreCase("on")){
            notif_ashar.setImageDrawable(getDrawable(R.drawable.icon_notification_blue));
        } else if(PreferenceUtils.getAlarmAshar(getApplicationContext()).equalsIgnoreCase("off")){
            notif_ashar.setImageDrawable(getDrawable(R.drawable.icon_notification_white));
        }

        if (PreferenceUtils.getAlarmMagrib(getApplicationContext()).equalsIgnoreCase("on")){
            notif_maghrib.setImageDrawable(getDrawable(R.drawable.icon_notification_blue));
        } else if(PreferenceUtils.getAlarmMagrib(getApplicationContext()).equalsIgnoreCase("off")){
            notif_maghrib.setImageDrawable(getDrawable(R.drawable.icon_notification_white));
        }

        if (PreferenceUtils.getAlarmIsya(getApplicationContext()).equalsIgnoreCase("on")){
            notif_isya.setImageDrawable(getDrawable(R.drawable.icon_notification_blue));
        } else if(PreferenceUtils.getAlarmIsya(getApplicationContext()).equalsIgnoreCase("off")){
            notif_isya.setImageDrawable(getDrawable(R.drawable.icon_notification_white));
        }

        parseWaktuSholat();
    }

    public void parseWaktuSholat() {
        subuhalarm = waktuSubuh.getText().toString();
        subuhalarmjam = Integer.parseInt(subuhalarm.substring(0,2));
        subuhalarmmnt = Integer.parseInt(subuhalarm.substring(subuhalarm.length()-2));
        zuhuralarm = waktuZuhur.getText().toString();
        zuhuralarmjam = Integer.parseInt(zuhuralarm.substring(0,2));
        zuhuralarmmnt = Integer.parseInt(zuhuralarm.substring(zuhuralarm.length()-2));
        asharalarm = waktuAshar.getText().toString();
        asharalarmjam = Integer.parseInt(asharalarm.substring(0,2));
        asharalarmmnt = Integer.parseInt(asharalarm.substring(asharalarm.length()-2));
        maghribalarm = waktuMagrib.getText().toString();
        maghribalarmjam = Integer.parseInt(maghribalarm.substring(0,2));
        maghribalarmmnt = Integer.parseInt(maghribalarm.substring(maghribalarm.length()-2));
        isyaalarm = waktuIsya.getText().toString();
        isyaalarmjam = Integer.parseInt(isyaalarm.substring(0,2));
        isyaalarmmnt = Integer.parseInt(isyaalarm.substring(isyaalarm.length()-2));
    }

    public void getJadwalSolat() {
        final APIInterfacesRest apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        final Call<ModelJadwalSolat> jadwalSolat = apiInterface.getJadwalSolat();
        jadwalSolat.enqueue(new Callback<ModelJadwalSolat>() {
            @Override
            public void onResponse(Call<ModelJadwalSolat> call, Response<ModelJadwalSolat> response) {
                dataJadwalSolat =  response.body();
                if(dataJadwalSolat != null){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            findViewById(R.id.framelayout).setVisibility(View.GONE);
                            setWaktuSolat();
                        }
                    });
                }
            }
            @Override
            public void onFailure(Call<ModelJadwalSolat> call, Throwable t) {
                Log.e("Error", t.getMessage());
                //Toast.makeText(LoginActivity.this, "Terjadi gangguan koneksi (getUser)", Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }

    public void onBackPressed() {
        Intent a = new Intent(WaktuSalatActivity.this, HomeActivity.class);
        startActivity(a);
        finish();
    }
}
