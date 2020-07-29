package com.project.sahifah.munajat;

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

public class MunajatActivity extends AppCompatActivity {

    ImageButton btn_back;
    LinearLayout btn_munajat_a, btn_munajat_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_munajat);

        btn_munajat_a = findViewById(R.id.btn_munajat_a);
        btn_munajat_b = findViewById(R.id.btn_munajat_b);
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_munajat_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MunajatActivity.this, MunajatContentActivity.class);
                a.putExtra("namamunajat", "Munajat Imam Ali Bin Husein");
                startActivity(a);
            }
        });

        btn_munajat_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MunajatActivity.this, MunajatContentActivity.class);
                a.putExtra("namamunajat", "Munajat Sya'baniyah");
                startActivity(a);
            }
        });
    }

    public void onBackPressed() {
        Intent a = new Intent(MunajatActivity.this, HomeActivity.class);
        startActivity(a);
        finish();
    }
}
