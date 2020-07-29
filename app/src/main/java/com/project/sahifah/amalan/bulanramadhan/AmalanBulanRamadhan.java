package com.project.sahifah.amalan.bulanramadhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.project.sahifah.R;
import com.project.sahifah.amalan.AmalanActivity;
import com.project.sahifah.amalan.bulanramadhan.doaharian.AmalanBulanRamadhanDoaHarian;
import com.project.sahifah.amalan.bulanramadhan.khusus.AmalanBulanRamadhanKhusus;
import com.project.sahifah.amalan.bulanramadhan.lailatulqadrkhusus.AmalanBulanRamadhanLailatulQadr;
import com.project.sahifah.amalan.bulanramadhan.umum.AmalanBulanRamadhanUmum;

public class AmalanBulanRamadhan extends AppCompatActivity {

    ImageButton btn_back;
    LinearLayout btn_amalan_ramadhan_umum, btn_amalan_ramadhan_khusus, btn_amalan_ramadhan_lailatulqadr, btn_amalan_ramadhan_harian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amalan_bulan_ramadhan);

        btn_amalan_ramadhan_umum = findViewById(R.id.btn_amalan_ramadhan_umum);
        btn_amalan_ramadhan_khusus = findViewById(R.id.btn_amalan_ramadhan_khusus);
        btn_amalan_ramadhan_lailatulqadr = findViewById(R.id.btn_amalan_ramadhan_lailatulqadr);
        btn_amalan_ramadhan_harian = findViewById(R.id.btn_amalan_ramadhan_harian);
        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_amalan_ramadhan_umum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanBulanRamadhan.this, AmalanBulanRamadhanUmum.class);
                startActivity(a);
            }
        });

        btn_amalan_ramadhan_khusus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanBulanRamadhan.this, AmalanBulanRamadhanKhusus.class);
                startActivity(a);
            }
        });


        btn_amalan_ramadhan_lailatulqadr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanBulanRamadhan.this, AmalanBulanRamadhanLailatulQadr.class);
                startActivity(a);
            }
        });

        btn_amalan_ramadhan_harian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AmalanBulanRamadhan.this, AmalanBulanRamadhanDoaHarian.class);
                startActivity(a);
            }
        });

    }

    public void onBackPressed() {
        Intent a = new Intent(AmalanBulanRamadhan.this, AmalanActivity.class);
        startActivity(a);
        finish();
    }
}
