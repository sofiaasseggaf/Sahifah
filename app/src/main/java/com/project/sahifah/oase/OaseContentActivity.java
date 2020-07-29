package com.project.sahifah.oase;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.sahifah.APIService.APIClient;
import com.project.sahifah.APIService.APIInterfacesRest;
import com.project.sahifah.HikmahActivity;
import com.project.sahifah.HomeActivity;
import com.project.sahifah.ProfileActivity;
import com.project.sahifah.R;
import com.project.sahifah.adapter.AdapterSurah;
import com.project.sahifah.model.ModelOase;
import com.project.sahifah.model.ModelQuran;
import com.project.sahifah.surah.SurahActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OaseContentActivity extends AppCompatActivity {

    ImageView oase_img_content;
    TextView oase_title_content, oase_date_content;
    ModelOase oaseContent;

    ImageButton btn_back;
    ImageButton btn_home, btn_hikmah, btn_search, btn_oase, btn_profile;
    TextView btn_home2, btn_hikmah2, btn_search2, btn_oase2, btn_profile2;
    LinearLayout btn_home3, btn_hikmah3, btn_search3, btn_oase3, btn_profile3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oase_content);

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

        oase_img_content = findViewById(R.id.oase_img_content);
        oase_title_content = findViewById(R.id.oase_title_content);
        oase_date_content = findViewById(R.id.oase_date_content);
        oaseContent = getIntent().getParcelableExtra("selected_oase");

        oase_img_content.setImageResource(R.drawable.img_oase_1);
        oase_title_content.setText(oaseContent.getTitle());
        oase_date_content.setText("7 Maret 2019, oleh Hamid");

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

         btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseContentActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseContentActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseContentActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseContentActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseContentActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseContentActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseContentActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseContentActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseContentActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseContentActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseContentActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseContentActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });
    }

    public void onBackPressed() {
        Intent a = new Intent(OaseContentActivity.this, OaseActivity.class);
        startActivity(a);
        finish();
    }
}
