package com.project.sahifah.amalan.bulanramadhan.khusus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;
import com.project.sahifah.R;
import com.project.sahifah.amalan.bulanramadhan.AmalanBulanRamadhan;
import com.project.sahifah.amalan.bulanramadhan.umum.AmalanBulanRamadhanUmum;
import com.project.sahifah.amalan.bulanramadhan.umum.Malam;
import com.project.sahifah.amalan.bulanramadhan.umum.Sahur;
import com.project.sahifah.amalan.bulanramadhan.umum.Siang;
import com.project.sahifah.amalan.bulanramadhan.umum.SiangdanMalam;
import com.project.sahifah.amalan.bulanramadhan.umum.ViewPagerAdapterRamadhanUmum;

public class AmalanBulanRamadhanKhusus extends AppCompatActivity {

    ImageButton btn_back;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapterRamadhanKhusus adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amalan_bulan_ramadhan_khusus);

        btn_back = findViewById(R.id.btn_back);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapterRamadhanKhusus(getSupportFragmentManager());

        adapter.addFragment(new HariKe1(), "Hari Ke 1");
        adapter.addFragment(new MalamKe1(), "Malam Ke 1");
        adapter.addFragment(new HariKe6(), "Hari Ke 6");
        adapter.addFragment(new HariKe15(), "Hari Ke 15");
        adapter.addFragment(new MalamKe13(), "Malam Ke 13");
        adapter.addFragment(new MalamKe14(), "Malam Ke 14");
        adapter.addFragment(new MalamKe15(), "Malam Ke 15");
        adapter.addFragment(new MalamKe17(), "Malam Ke 17");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void onBackPressed() {
        Intent a = new Intent(AmalanBulanRamadhanKhusus.this, AmalanBulanRamadhan.class);
        startActivity(a);
        finish();
    }
}
