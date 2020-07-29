package com.project.sahifah.amalan.bulanramadhan.doaharian;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;
import com.project.sahifah.HomeActivity;
import com.project.sahifah.R;
import com.project.sahifah.amalan.bulanramadhan.AmalanBulanRamadhan;
import com.project.sahifah.doa.DoaActivity;

public class AmalanBulanRamadhanDoaHarian extends AppCompatActivity {

    ImageButton btn_back;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amalan_bulan_ramadhan_doa_harian);

        btn_back = findViewById(R.id.btn_back);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new HariKe1(), "Hari Ke 1");
        adapter.addFragment(new HariKe2(), "Hari Ke 2");
        adapter.addFragment(new HariKe3(), "Hari Ke 3");
        adapter.addFragment(new HariKe4(), "Hari Ke 4");
        adapter.addFragment(new HariKe5(), "Hari Ke 5");
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
        Intent a = new Intent(AmalanBulanRamadhanDoaHarian.this, AmalanBulanRamadhan.class);
        startActivity(a);
        finish();
    }
}
