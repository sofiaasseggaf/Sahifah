package com.project.sahifah.surah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.project.sahifah.HomeActivity;
import com.project.sahifah.R;
import com.project.sahifah.doa.DoaActivity;
import com.project.sahifah.doa.DoaContentActivity;

public class SurahActivity extends AppCompatActivity {

    ImageButton btn_back;
    LinearLayout btn_yasin, btn_arrahman,  btn_alwaqiah, btn_aljumuah, btn_almulk, btn_annaba;
    LinearLayout btn_alala, btn_asysyams, btn_alqadr, btn_alzilzilah, btn_aladiyat, btn_alkafirun;
    LinearLayout btn_annashr, btn_alikhlas, btn_alfalaq, btn_annas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);

        btn_yasin = findViewById(R.id.btn_yasin);
        btn_arrahman = findViewById(R.id.btn_arrahman);
        btn_alwaqiah = findViewById(R.id.btn_alwaqiah);
        btn_aljumuah = findViewById(R.id.btn_aljumuah);
        btn_almulk = findViewById(R.id.btn_almulk);
        btn_annaba = findViewById(R.id.btn_annaba);
        btn_alala = findViewById(R.id.btn_alala);
        btn_asysyams = findViewById(R.id.btn_asysyams);
        btn_alqadr = findViewById(R.id.btn_alqadr);
        btn_alzilzilah = findViewById(R.id.btn_alzilzalah);
        btn_aladiyat = findViewById(R.id.btn_aladiyat);
        btn_alkafirun = findViewById(R.id.btn_alkafirun);
        btn_annashr = findViewById(R.id.btn_annashr);
        btn_alikhlas = findViewById(R.id.btn_alikhlas);
        btn_alfalaq = findViewById(R.id.btn_alfalaq);
        btn_annas = findViewById(R.id.btn_annas);
        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_yasin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah Yasin");
                a.putExtra("suraId", "36");
                startActivity(a);
            }
        });

        btn_arrahman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah Ar-Rahman");
                a.putExtra("suraId", "55");
                startActivity(a);
            }
        });

        btn_alwaqiah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah Al Waqiah");
                a.putExtra("suraId", "56");
                startActivity(a);
            }
        });

        btn_aljumuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah Al Jumu'ah");
                a.putExtra("suraId", "62");
                startActivity(a);
            }
        });

        btn_almulk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah Al Mulk");
                a.putExtra("suraId", "67");
                startActivity(a);
            }
        });

        btn_annaba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah An Naba'");
                a.putExtra("suraId", "78");
                startActivity(a);
            }
        });

        btn_alala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah Al 'Ala");
                a.putExtra("suraId", "87");
                startActivity(a);
            }
        });

        btn_asysyams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah Asy Syams");
                a.putExtra("suraId", "91");
                startActivity(a);
            }
        });

        btn_alqadr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah Al Qadr");
                a.putExtra("suraId", "97");
                startActivity(a);
            }
        });

        btn_alzilzilah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah Al Zilzilah");
                a.putExtra("suraId", "99");
                startActivity(a);
            }
        });

        btn_aladiyat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah Al Adiyat'");
                a.putExtra("suraId", "100");
                startActivity(a);
            }
        });

        btn_alkafirun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah Al Kafirun");
                a.putExtra("suraId", "109");
                startActivity(a);
            }
        });

        btn_annashr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah An Nashr");
                a.putExtra("suraId", "110");
                startActivity(a);
            }
        });

        btn_alikhlas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah Al Ikhlas");
                a.putExtra("suraId", "112");
                startActivity(a);
            }
        });

        btn_alfalaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah Al Falaq");
                a.putExtra("suraId", "113");
                startActivity(a);
            }
        });

        btn_annas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahActivity.this, SurahContentActivity.class);
                a.putExtra("namasurah", "Surah An Nas");
                a.putExtra("suraId", "114");
                startActivity(a);
            }
        });
    }

    public void onBackPressed() {
        Intent a = new Intent(SurahActivity.this, HomeActivity.class);
        startActivity(a);
        finish();
    }
}
