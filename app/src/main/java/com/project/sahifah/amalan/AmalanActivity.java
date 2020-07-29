package com.project.sahifah.amalan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.project.sahifah.HomeActivity;
import com.project.sahifah.R;
import com.project.sahifah.amalan.bulanrajab.AmalanBulanRajab;
import com.project.sahifah.amalan.bulanramadhan.AmalanBulanRamadhan;

public class AmalanActivity extends AppCompatActivity {

    ImageButton btn_back;
    LinearLayout btn_bulan_muharram, btn_bulan_safar, btn_bulan_rabiulawwal, btn_bulan_rabiulakhir, btn_bulan_jumadilawwal, btn_bulan_jumadilakhir;
    LinearLayout btn_bulan_rajab, btn_bulan_syakban, btn_bulan_ramadhan, btn_bulan_syawwal, btn_bulan_zulkaidah, btn_bulan_zulhijjah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amalan);

        btn_back = findViewById(R.id.btn_back);
        btn_bulan_muharram = findViewById(R.id.btn_bulan_muharram);
        btn_bulan_safar = findViewById(R.id.btn_bulan_safar);
        btn_bulan_rabiulawwal = findViewById(R.id.btn_bulan_rabiulawwal);
        btn_bulan_rabiulakhir = findViewById(R.id.btn_bulan_rabiulakhir);
        btn_bulan_jumadilawwal = findViewById(R.id.btn_bulan_jumadilawwal);
        btn_bulan_jumadilakhir = findViewById(R.id.btn_bulan_jumadilakhir);
        btn_bulan_rajab = findViewById(R.id.btn_bulan_rajab);
        btn_bulan_syakban = findViewById(R.id.btn_bulan_syakban);
        btn_bulan_ramadhan = findViewById(R.id.btn_bulan_ramadhan);
        btn_bulan_syawwal = findViewById(R.id.btn_bulan_syawwal);
        btn_bulan_zulkaidah = findViewById(R.id.btn_bulan_zulkaidah);
        btn_bulan_zulhijjah = findViewById(R.id.btn_bulan_zulhijah);


        btn_bulan_muharram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanActivity.this, AmalanContentActivity.class);
                a.putExtra("namaamalan", "Amalan Bulan Muharram");
                startActivity(a);
            }
        });

        btn_bulan_safar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanActivity.this, AmalanContentActivity.class);
                a.putExtra("namaamalan", "Amalan Bulan Safar");
                startActivity(a);
            }
        });

        btn_bulan_rabiulawwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanActivity.this, AmalanContentActivity.class);
                a.putExtra("namaamalan", "Amalan Bulan Rabiul Awwal");
                startActivity(a);
            }
        });

        btn_bulan_rabiulakhir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanActivity.this, AmalanContentActivity.class);
                a.putExtra("namaamalan", "Amalan Bulan Rabiul Akhir");
                startActivity(a);
            }
        });

        btn_bulan_jumadilawwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanActivity.this, AmalanContentActivity.class);
                a.putExtra("namaamalan", "Amalan Bulan Jumadil Awwal");
                startActivity(a);
            }
        });

        btn_bulan_jumadilakhir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanActivity.this, AmalanContentActivity.class);
                a.putExtra("namaamalan", "Amalan Bulan Jumadil Akhir");
                startActivity(a);
            }
        });

        btn_bulan_rajab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanActivity.this, AmalanBulanRajab.class);
                startActivity(a);
            }
        });

        btn_bulan_syakban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanActivity.this, AmalanContentActivity.class);
                a.putExtra("namaamalan", "Amalan Bulan Syakban");
                startActivity(a);
            }
        });

        btn_bulan_ramadhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanActivity.this, AmalanBulanRamadhan.class);
                startActivity(a);
            }
        });

        btn_bulan_syawwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanActivity.this, AmalanContentActivity.class);
                a.putExtra("namaamalan", "Amalan Bulan Syawwal");
                startActivity(a);
            }
        });

        btn_bulan_zulkaidah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanActivity.this, AmalanContentActivity.class);
                a.putExtra("namaamalan", "Amalan Bulan Zulkaidah");
                startActivity(a);
            }
        });

        btn_bulan_zulhijjah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanActivity.this, AmalanContentActivity.class);
                a.putExtra("namaamalan", "Amalan Bulan Zulhijjah");
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
        Intent a = new Intent(AmalanActivity.this, HomeActivity.class);
        startActivity(a);
        finish();
    }
}
