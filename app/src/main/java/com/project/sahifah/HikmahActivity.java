package com.project.sahifah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.sahifah.oase.OaseActivity;

public class HikmahActivity extends AppCompatActivity {

    ImageButton btn_back;
    ImageButton btn_home, btn_hikmah, btn_search, btn_oase, btn_profile;
    TextView btn_home2, btn_hikmah2, btn_search2, btn_oase2, btn_profile2;
    LinearLayout btn_home3, btn_hikmah3, btn_search3, btn_oase3, btn_profile3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hikmah);

        btn_back = findViewById(R.id.btn_back);
        /*btn_home = findViewById(R.id.btn_home);
        btn_hikmah = findViewById(R.id.btn_hikmah);
        btn_search = findViewById(R.id.btn_search);
        btn_oase = findViewById(R.id.btn_oase);
        btn_profile = findViewById(R.id.btn_profile);
        btn_home2 = findViewById(R.id.btn_home2);
        btn_hikmah2 = findViewById(R.id.btn_hikmah2);
        btn_search2 = findViewById(R.id.btn_search2);
        btn_oase2 = findViewById(R.id.btn_oase2);
        btn_profile2 = findViewById(R.id.btn_profile2);
        btn_home3 = findViewById(R.id.btn_home3);
        btn_hikmah3 = findViewById(R.id.btn_hikmah3);
        btn_search3 = findViewById(R.id.btn_search3);
        btn_oase3 = findViewById(R.id.btn_oase3);
        btn_profile3 = findViewById(R.id.btn_profile3);*/

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        /*btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HikmahActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HikmahActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HikmahActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HikmahActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HikmahActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HikmahActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HikmahActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HikmahActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HikmahActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HikmahActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HikmahActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HikmahActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });*/
    }

    public void onBackPressed() {
        Intent a = new Intent(HikmahActivity.this, HomeActivity.class);
        startActivity(a);
        finish();
    }
}
