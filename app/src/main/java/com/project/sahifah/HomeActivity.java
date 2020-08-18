package com.project.sahifah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.msarhan.ummalqura.calendar.UmmalquraCalendar;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.snackbar.Snackbar;
import com.project.sahifah.adapter.AdapterDashboard;
import com.project.sahifah.adapter.AdapterSliderOase;
import com.project.sahifah.amalan.AmalanActivity;
import com.project.sahifah.broadcastReceiver.ConnectivityReceiver;
import com.project.sahifah.broadcastReceiver.NetworkStateChangeReceiver;
import com.project.sahifah.doa.DoaActivity;
import com.project.sahifah.fiqih.FiqihActivity;
import com.project.sahifah.model.ModelDashboard;
import com.project.sahifah.model.ModelSliderOase;
import com.project.sahifah.model.ModelUsers;
import com.project.sahifah.munajat.MunajatActivity;
import com.project.sahifah.oase.OaseActivity;
import com.project.sahifah.surah.SurahActivity;
import com.project.sahifah.utility.PreferenceUtils;
import com.project.sahifah.ziarah.ZiarahActivity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import static com.project.sahifah.broadcastReceiver.NetworkStateChangeReceiver.IS_NETWORK_AVAILABLE;

public class HomeActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    ImageButton btn_surah, btn_doa, btn_munajat, btn_amalan;
    RelativeLayout btn_surah2, btn_doa2, btn_munajat2, btn_amalan2;
    ImageButton btn_ziarah, btn_fiqih, btn_waktu_sholat, btn_kalender;
    RelativeLayout btn_ziarah2, btn_fiqih2, btn_waktu_sholat2, btn_kalender2;
    ImageButton btn_home, btn_hikmah, btn_search, btn_oase, btn_profile;
    TextView btn_home2, btn_hikmah2, btn_search2, btn_oase2, btn_profile2;
    LinearLayout btn_home3, btn_hikmah3, btn_search3, btn_oase3, btn_profile3;
    TextView lainnyaHikmah, txtTanggal, txtTanggalHij, txtCity, txtWaktuSholat, txtWaktuazan, txtNama;
    String city;

    ViewPager viewPager, viewPager2;
    AdapterDashboard adapter;
    AdapterSliderOase adapter2;
    List<ModelDashboard> models;
    List<ModelSliderOase> models2;

    ModelUsers dataUser;

    InterstitialAd mInterstitialAd;
    AdView adBanner;
    AdRequest adRequest;

    RelativeLayout activity_home;

    int jamm, mntt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        activity_home = findViewById(R.id.activity_home);

        btn_surah = findViewById(R.id.btn_surah);
        btn_doa = findViewById(R.id.btn_doa);
        btn_munajat = findViewById(R.id.btn_munajat);
        btn_amalan = findViewById(R.id.btn_amalan);
        btn_ziarah = findViewById(R.id.btn_ziarah);
        btn_fiqih = findViewById(R.id.btn_fiqih);
        btn_waktu_sholat = findViewById(R.id.btn_waktu_shalat);
        btn_kalender = findViewById(R.id.btn_kalender);

        btn_surah2 = findViewById(R.id.btn_surah2);
        btn_doa2 = findViewById(R.id.btn_doa2);
        btn_munajat2 = findViewById(R.id.btn_munajat2);
        btn_amalan2 = findViewById(R.id.btn_amalan2);
        btn_ziarah2 = findViewById(R.id.btn_ziarah2);
        btn_fiqih2 = findViewById(R.id.btn_fiqih2);
        btn_waktu_sholat2 = findViewById(R.id.btn_waktu_shalat2);
        btn_kalender2 = findViewById(R.id.btn_kalender2);

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

        lainnyaHikmah = findViewById(R.id.lainnyaHikmah);
        txtTanggal = findViewById(R.id.txtTanggal);
        txtTanggalHij = findViewById(R.id.txtTanggalHij);
        txtCity = findViewById(R.id.txtCity);
        txtWaktuSholat = findViewById(R.id.txtWaktuSholat);
//        txtWaktuazan = findViewById(R.id.txtWaktuazan);
        txtNama = findViewById(R.id.txtNama);


        txtNama.setTextSize((float)PreferenceUtils.getUkuranFont(getApplicationContext()));
        //txtTanggal.setTextSize((float)PreferenceUtils.getUkuranFont(getApplicationContext()));
        //txtTanggalHij.setTextSize((float)PreferenceUtils.getUkuranFont(getApplicationContext()));
        //txtCity.setTextSize((float)PreferenceUtils.getUkuranFont(getApplicationContext()));
        //txtWaktuazan.setTextSize((float)PreferenceUtils.getUkuranFont(getApplicationContext()));
        //txtWaktuSholat.setTextSize((float)PreferenceUtils.getUkuranFont(getApplicationContext()));

        checkConnection();
        dataUser = getIntent().getParcelableExtra("dataUser");
        txtNama.setText("Assalamualaikum,\n"+PreferenceUtils.getName(this));

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        adBanner = findViewById(R.id.adBanner);
        adRequest = new AdRequest.Builder().addTestDevice("61A8A3E1BAFCF1A9F1EB99725D32DE83").build();
        adBanner.loadAd(adRequest);


        //adRequest = new AdRequest.Builder().addTestDevice("61A8A3E1BAFCF1A9F1EB99725D32DE83").build();
        //adBanner.setAdUnitId("ca-app-pub-8425532275014279/1961600814");


        IntentFilter intentFilter = new IntentFilter(NetworkStateChangeReceiver.NETWORK_AVAILABLE_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                boolean isNetworkAvailable = intent.getBooleanExtra(IS_NETWORK_AVAILABLE, false);
                String networkStatus = isNetworkAvailable ? "connected" : "disconnected";

                Snackbar.make(findViewById(R.id.activity_home), "Network Status: " + networkStatus, Snackbar.LENGTH_LONG).show();
            }
        }, intentFilter);

        Timer waktusolat = new Timer();
        waktusolat.scheduleAtFixedRate(new WaktuSholat(), 0, 60000);

        Date today = new Date();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat formatMasehi = new SimpleDateFormat("dd MMMM yyyy");
        String dateToStr = formatMasehi.format(today);
        txtTanggal.setText(dateToStr);

        Locale en = Locale.ENGLISH;
        UmmalquraCalendar uCal = new UmmalquraCalendar(en);
        int thn = uCal.get(Calendar.YEAR);                                      // 1436
        String bln = uCal.getDisplayName(Calendar.MONTH, Calendar.LONG, en);       // Jumada al-Ula
        int tgl = uCal.get(Calendar.DAY_OF_MONTH);                             // 10
        txtTanggalHij.setText(tgl + " " + bln + " " + thn);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1000);
        } else {
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            try {
                city = hereLocation(location.getLatitude(), location.getLongitude());
                txtCity.setText(city);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "NOT FOUND !", Toast.LENGTH_SHORT).show();
            }
        }

        models = new ArrayList<>();
        models.add(new ModelDashboard(R.drawable.img_dashboard));
        models.add(new ModelDashboard(R.drawable.img_dashboard));
        models.add(new ModelDashboard(R.drawable.img_dashboard));
        models.add(new ModelDashboard(R.drawable.img_dashboard));

        models2 = new ArrayList<>();
        models2.add(new ModelSliderOase(R.drawable.img_oase_2, "Aturan mencukur rambut saat mengunjungi tanah suci"));
        models2.add(new ModelSliderOase(R.drawable.img_oase_2, "Aturan mencukur rambut saat mengunjungi tanah suci"));
        models2.add(new ModelSliderOase(R.drawable.img_oase_2, "Aturan mencukur rambut saat mengunjungi tanah suci"));
        models2.add(new ModelSliderOase(R.drawable.img_oase_2, "Aturan mencukur rambut saat mengunjungi tanah suci"));

        adapter = new AdapterDashboard(models, this);
        adapter2 = new AdapterSliderOase(models2, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(170, 0, 170, 0);

        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(adapter2);
        viewPager2.setPadding(170, 0, 170, 0);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 3000, 2000);

        Timer timerWaktuSholat = new Timer();
        timerWaktuSholat.scheduleAtFixedRate(new MyClock(), 0, 1000);

        btn_surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, SurahActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_doa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, DoaActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_munajat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, MunajatActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_amalan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, AmalanActivity.class);
                startActivity(a);
            }
        });

        btn_ziarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, ZiarahActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_fiqih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, FiqihActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_waktu_sholat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, WaktuSalatActivity.class);
                a.putExtra("city", city);
                startActivity(a);
                finish();
            }
        });

        btn_kalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, KalenderActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_surah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, SurahActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_doa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, DoaActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_munajat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, MunajatActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_amalan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, AmalanActivity.class);
                startActivity(a);
            }
        });

        btn_ziarah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, ZiarahActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_fiqih2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, FiqihActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_waktu_sholat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, WaktuSalatActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_kalender2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, KalenderActivity.class);
                startActivity(a);
                finish();
            }
        });


        // BTN HOME

        btn_hikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        lainnyaHikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN HOME

        btn_hikmah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN HOME

        btn_hikmah3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });

    }

/*

    private void showInterstitialadd() {

        mInterstitialAd = new InterstitialAd(HomeActivity.this);
        mInterstitialAd.setAdUnitId(getString(R.string.unit_id));
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

*/

    private String hereLocation(double lat, double lon) {
        String cityName = "";

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = geocoder.getFromLocation(lat, lon, 10);
            if (addresses.size() > 0) {
                for (Address adr : addresses) {
                    if (adr.getLocality() != null && adr.getLocality().length() > 0) {
                        cityName = adr.getLocality();
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cityName;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1000: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                    if (ActivityCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            &&
                            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    try {
                        city = hereLocation(location.getLatitude(), location.getLongitude());
                        txtCity.setText(city);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(this, "NOT FOUND !", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "PERMISSION NOT GRANTED !", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }


    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        showSnack(isConnected);
    }

    private void showSnack(boolean isConnected) {
        String message;
        int color;
        if (isConnected) {
            message = "Connected to Internet";
            color = Color.WHITE;
        } else {
            message = "Sorry! Not connected to internet";
            color = Color.RED;
        }

        Snackbar snackbar = Snackbar
                .make(activity_home, message, Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // register connection status listener
        App.getInstance().setConnectivityListener(this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public class WaktuSholat extends TimerTask{
        @Override
        public void run() {

            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat jam = new SimpleDateFormat("HH");
                    SimpleDateFormat mnt = new SimpleDateFormat("mm");
                    jamm = Integer.parseInt(jam.format(calendar.getTime()));
                    mntt = Integer.parseInt(mnt.format(calendar.getTime()));

                    if (jamm < 04 && mntt < 43) {
                        txtWaktuSholat.setText("SUBUH 04:43");
                    } else if (jamm < 11 && mntt < 51) {
                        txtWaktuSholat.setText("ZUHUR 11:51");
                    } else if (jamm < 15 && mntt < 13) {
                        txtWaktuSholat.setText("ASHAR 15:13");
                    } else if (jamm < 17 && mntt < 58) {
                        txtWaktuSholat.setText("MAGRIB 17:58");
                    } else if (jamm <= 18 && mntt < 54) {
                        txtWaktuSholat.setText("ISYA 18:54");
                    } else if (jamm == 18 && mntt > 54) {
                        txtWaktuSholat.setText("SUBUH 04:43");
                    } else if (jamm > 18) {
                        txtWaktuSholat.setText("SUBUH 04:43");
                    }
                }
            });
        }
    }

    public class MyTimerTask extends TimerTask{
        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    } else if (viewPager.getCurrentItem() == 2){
                        viewPager.setCurrentItem(3);
                    } else if(viewPager.getCurrentItem() == 3){
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

    public class MyClock extends TimerTask{
        @Override
        public void run() {

            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Time today = new Time(Time.getCurrentTimezone());
                    today.setToNow();
                    //txtWaktuazan.setText(today.format("%k:%M:%S") + " menuju waktu sholat");
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Anda Mau Menutup Aplikasi")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        HomeActivity.super.onBackPressed();
                        finish();
                        finishAffinity();
                    }
                })

                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog =builder.create();
        alertDialog.show();
    }
}
