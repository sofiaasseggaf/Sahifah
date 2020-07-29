package com.project.sahifah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.msarhan.ummalqura.calendar.UmmalquraCalendar;
import com.project.sahifah.model.jadwalsolat.Date;
import com.project.sahifah.oase.OaseActivity;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class KalenderActivity extends AppCompatActivity {

    ImageButton btn_back;
    ImageButton btn_home, btn_hikmah, btn_search, btn_oase, btn_profile;
    SwitchCompat btn_switch;
    LinearLayout kalendermasehi;
    LinearLayout kalenderhijri;
    TextView txtmasehi, bulanmasehi, bulanhijriyah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalender);

        btn_back = findViewById(R.id.btn_back);
        /*btn_home = findViewById(R.id.btn_home);
        btn_hikmah = findViewById(R.id.btn_hikmah);
        btn_search = findViewById(R.id.btn_search);
        btn_oase = findViewById(R.id.btn_oase);
        btn_profile = findViewById(R.id.btn_profile);*/
        btn_switch = findViewById(R.id.btn_switch);
        txtmasehi = findViewById(R.id.txtmasehi);
        kalendermasehi = findViewById(R.id.kalendermasehi);
        kalenderhijri = findViewById(R.id.kalenderhijri);
        bulanmasehi = findViewById(R.id.bulanmasehi);
        bulanhijriyah = findViewById(R.id.bulanhijriyah);

        kalendermasehi.setVisibility(View.VISIBLE);
        btn_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_switch.isChecked()) {
                    txtmasehi.setText("Hijriyah");
                    kalenderhijri.setVisibility(View.VISIBLE);
                    kalendermasehi.setVisibility(View.GONE);
                } else {
                    txtmasehi.setText("Masehi");
                    kalendermasehi.setVisibility(View.VISIBLE);
                    kalenderhijri.setVisibility(View.GONE);
                }
            }
        });

        Date today = new Date();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat formatMasehi = new SimpleDateFormat("MMMM yyyy");
        String dateToStr = formatMasehi.format(today);
        bulanmasehi.setText(dateToStr);

        Locale en = Locale.ENGLISH;
        UmmalquraCalendar uCal = new UmmalquraCalendar(en);
        int thn = uCal.get(Calendar.YEAR);                                      // 1436
        String bln = uCal.getDisplayName(Calendar.MONTH, Calendar.LONG, en);       // Jumada al-Ula
        //int tgl = uCal.get(Calendar.DAY_OF_MONTH);                             // 10
        bulanhijriyah.setText(bln+" "+thn);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

      /*  UmmalquraCalendar cal = new UmmalquraCalendar();
        cal.get(Calendar.YEAR);
        cal.get(Calendar.MONTH);
        cal.get(Calendar.DAY_OF_MONTH);*/

        /*btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(KalenderActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(KalenderActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(KalenderActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(KalenderActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });*/

        /*UmmalquraCalendar uCal = new UmmalquraCalendar();
        HijriDatePickerDialog dpd = HijriDatePickerDialog.newInstance(
                (HijriDatePickerDialog.OnDateSetListener) this,
                uCal.get(Calendar.YEAR),
                uCal.get(Calendar.MONTH),
                uCal.get(Calendar.DAY_OF_MONTH)
        );
        dpd.setLocale(Locale.getDefault());*/
    }

    public void onBackPressed() {
        Intent a = new Intent(KalenderActivity.this, HomeActivity.class);
        startActivity(a);
        finish();
    }
}
