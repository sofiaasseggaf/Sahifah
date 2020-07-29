package com.project.sahifah.ziarah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.project.sahifah.R;

public class ZiarahMarufah extends AppCompatActivity {

    ImageButton btn_back;
    Button btn_ziarah_baqi, btn_ziarah_arbain, btn_ziarah_aliyasin, btn_ziarah_aminallah, btn_ziarah_jamiah;
    Button btn_ziarah_jamiah_aimmah, btn_ziarah_jamiah_saghirah, btn_ziarah_jamiah_kabirah, btn_ziarah_rajabiah;
    Button btn_ziarah_asyura, btn_ziarah_asyura_ghair, btn_ziarah_niabati, btn_ziarah_warist, btn_ziarah_wada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ziarah_marufah);

        btn_ziarah_baqi = findViewById(R.id.btn_ziarah_baqi);
        btn_ziarah_arbain = findViewById(R.id.btn_ziarah_arbain);
        btn_ziarah_aliyasin = findViewById(R.id.btn_ziarah_aliyasin);
        btn_ziarah_aminallah = findViewById(R.id.btn_ziarah_aminallah);
        btn_ziarah_jamiah = findViewById(R.id.btn_ziarah_jamiah);
        btn_ziarah_jamiah_aimmah = findViewById(R.id.btn_ziarah_jamiah_aimmah);
        btn_ziarah_jamiah_saghirah = findViewById(R.id.btn_ziarah_jamiah_saghirah);
        btn_ziarah_jamiah_kabirah = findViewById(R.id.btn_ziarah_jamiah_kabirah);
        btn_ziarah_rajabiah = findViewById(R.id.btn_ziarah_rajabiah);
        btn_ziarah_asyura = findViewById(R.id.btn_ziarah_asyura);
        btn_ziarah_asyura_ghair = findViewById(R.id.btn_ziarah_asyura_ghair);
        btn_ziarah_niabati = findViewById(R.id.btn_ziarah_niabati);
        btn_ziarah_warist = findViewById(R.id.btn_ziarah_warist);
        btn_ziarah_wada = findViewById(R.id.btn_ziarah_wada);
        btn_back = findViewById(R.id.btn_back);

        btn_ziarah_baqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufah.this, ZiarahMarufahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Aimmah Baqi'");
                startActivity(a);
            }
        });

        btn_ziarah_arbain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufah.this, ZiarahMarufahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Arbain");
                startActivity(a);
            }
        });

        btn_ziarah_aliyasin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufah.this, ZiarahMarufahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Ali Yasin");
                startActivity(a);
            }
        });

        btn_ziarah_aminallah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufah.this, ZiarahMarufahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Aminallah");
                startActivity(a);
            }
        });

        btn_ziarah_jamiah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufah.this, ZiarahMarufahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Jamiah");
                startActivity(a);
            }
        });

        btn_ziarah_jamiah_kabirah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufah.this, ZiarahMarufahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Jamiah Kabirah");
                startActivity(a);
            }
        });

        btn_ziarah_jamiah_saghirah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufah.this, ZiarahMarufahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Jamiah Saghirah");
                startActivity(a);
            }
        });

        btn_ziarah_jamiah_aimmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufah.this, ZiarahMarufahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Jamiah Aimmah Al-Mu'minin");
                startActivity(a);
            }
        });

        btn_ziarah_rajabiah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufah.this, ZiarahMarufahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Rajabiyah");
                startActivity(a);
            }
        });

        btn_ziarah_asyura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufah.this, ZiarahMarufahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Asyura'");
                startActivity(a);
            }
        });

        btn_ziarah_asyura_ghair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufah.this, ZiarahMarufahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Asyura' Ghairu Ma'rufah");
                startActivity(a);
            }
        });

        btn_ziarah_niabati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufah.this, ZiarahMarufahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Niabati");
                startActivity(a);
            }
        });

        btn_ziarah_warist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufah.this, ZiarahMarufahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Warist");
                startActivity(a);
            }
        });

        btn_ziarah_wada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufah.this, ZiarahMarufahContentActivity.class);
                a.putExtra("namaziarah", "Ziarah Wada' Aimmah");
                startActivity(a);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void onBackPressed() {
        Intent a = new Intent(ZiarahMarufah.this, ZiarahActivity.class);
        startActivity(a);
        finish();
    }
}
