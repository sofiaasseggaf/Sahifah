package com.project.sahifah;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.project.sahifah.oase.OaseActivity;
import com.project.sahifah.utility.PreferenceUtils;

public class ProfileActivity extends AppCompatActivity {

    ImageButton btn_back;
    ImageButton btn_home, btn_hikmah, btn_search, btn_oase, btn_profile;
    TextView btn_home2, btn_hikmah2, btn_search2, btn_oase2, btn_profile2;
    LinearLayout btn_home3, btn_hikmah3, btn_search3, btn_oase3, btn_profile3;
    TextView txt_nama;

    int fontSize, fontSizeArab;

    LinearLayout btn_kontak_kami, btn_kontak_kami2, btn_bagikan_app, btn_bagikan_app2, btn_beri_penilaian, btn_beri_penilaian2;
    LinearLayout btn_size, btn_size2, btn_logout, btn_logout2, btn_faq, btn_faq2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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
        txt_nama = findViewById(R.id.txt_nama);
        btn_logout = findViewById(R.id.btn_logout);
        btn_logout2 = findViewById(R.id.btn_logout2);
        btn_size = findViewById(R.id.btn_size);
        btn_size2 = findViewById(R.id.btn_size2);
        btn_faq = findViewById(R.id.btn_faq);
        btn_faq2 = findViewById(R.id.btn_faq2);
        btn_beri_penilaian = findViewById(R.id.btn_beri_penilaian);
        btn_beri_penilaian2 = findViewById(R.id.btn_beri_penilaian2);
        btn_bagikan_app = findViewById(R.id.btn_bagikan_app);
        btn_bagikan_app2 = findViewById(R.id.btn_bagikan_app2);
        btn_kontak_kami = findViewById(R.id.btn_kontak_kami);
        btn_kontak_kami2 = findViewById(R.id.btn_kontak_kami2);

        txt_nama.setText(PreferenceUtils.getName(this));


        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });
        btn_hikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });
        // BTN SEARCH
        btn_oase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });
        // BTN PROFILE
        btn_home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });
        btn_hikmah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });
        // BTN SEARCH
        btn_oase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });
        // BTN PROFILE
        btn_home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });
        btn_hikmah3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });
        // BTN SEARCH
        btn_oase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });
        // BTN PROFILE


        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });
        btn_logout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });
        btn_size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFont();
            }
        });
        btn_size2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFont();
            }
        });
        btn_kontak_kami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogKontak();
            }
        });
        btn_kontak_kami2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogKontak();
            }
        });
        btn_beri_penilaian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent();
                a.setAction(Intent.ACTION_VIEW);
                a.addCategory(Intent.CATEGORY_BROWSABLE);
                a.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.project.sahifah"));
                startActivity(a);
            }
        });
        btn_beri_penilaian2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent();
                a.setAction(Intent.ACTION_VIEW);
                a.addCategory(Intent.CATEGORY_BROWSABLE);
                a.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.project.sahifah"));
                startActivity(a);
            }
        });
        btn_faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, "appsahifah@gmail.com");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "appsahifah@gmail.com");
                emailIntent.setPackage("com.google.android.gm");
                emailIntent.setType("text/plain");
                startActivity(Intent.createChooser(emailIntent, "Send Mail"));
            }
        });
        btn_faq2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, "appsahifah@gmail.com");
                emailIntent.setPackage("com.google.android.gm");
                emailIntent.setType("text/plain");
                startActivity(Intent.createChooser(emailIntent, "Send Mail"));
            }
        });
        btn_bagikan_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareApp = new Intent(Intent.ACTION_SEND);
                shareApp.putExtra(Intent.EXTRA_TEXT, "DOWNLOAD APLIKASI INI https://play.google.com/store/apps/details?id=com.project.sahifah");
                shareApp.setType("text/plain");
                shareApp.setPackage("com.whatsapp");
                startActivity(shareApp);
            }
        });
        btn_bagikan_app2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareApp = new Intent(Intent.ACTION_SEND);
                shareApp.putExtra(Intent.EXTRA_TEXT, "DOWNLOAD APLIKASI INI https://play.google.com/store/apps/details?id=com.project.sahifah");
                shareApp.setType("text/plain");
                shareApp.setPackage("com.whatsapp");
                startActivity(shareApp);
            }
        });


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void dialogKontak(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
        builder.setMessage("appsahifah@gmail.com")
                .setNeutralButton("tutup", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void dialogFont(){

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.item_fontsize, null);

        SeekBar seekbarFont = view.findViewById(R.id.seekbarFont);
        TextView textviewFont = view.findViewById(R.id.textviewFont);
        SeekBar seekbarFontArab = view.findViewById(R.id.seekbarFontArab);
        TextView textviewFontArab = view.findViewById(R.id.textviewFontArab);
        TextView textviewFontukuranarab = view.findViewById(R.id.textviewFontukuranarab);

        seekbarFont.setProgress(PreferenceUtils.getUkuranFont(getApplicationContext()));
        textviewFont.setTextSize((float)PreferenceUtils.getUkuranFont(getApplicationContext()));
        textviewFont.setText("Ukuran Text Anda : "+PreferenceUtils.getUkuranFont(getApplicationContext()));
        seekbarFontArab.setProgress(PreferenceUtils.getUkuranFontArab(getApplicationContext()));
        textviewFontArab.setTextSize((float)PreferenceUtils.getUkuranFontArab(getApplicationContext()));
        textviewFontukuranarab.setText("Ukuran Text Arab Anda : "+PreferenceUtils.getUkuranFontArab(getApplicationContext()));

        seekbarFont.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                fontSize = progress;
                textviewFont.setTextSize((float)progress);
                textviewFont.setText("Ukuran Text Anda : "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekbarFontArab.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                fontSizeArab = progress;
                textviewFontArab.setTextSize((float)progress);
                textviewFontukuranarab.setText("Ukuran Text Arab Anda : "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        AlertDialog.Builder builderfont = new AlertDialog.Builder(ProfileActivity.this);
        builderfont.setView(view)
                .setTitle("Set Font Size")
                .setPositiveButton("save font size", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PreferenceUtils.saveUkuranFont(fontSize,getApplicationContext());
                        PreferenceUtils.saveUkuranFontArab(fontSizeArab,getApplicationContext());
                    }
                })
                .setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builderfont.create();
        alertDialog.show();
    }

    public void showPopup(){
        AlertDialog.Builder alert = new AlertDialog.Builder(ProfileActivity.this);
        alert.setMessage("Are you sure?")
                .setPositiveButton("Logout", new DialogInterface.OnClickListener()                 {

                    public void onClick(DialogInterface dialog, int which) {

                        logout(); // Last step. Logout function

                    }
                }).setNegativeButton("Cancel", null);

        AlertDialog alert1 = alert.create();
        alert1.show();
    }

    public void logout(){
        PreferenceUtils.saveName("", getApplicationContext());
        PreferenceUtils.saveUsername("", getApplicationContext());
        PreferenceUtils.savePassword("", getApplicationContext());
        PreferenceUtils.saveAlarmCoba("off", getApplicationContext());
        PreferenceUtils.saveAlarmSubuh("off", getApplicationContext());
        PreferenceUtils.saveAlarmZuhur("off", getApplicationContext());
        PreferenceUtils.saveAlarmAshar("off", getApplicationContext());
        PreferenceUtils.saveAlarmMagrib("off", getApplicationContext());
        PreferenceUtils.saveAlarmIsya("off", getApplicationContext());
        Intent a = new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(a);
        finish();
    }

    public void onBackPressed() {
        Intent a = new Intent(ProfileActivity.this, HomeActivity.class);
        startActivity(a);
        finish();
    }
}
