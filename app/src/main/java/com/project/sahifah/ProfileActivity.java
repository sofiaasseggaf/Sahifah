package com.project.sahifah;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.sahifah.oase.OaseActivity;
import com.project.sahifah.utility.PreferenceUtils;

public class ProfileActivity extends AppCompatActivity {

    ImageButton btn_back;
    ImageButton btn_home, btn_hikmah, btn_search, btn_oase, btn_profile;
    TextView btn_home2, btn_hikmah2, btn_search2, btn_oase2, btn_profile2;
    LinearLayout btn_home3, btn_hikmah3, btn_search3, btn_oase3, btn_profile3;
    Button btn_logout;
    TextView txt_nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btn_back = findViewById(R.id.btn_back);
        btn_home = findViewById(R.id.btn_home);
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
        btn_profile3 = findViewById(R.id.btn_profile3);
        btn_logout = findViewById(R.id.btn_logout);
        txt_nama = findViewById(R.id.txt_nama);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txt_nama.setText(PreferenceUtils.getName(this));

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN PROFILE

        btn_home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN PROFILE

        btn_home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN PROFILE

    }

    public void showPopup(){
        AlertDialog.Builder alert = new AlertDialog.Builder(ProfileActivity.this);
        alert.setMessage("Are you sure?")
                .setPositiveButton("Logout", new DialogInterface.OnClickListener()                 {

                    public void onClick(DialogInterface dialog, int which) {

                        logout(); // Last step. Logout function

                    }
                }).setNegativeButton("Cancel", null);

        AlertDialog alert1 = alert.create();
        alert1.show();
    }



    public void logout(){
        PreferenceUtils.saveName("", getApplicationContext());
        PreferenceUtils.saveUsername("", getApplicationContext());
        PreferenceUtils.savePassword("", getApplicationContext());
        Intent a = new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(a);
        finish();
    }

    public void onBackPressed() {
        Intent a = new Intent(ProfileActivity.this, HomeActivity.class);
        startActivity(a);
        finish();
    }
}
