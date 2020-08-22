package com.project.sahifah.munajat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.project.sahifah.adapter.adapterdoa.AdapterDoa;
import com.project.sahifah.R;

public class MunajatContentActivity extends AppCompatActivity {

    TextView txtNamaMunajat;
    String namamunajat, munajatId;
    ImageButton btn_back;
    ImageButton btn_home, btn_hikmah, btn_search, btn_oase, btn_profile;

    //List<ModelMunajat> dataModelMunajat =  new ArrayList<>();
    //List<ModelMunajat> listMunajat =  new ArrayList<>();
    AdapterDoa itemList;
    RecyclerView rvMunajat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_munajat_content);

        btn_back = findViewById(R.id.btn_back);
       /* btn_home = findViewById(R.id.btn_home);
        btn_hikmah = findViewById(R.id.btn_hikmah);
        btn_search = findViewById(R.id.btn_search);
        btn_oase = findViewById(R.id.btn_oase);
        btn_profile = findViewById(R.id.btn_profile);*/
        txtNamaMunajat = findViewById(R.id.txtNamaMunajat);
        rvMunajat = findViewById(R.id.rvMunajat);

        namamunajat = getIntent().getStringExtra("namamunajat");
        munajatId = getIntent().getStringExtra("munajatId");
        txtNamaMunajat.setText(namamunajat);

        //thread();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        /*btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MunajatContentActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MunajatContentActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MunajatContentActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MunajatContentActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });*/
    }

    private void thread(){
        findViewById(R.id.framelayout).setVisibility(View.VISIBLE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //getDataMunajat();
            }
        }).start();
    }


    public void onBackPressed() {
        Intent a = new Intent(MunajatContentActivity.this, MunajatActivity.class);
        startActivity(a);
        finish();
    }
}
