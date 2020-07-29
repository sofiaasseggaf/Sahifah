package com.project.sahifah.ziarah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.project.sahifah.HomeActivity;
import com.project.sahifah.R;
import com.project.sahifah.surah.SurahActivity;
import com.project.sahifah.surah.SurahContentActivity;

public class ZiarahActivity extends AppCompatActivity {

    ImageButton btn_back;
    LinearLayout btn_ziarah_harian, btn_ziarah_rasulullah, btn_ziarah_imam_ali, btn_ziarah_imam_husein, btn_tata_cara_ziarah, btn_tata_cara_dan_adab_safar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ziarah);

        btn_ziarah_harian = findViewById(R.id.btn_ziarah_harian);
        btn_ziarah_rasulullah = findViewById(R.id.btn_ziarah_rasulullah);
        btn_ziarah_imam_ali = findViewById(R.id.btn_ziarah_imam_ali);
        btn_ziarah_imam_husein = findViewById(R.id.btn_ziarah_imam_husein);
        btn_tata_cara_ziarah = findViewById(R.id.btn_tata_cara_ziarah);
        btn_tata_cara_dan_adab_safar = findViewById(R.id.btn_tata_cara_dan_adab_safar);
        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_ziarah_harian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahActivity.this, ZiarahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Harian");
                startActivity(a);
            }
        });

        btn_ziarah_rasulullah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahActivity.this, ZiarahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah kepada Rasulullah SAWW");
                startActivity(a);
            }
        });

        btn_ziarah_imam_ali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahActivity.this, ZiarahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah kepada Imam Ali a.s");
                startActivity(a);
            }
        });

        btn_ziarah_imam_husein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahActivity.this, ZiarahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah kepada Imam Husein a.s");
                startActivity(a);
            }
        });

        btn_tata_cara_ziarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahActivity.this, ZiarahContentActivity.class);
                a.putExtra("namaziarah", "Tata Cara Berziarah");
                startActivity(a);
            }
        });

        btn_tata_cara_dan_adab_safar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahActivity.this, ZiarahContentActivity.class);
                a.putExtra("namaziarah", "Tata Cara dan Adab Safar");
                startActivity(a);
            }
        });
    }

    public void onBackPressed() {
        Intent a = new Intent(ZiarahActivity.this, HomeActivity.class);
        startActivity(a);
        finish();
    }
}
