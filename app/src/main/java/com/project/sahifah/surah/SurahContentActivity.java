package com.project.sahifah.surah;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.sahifah.APIService.APIClient;
import com.project.sahifah.APIService.APIInterfacesRest;
import com.project.sahifah.HikmahActivity;
import com.project.sahifah.HomeActivity;
import com.project.sahifah.oase.OaseActivity;
import com.project.sahifah.ProfileActivity;
import com.project.sahifah.R;
import com.project.sahifah.adapter.AdapterSurah;
import com.project.sahifah.model.ModelQuran;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurahContentActivity extends AppCompatActivity {

    TextView txtNamaSurah;
    String namasurah, suraId;
    ImageButton btn_back;
    ImageButton btn_home, btn_hikmah, btn_search, btn_oase, btn_profile;

    //ModelQuran dataModelSurah;
    List<ModelQuran> dataModelSurah =  new ArrayList<>();
    List<ModelQuran> listSurah =  new ArrayList<>();
    AdapterSurah itemList;
    RecyclerView rvSurah;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_content);

        btn_back = findViewById(R.id.btn_back);
        /*btn_home = findViewById(R.id.btn_home);
        btn_hikmah = findViewById(R.id.btn_hikmah);
        btn_search = findViewById(R.id.btn_search);
        btn_oase = findViewById(R.id.btn_oase);
        btn_profile = findViewById(R.id.btn_profile);*/
        txtNamaSurah = findViewById(R.id.txtNamaSurah);
        rvSurah = findViewById(R.id.rvSurah);

        namasurah = getIntent().getStringExtra("namasurah");
        suraId = getIntent().getStringExtra("suraId");
        txtNamaSurah.setText(namasurah);

        //getDataSurah();
        thread();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        /*btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahContentActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahContentActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahContentActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SurahContentActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });*/
    }

    private void thread() {
        findViewById(R.id.framelayout).setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                getDataSurah();
            }
        }).start(); }

    public void getDataSurah() {
        final APIInterfacesRest apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        final Call<List<ModelQuran>> dataSurah = apiInterface.getDataSurah();
        dataSurah.enqueue(new Callback<List<ModelQuran>>() {
            @Override
            public void onResponse(Call<List<ModelQuran>> call, Response<List<ModelQuran>> response) {

                dataModelSurah =  response.body();
                if (dataModelSurah != null){
                    listSurah.clear();
                    for (int a=0; a<dataModelSurah.size(); a++){
                        for (int i=36; i<115; i++){
                            if (i==Integer.parseInt(dataModelSurah.get(a).getSuraId()) && i==Integer.parseInt(suraId)){
                                listSurah.add(dataModelSurah.get(a)); } } }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            findViewById(R.id.framelayout).setVisibility(View.GONE);

                            itemList = new AdapterSurah(listSurah);
                            rvSurah.setLayoutManager(new LinearLayoutManager(SurahContentActivity.this));
                            rvSurah.setAdapter(itemList);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<ModelQuran>> call, Throwable t) {
                Log.e("Error", t.getMessage());
                //Toast.makeText(LoginActivity.this, "Terjadi gangguan koneksi (getUser)", Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }

    public void onBackPressed() {
        Intent a = new Intent(SurahContentActivity.this, SurahActivity.class);
        startActivity(a);
        finish();
    }
}