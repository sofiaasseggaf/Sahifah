package com.project.sahifah.doa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.project.sahifah.R;

public class DoaHarian extends AppCompatActivity {

    ImageButton btn_back;
    LinearLayout btn_doa_hari_ahad, btn_doa_hari_senin, btn_doa_hari_selasa, btn_doa_hari_rabu;
    LinearLayout btn_doa_hari_kamis, btn_doa_hari_jumat, btn_doa_hari_sabtu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_harian);

        btn_back = findViewById(R.id.btn_back);
        btn_doa_hari_ahad = findViewById(R.id.btn_doa_hari_ahad);
        btn_doa_hari_senin = findViewById(R.id.btn_doa_hari_senin);
        btn_doa_hari_selasa = findViewById(R.id.btn_doa_hari_selasa);
        btn_doa_hari_rabu = findViewById(R.id.btn_doa_hari_rabu);
        btn_doa_hari_kamis = findViewById(R.id.btn_doa_hari_kamis);
        btn_doa_hari_jumat = findViewById(R.id.btn_doa_hari_jumat);
        btn_doa_hari_sabtu = findViewById(R.id.btn_doa_hari_sabtu);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_doa_hari_ahad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaHarian.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Hari Ahad");
                a.putExtra("id_detail","32");
                startActivity(a);
            }
        });

        btn_doa_hari_senin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaHarian.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Hari Senin");
                a.putExtra("id_detail","33");
                startActivity(a);
            }
        });

        btn_doa_hari_selasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaHarian.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Hari Selasa");
                a.putExtra("id_detail","34");
                startActivity(a);
            }
        });

        btn_doa_hari_rabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaHarian.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Hari Rabu");
                a.putExtra("id_detail","35");
                startActivity(a);
            }
        });

        btn_doa_hari_kamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaHarian.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Hari Kamis");
                a.putExtra("id_detail","36");
                startActivity(a);
            }
        });

        btn_doa_hari_jumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaHarian.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Hari Jum'at");
                a.putExtra("id_detail","37");
                startActivity(a);
            }
        });

        btn_doa_hari_sabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaHarian.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Hari Sabtu");
                a.putExtra("id_detail","38");
                startActivity(a);
            }
        });

    }

    public void onBackPressed() {
        Intent a = new Intent(DoaHarian.this, DoaActivity.class);
        startActivity(a);
        finish();
    }
}
