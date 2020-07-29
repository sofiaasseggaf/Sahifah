package com.project.sahifah.fiqih;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.sahifah.HikmahActivity;
import com.project.sahifah.HomeActivity;
import com.project.sahifah.oase.OaseActivity;
import com.project.sahifah.ProfileActivity;
import com.project.sahifah.R;

public class FiqihContentActivity extends AppCompatActivity {

    TextView txtNamaFiqih;
    String namafiqih;
    ImageButton btn_back;
    ImageButton btn_home, btn_hikmah, btn_search, btn_oase, btn_profile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiqih_content);

        btn_back = findViewById(R.id.btn_back);
        /*btn_home = findViewById(R.id.btn_home);
        btn_hikmah = findViewById(R.id.btn_hikmah);
        btn_search = findViewById(R.id.btn_search);
        btn_oase = findViewById(R.id.btn_oase);
        btn_profile = findViewById(R.id.btn_profile);*/
        txtNamaFiqih = findViewById(R.id.txtNamaFiqih);

        namafiqih = getIntent().getStringExtra("namafiqih");
        txtNamaFiqih.setText(namafiqih);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        /*btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(FiqihContentActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(FiqihContentActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(FiqihContentActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(FiqihContentActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });*/
    }

    public void onBackPressed() {
        Intent a = new Intent(FiqihContentActivity.this, FiqihActivity.class);
        startActivity(a);
        finish();
    }
}
