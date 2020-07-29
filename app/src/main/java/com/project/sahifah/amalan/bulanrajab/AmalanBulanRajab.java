package com.project.sahifah.amalan.bulanrajab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;
import com.project.sahifah.R;
import com.project.sahifah.amalan.AmalanActivity;
import com.project.sahifah.amalan.bulanramadhan.AmalanBulanRamadhan;
import com.project.sahifah.amalan.bulanramadhan.doaharian.AmalanBulanRamadhanDoaHarian;
import com.project.sahifah.amalan.bulanramadhan.doaharian.HariKe1;
import com.project.sahifah.amalan.bulanramadhan.doaharian.HariKe2;
import com.project.sahifah.amalan.bulanramadhan.doaharian.ViewPagerAdapter;

public class AmalanBulanRajab extends AppCompatActivity {

    ImageButton btn_back;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapterRajab adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amalan_bulan_rajab);

        btn_back = findViewById(R.id.btn_back);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapterRajab(getSupportFragmentManager());

        adapter.addFragment(new AmalanBulanRajabUmum(), "UMUM");
        adapter.addFragment(new AmalanBulanRajabKhusus(), "KHUSUS");
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
        Intent a = new Intent(AmalanBulanRajab.this, AmalanActivity.class);
        startActivity(a);
        finish();
    }
}
