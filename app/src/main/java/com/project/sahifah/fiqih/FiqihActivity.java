package com.project.sahifah.fiqih;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.project.sahifah.HomeActivity;
import com.project.sahifah.R;
import com.project.sahifah.surah.SurahActivity;
import com.project.sahifah.surah.SurahContentActivity;

public class FiqihActivity extends AppCompatActivity {

    ImageButton btn_back;
    LinearLayout btn_fiqih_bersuci, btn_fiqih_shalat, btn_fiqih_puasa, btn_fiqih_haji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiqih);

        btn_fiqih_bersuci = findViewById(R.id.btn_fiqih_bersuci);
        btn_fiqih_shalat = findViewById(R.id.btn_fiqih_shalat);
        btn_fiqih_puasa = findViewById(R.id.btn_fiqih_puasa);
        btn_fiqih_haji = findViewById(R.id.btn_fiqih_haji);

        btn_fiqih_bersuci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(FiqihActivity.this, FiqihContentActivity.class);
                a.putExtra("namafiqih", "Bersuci");
                startActivity(a);
            }
        });

        btn_fiqih_shalat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(FiqihActivity.this, FiqihContentActivity.class);
                a.putExtra("namafiqih", "Shalat");
                startActivity(a);
            }
        });

        btn_fiqih_puasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(FiqihActivity.this, FiqihContentActivity.class);
                a.putExtra("namafiqih", "Puasa");
                startActivity(a);
            }
        });

        btn_fiqih_haji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(FiqihActivity.this, FiqihContentActivity.class);
                a.putExtra("namafiqih", "Haji");
                startActivity(a);
            }
        });

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void onBackPressed() {
        Intent a = new Intent(FiqihActivity.this, HomeActivity.class);
        startActivity(a);
        finish();
    }
}
