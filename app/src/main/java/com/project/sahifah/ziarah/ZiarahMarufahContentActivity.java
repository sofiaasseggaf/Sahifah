package com.project.sahifah.ziarah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.sahifah.HikmahActivity;
import com.project.sahifah.oase.OaseActivity;
import com.project.sahifah.ProfileActivity;
import com.project.sahifah.R;

public class ZiarahMarufahContentActivity extends AppCompatActivity {

    TextView txtNamaZiarah;
    String namaziarah;
    ImageButton btn_back;
    ImageButton btn_home, btn_hikmah, btn_search, btn_oase, btn_profile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ziarah_content);

        btn_back = findViewById(R.id.btn_back);
        btn_home = findViewById(R.id.btn_home);
        btn_hikmah = findViewById(R.id.btn_hikmah);
        btn_search = findViewById(R.id.btn_search);
        btn_oase = findViewById(R.id.btn_oase);
        btn_profile = findViewById(R.id.btn_profile);
        txtNamaZiarah = findViewById(R.id.txtNamaZiarah);

        namaziarah = getIntent().getStringExtra("namaziarah");
        txtNamaZiarah.setText(namaziarah);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufahContentActivity.this, ZiarahMarufah.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufahContentActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufahContentActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ZiarahMarufahContentActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });
    }

    public void onBackPressed() {
        Intent a = new Intent(ZiarahMarufahContentActivity.this, ZiarahMarufah.class);
        startActivity(a);
        finish();
    }
}
