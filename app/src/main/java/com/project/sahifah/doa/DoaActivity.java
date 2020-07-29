package com.project.sahifah.doa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.project.sahifah.HomeActivity;
import com.project.sahifah.R;

public class DoaActivity extends AppCompatActivity {

    ImageButton btn_back;
    LinearLayout btn_doa_setelah_shalat, btn_doa_harian, btn_doa_tawassul, btn_doa_faraj, btn_doa_shabah, btn_doa_kumayl;
    LinearLayout btn_doa_yastasyir, btn_doa_adilah, btn_doa_jausyan_kabir, btn_doa_jausyan_shagir, btn_doa_iftitah;
    LinearLayout btn_doa_asyarat, btn_doa_simat, btn_doa_masylul, btn_doa_mujeer, btn_doa_saifu_shagir;
    LinearLayout btn_doa_alhajj, btn_doa_baha, btn_doa_ya_uddati, btn_doa_ya_mafzai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa);

        btn_doa_setelah_shalat = findViewById(R.id.btn_doa_setelah_shalat);
        btn_doa_harian = findViewById(R.id.btn_doa_harian);
        btn_doa_tawassul = findViewById(R.id.btn_doa_tawassul);
        btn_doa_faraj = findViewById(R.id.btn_doa_faraj);
        btn_doa_shabah = findViewById(R.id.btn_doa_shabah);
        btn_doa_kumayl = findViewById(R.id.btn_doa_kumayl);
        btn_doa_yastasyir = findViewById(R.id.btn_doa_yastasyir);
        btn_doa_adilah = findViewById(R.id.btn_doa_adilah);
        btn_doa_jausyan_kabir = findViewById(R.id.btn_doa_jausyan_kabir);
        btn_doa_jausyan_shagir = findViewById(R.id.btn_doa_jausyan_shagir);
        btn_doa_iftitah = findViewById(R.id.btn_doa_iftitah);
        btn_doa_asyarat = findViewById(R.id.btn_doa_asyarat);
        btn_doa_simat = findViewById(R.id.btn_doa_simat);
        btn_doa_masylul = findViewById(R.id.btn_doa_masylul);
        btn_doa_mujeer = findViewById(R.id.btn_doa_mujeer);
        btn_doa_saifu_shagir = findViewById(R.id.btn_doa_saifu_shagir);
        btn_doa_alhajj = findViewById(R.id.btn_doa_alhajj);
        btn_doa_baha = findViewById(R.id.btn_doa_baha);
        btn_doa_ya_uddati = findViewById(R.id.btn_doa_ya_uddati);
        btn_doa_ya_mafzai = findViewById(R.id.btn_doa_ya_mafzai);
        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_doa_setelah_shalat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaSetelahShalat.class);
                startActivity(a);
            }
        });

        btn_doa_harian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaHarian.class);
                startActivity(a);
            }
        });

        btn_doa_tawassul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Tawassul");
                startActivity(a);
            }
        });

        btn_doa_faraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Faraj");
                startActivity(a);
            }
        });

        btn_doa_shabah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Shabah");
                startActivity(a);
            }
        });

        btn_doa_kumayl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Kumayl");
                a.putExtra("id_detail","15");
                startActivity(a);
            }
        });

        btn_doa_yastasyir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Yastasyir");
                startActivity(a);
            }
        });

        btn_doa_adilah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Adilah");
                startActivity(a);
            }
        });

        btn_doa_jausyan_kabir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Jausyan Kabir");
                a.putExtra("id_detail","14");
                startActivity(a);
            }
        });

        btn_doa_jausyan_shagir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Jausyan Shagir");
                startActivity(a);
            }
        });

        btn_doa_iftitah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Iftitah");
                a.putExtra("id_detail","12");
                startActivity(a);
            }
        });

        btn_doa_asyarat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa 'Asyarat");
                startActivity(a);
            }
        });

        btn_doa_simat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Simat");
                startActivity(a);
            }
        });

        btn_doa_masylul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Masylul");
                startActivity(a);
            }
        });

        btn_doa_mujeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Mujeer");
                startActivity(a);
            }
        });

        btn_doa_saifu_shagir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Saifu Shagir");
                startActivity(a);
            }
        });

        btn_doa_alhajj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Al Hajj");
                a.putExtra("id_detail","11");
                startActivity(a);
            }
        });

        btn_doa_baha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Baha'");
                a.putExtra("id_detail","13");
                startActivity(a);
            }
        });

        btn_doa_ya_uddati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Ya 'Uddati");
                a.putExtra("id_detail","16");
                startActivity(a);
            }
        });

        btn_doa_ya_mafzai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaActivity.this, DoaContentActivity.class);
                a.putExtra("namadoa", "Doa Ya Mafzai'");
                a.putExtra("id_detail","17");
                startActivity(a);
            }
        });

    }

    public void onBackPressed() {
        Intent a = new Intent(DoaActivity.this, HomeActivity.class);
        startActivity(a);
        finish();
    }
}
