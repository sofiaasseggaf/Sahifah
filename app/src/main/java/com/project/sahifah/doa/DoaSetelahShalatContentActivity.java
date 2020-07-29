package com.project.sahifah.doa;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.sahifah.APIService.APIClient;
import com.project.sahifah.APIService.APIInterfacesRest;
import com.project.sahifah.HikmahActivity;
import com.project.sahifah.HomeActivity;
import com.project.sahifah.ProfileActivity;
import com.project.sahifah.R;
import com.project.sahifah.adapter.AdapterDoa;
import com.project.sahifah.model.doa.Detail;
import com.project.sahifah.model.doa.ModelDoaHarian;
import com.project.sahifah.oase.OaseActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoaSetelahShalatContentActivity extends AppCompatActivity {

    ConstraintLayout expandableView;
    ImageButton btn_expand_more;
    RelativeLayout rl;

    TextView txtNamaDoa, txtPenjelasan;
    String namadoa, id_detail;
    ImageButton btn_back;
    ImageButton btn_home, btn_hikmah, btn_search, btn_oase, btn_profile;

    List<ModelDoaHarian> dataModelDoaHarian = new ArrayList<>();
    List<Detail> listDetail =  new ArrayList<>();
    AdapterDoa itemList;
    RecyclerView rvDoa;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_content);

        //expandableView = findViewById(R.id.expandableView);
        //btn_expand_more = findViewById(R.id.btn_expand_more);
        rl = findViewById(R.id.rl);

        btn_back = findViewById(R.id.btn_back);
        /*btn_home = findViewById(R.id.btn_home);
        btn_hikmah = findViewById(R.id.btn_hikmah);
        btn_search = findViewById(R.id.btn_search);
        btn_oase = findViewById(R.id.btn_oase);
        btn_profile = findViewById(R.id.btn_profile);*/
        txtNamaDoa = findViewById(R.id.txtNamaDoa);
        txtPenjelasan = findViewById(R.id.txt_penjelasan);
        rvDoa = findViewById(R.id.rvDoa);

        namadoa = getIntent().getStringExtra("namadoa");
        id_detail = getIntent().getStringExtra("id_detail");
        if (id_detail == null){
            id_detail = "0";
        }
        txtNamaDoa.setText(namadoa);

        thread();

        /*btn_expand_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(rl, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    btn_expand_more.setBackgroundResource(R.drawable.icon_expand_more);
                } else {
                    TransitionManager.beginDelayedTransition(rl, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    btn_expand_more.setBackgroundResource(R.drawable.icon_expand_more);
                }
            }
        });*/

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        /*btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaSetelahShalatContentActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaSetelahShalatContentActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaSetelahShalatContentActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaSetelahShalatContentActivity.this, ProfileActivity.class);
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
                getDataDoaSetelahShalat();
            }
        }).start();
    }

    public void getDataDoaSetelahShalat() {
        final APIInterfacesRest apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        final Call<List<ModelDoaHarian>> dataDoaHarian = apiInterface.getDataDoaSetelahShalat();

        dataDoaHarian.enqueue(new Callback<List<ModelDoaHarian>>() {
            @Override
            public void onResponse(Call<List<ModelDoaHarian>> call, Response<List<ModelDoaHarian>> response) {

                dataModelDoaHarian =  response.body();

                if (dataModelDoaHarian != null){
                    listDetail.clear();
                    for (int a=0; a<dataModelDoaHarian.size(); a++){
                        if (Integer.parseInt(dataModelDoaHarian.get(a).getIdHeader()) == Integer.parseInt(id_detail)){
                            for (int i=0; i<dataModelDoaHarian.get(a).getDetail().size(); i++){
                                listDetail.add(dataModelDoaHarian.get(a).getDetail().get(i));
                            }
                            txtPenjelasan.setText(dataModelDoaHarian.get(a).getPenjelasan());
                        }
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            findViewById(R.id.framelayout).setVisibility(View.GONE);

                            itemList = new AdapterDoa(listDetail);
                            rvDoa.setLayoutManager(new LinearLayoutManager(DoaSetelahShalatContentActivity.this));
                            rvDoa.setAdapter(itemList);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<ModelDoaHarian>> call, Throwable t) {
                Log.e("Error", t.getMessage());
                //Toast.makeText(LoginActivity.this, "Terjadi gangguan koneksi (getUser)", Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }

    public void onBackPressed() {
        Intent a = new Intent(DoaSetelahShalatContentActivity.this, DoaActivity.class);
        startActivity(a);
        finish();
    }
}
