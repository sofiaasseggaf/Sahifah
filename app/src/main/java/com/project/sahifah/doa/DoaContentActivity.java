package com.project.sahifah.doa;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.sahifah.APIService.APIClient;
import com.project.sahifah.APIService.APIInterfacesRest;
import com.project.sahifah.adapter.adapterdoa.AdapterDoa;
import com.project.sahifah.adapter.adapterdoa.AdapterDoaLatin;
import com.project.sahifah.adapter.adapterdoa.AdapterDoaTerjemahan;
import com.project.sahifah.model.doa.Detail;
import com.project.sahifah.model.doa.ModelDoaHarian;
import com.project.sahifah.R;
import com.project.sahifah.utility.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoaContentActivity extends AppCompatActivity {

    ConstraintLayout expandableView;
    ImageButton btn_expand_more;
    RelativeLayout rl;

    TextView txtNamaDoa, txtPenjelasan;
    String namadoa, id_detail;
    ImageButton btn_back, btn_setting;
    ImageButton btn_home, btn_hikmah, btn_search, btn_oase, btn_profile;

    List<ModelDoaHarian> dataModelDoaHarian = new ArrayList<>();
    List<Detail> listDetail =  new ArrayList<>();
    AdapterDoa itemList; AdapterDoaTerjemahan itemListTerjemahan; AdapterDoaLatin itemListLatin;
    RecyclerView rvDoa;

    AlertDialog alertDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_content);

        //expandableView = findViewById(R.id.expandableView);
        //btn_expand_more = findViewById(R.id.btn_expand_more);
        rl = findViewById(R.id.rl);
        btn_back = findViewById(R.id.btn_back);

        txtNamaDoa = findViewById(R.id.txtNamaDoa);
        txtPenjelasan = findViewById(R.id.txt_penjelasan);
        btn_setting = findViewById(R.id.btn_setting);
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

        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDoa();
            }
        });

        /*btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaContentActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaContentActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        btn_oase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaContentActivity.this, OaseActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DoaContentActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });*/

    }

    public void thread(){
        findViewById(R.id.framelayout).setVisibility(View.VISIBLE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                getDataDoaHarian();
            }
        }).start();
    }


    public void getDataDoaHarian() {
        final APIInterfacesRest apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        final Call<List<ModelDoaHarian>> dataDoaHarian = apiInterface.getDataDoaHarian();

        dataDoaHarian.enqueue(new Callback<List<ModelDoaHarian>>() {
            @Override
            public void onResponse(Call<List<ModelDoaHarian>> call, Response<List<ModelDoaHarian>> response) {

                dataModelDoaHarian =  response.body();

                if(dataModelDoaHarian != null){
                    listDetail.clear();
                    for (int a=0; a<dataModelDoaHarian.size(); a++){
                        if (Integer.parseInt(dataModelDoaHarian.get(a).getIdHeader()) == Integer.parseInt(id_detail)){
                            for (int i=0; i<dataModelDoaHarian.get(a).getDetail().size(); i++){
                                listDetail.add(dataModelDoaHarian.get(a).getDetail().get(i));
                            }
                            txtPenjelasan.setText(dataModelDoaHarian.get(a).getPenjelasan());
                        }
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        findViewById(R.id.framelayout).setVisibility(View.GONE);
                        setDoa();
                    }
                });
            }

            @Override
            public void onFailure(Call<List<ModelDoaHarian>> call, Throwable t) {
                Log.e("Error", t.getMessage());
                //Toast.makeText(LoginActivity.this, "Terjadi gangguan koneksi (getUser)", Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }

    public void dialogDoa(){

        LayoutInflater inflater = getLayoutInflater();
        View viewDoa = inflater.inflate(R.layout.v_dialog_doa, null);

        Switch sw_latindanterjemah = viewDoa.findViewById(R.id.sw_latindanterjemah);
        Switch sw_latin = viewDoa.findViewById(R.id.sw_latin);
        Switch sw_terjemah = viewDoa.findViewById(R.id.sw_terjemah);

        sw_latindanterjemah.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sw_latin.setChecked(false);
                    sw_terjemah.setChecked(false);
                }
            }
        });

        sw_latin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sw_latindanterjemah.setChecked(false);
                    sw_terjemah.setChecked(false);
                }
            }
        });

        sw_terjemah.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sw_latindanterjemah.setChecked(false);
                    sw_latin.setChecked(false);
                }
            }
        });

        AlertDialog.Builder builderdoa = new AlertDialog.Builder(DoaContentActivity.this);
        builderdoa.setView(viewDoa)
                .setTitle("Atur Tampilan Doa")
                .setPositiveButton("save setting", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (sw_latindanterjemah.isChecked()){
                            alertDialog.cancel();
                            setDoa();
                        } else if (sw_latin.isChecked()){
                            alertDialog.cancel();
                            setDoaLatin();
                        } else if (sw_terjemah.isChecked()){
                            alertDialog.cancel();
                            setDoaTerjemah();
                        }
                    }
                })
                .setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog = builderdoa.create();
        alertDialog.show();

    }

    public void setDoa(){
        itemList = new AdapterDoa(listDetail);
        rvDoa.setLayoutManager(new LinearLayoutManager(DoaContentActivity.this));
        rvDoa.setAdapter(itemList);
    }

    public void setDoaLatin(){
        itemListLatin = new AdapterDoaLatin(listDetail);
        rvDoa.setLayoutManager(new LinearLayoutManager(DoaContentActivity.this));
        rvDoa.setAdapter(itemListLatin);
    }

    public void setDoaTerjemah(){
        itemListTerjemahan  = new AdapterDoaTerjemahan(listDetail);
        rvDoa.setLayoutManager(new LinearLayoutManager(DoaContentActivity.this));
        rvDoa.setAdapter(itemListTerjemahan);
    }

    public void onBackPressed() {
        Intent a = new Intent(DoaContentActivity.this, DoaActivity.class);
        startActivity(a);
        finish();
    }
}
