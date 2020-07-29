package com.project.sahifah.doa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;
import com.project.sahifah.R;
import com.project.sahifah.amalan.bulanramadhan.doaharian.ViewPagerAdapter;

public class DoaSetelahShalat extends AppCompatActivity {

    ImageButton btn_back;
    LinearLayout btn_taqib_umum, btn_taqib_shalat_subuh, btn_taqib_shalat_zuhur, btn_taqib_shalat_ashar, btn_taqib_shalat_magrib, btn_taqib_shalat_isya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_setelah_shalat);

        btn_back = findViewById(R.id.btn_back);
        btn_taqib_umum = findViewById(R.id.btn_taqib_umum);
        btn_taqib_shalat_subuh = findViewById(R.id.btn_taqib_shalat_subuh);
        btn_taqib_shalat_zuhur = findViewById(R.id.btn_taqib_shalat_zuhur);
        btn_taqib_shalat_ashar = findViewById(R.id.btn_taqib_shalat_ashar);
        btn_taqib_shalat_magrib = findViewById(R.id.btn_taqib_shalat_magrib);
        btn_taqib_shalat_isya = findViewById(R.id.btn_taqib_shalat_isya);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_taqib_umum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaSetelahShalat.this, DoaSetelahShalatContentActivity.class);
                a.putExtra("namadoa", "Ta'qib Umum Shalat");
                a.putExtra("id_detail","26");
                startActivity(a);
            }
        });

        btn_taqib_shalat_subuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaSetelahShalat.this, DoaSetelahShalatContentActivity.class);
                a.putExtra("namadoa", "Ta'qib Shalat Subuh");
                a.putExtra("id_detail","27");
                startActivity(a);
            }
        });

        btn_taqib_shalat_zuhur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaSetelahShalat.this, DoaSetelahShalatContentActivity.class);
                a.putExtra("namadoa", "Ta'qib Shalat Zuhur");
                a.putExtra("id_detail","28");
                startActivity(a);
            }
        });

        btn_taqib_shalat_ashar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaSetelahShalat.this, DoaSetelahShalatContentActivity.class);
                a.putExtra("namadoa", "Ta'qib Shalat Ashar");
                a.putExtra("id_detail","29");
                startActivity(a);
            }
        });

        btn_taqib_shalat_magrib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaSetelahShalat.this, DoaSetelahShalatContentActivity.class);
                a.putExtra("namadoa", "Ta'qib Shalat Magrib");
                a.putExtra("id_detail","30");
                startActivity(a);
            }
        });

        btn_taqib_shalat_isya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaSetelahShalat.this, DoaSetelahShalatContentActivity.class);
                a.putExtra("namadoa", "Ta'qib Shalat Isya");
                a.putExtra("id_detail","31");
                startActivity(a);
            }
        });

    }

    public void onBackPressed() {
        Intent a = new Intent(DoaSetelahShalat.this, DoaActivity.class);
        startActivity(a);
        finish();
    }
}
