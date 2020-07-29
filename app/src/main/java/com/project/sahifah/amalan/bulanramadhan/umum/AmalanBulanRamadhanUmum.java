package com.project.sahifah.amalan.bulanramadhan.umum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;
import com.project.sahifah.R;
import com.project.sahifah.amalan.bulanramadhan.AmalanBulanRamadhan;
import com.project.sahifah.amalan.bulanramadhan.doaharian.AmalanBulanRamadhanDoaHarian;
import com.project.sahifah.amalan.bulanramadhan.doaharian.HariKe1;
import com.project.sahifah.amalan.bulanramadhan.doaharian.HariKe2;
import com.project.sahifah.amalan.bulanramadhan.doaharian.HariKe3;
import com.project.sahifah.amalan.bulanramadhan.doaharian.HariKe4;
import com.project.sahifah.amalan.bulanramadhan.doaharian.HariKe5;
import com.project.sahifah.amalan.bulanramadhan.doaharian.ViewPagerAdapter;

public class AmalanBulanRamadhanUmum extends AppCompatActivity {

    ImageButton btn_back;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapterRamadhanUmum adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amalan_bulan_ramadhan_umum);

        btn_back = findViewById(R.id.btn_back);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapterRamadhanUmum(getSupportFragmentManager());

        adapter.addFragment(new Sahur(), "Sahur");
        adapter.addFragment(new Siang(), "Siang");
        adapter.addFragment(new SiangdanMalam(), "Siang & Malam");
        adapter.addFragment(new Malam(), "Malam");
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
        Intent a = new Intent(AmalanBulanRamadhanUmum.this, AmalanBulanRamadhan.class);
        startActivity(a);
        finish();
    }
}
