package com.project.sahifah.oase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.sahifah.APIService.APIClient;
import com.project.sahifah.APIService.APIInterfacesRest;
import com.project.sahifah.HikmahActivity;
import com.project.sahifah.HomeActivity;
import com.project.sahifah.ProfileActivity;
import com.project.sahifah.R;
import com.project.sahifah.adapter.AdapterOase;
import com.project.sahifah.adapter.AdapterOasee;
import com.project.sahifah.model.ModelOase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OaseActivity extends AppCompatActivity implements AdapterOase.OnNoteListener {

    ImageButton btn_back;
    ImageButton btn_home, btn_hikmah, btn_search, btn_oase, btn_profile;
    TextView btn_home2, btn_hikmah2, btn_search2, btn_oase2, btn_profile2;
    LinearLayout btn_home3, btn_hikmah3, btn_search3, btn_oase3, btn_profile3;

    private static final String TAG = "OaseActivity";

    //private NoteRepository mNoteRepository;

    RecyclerView rvOase;
    List<ModelOase> dataModelOase =  new ArrayList<>();
    //AdapterOase itemList;
    AdapterOasee itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oase);

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
        rvOase = findViewById(R.id.rvOase);

        thread();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

       // BTN OASE

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        // BTN OASE

        btn_profile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseActivity.this, HomeActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_hikmah3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseActivity.this, HikmahActivity.class);
                startActivity(a);
                finish();
            }
        });

        // BTN SEARCH

        // BTN OASE

        btn_profile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OaseActivity.this, ProfileActivity.class);
                startActivity(a);
                finish();
            }
        });
    }

    private void thread(){
        findViewById(R.id.framelayout).setVisibility(View.VISIBLE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                getDataArtikel();
            }
        }).start();
    }

    @Override
    public void onNoteClick(int position) {
        Intent a = new Intent(OaseActivity.this, OaseContentActivity.class);
        a.putExtra("selected_oase", (Parcelable) dataModelOase.get(position));
        startActivity(a);
    }

    private void initRV(){
        //itemList = new AdapterOase(dataModelOase, this);
        itemList = new AdapterOasee(dataModelOase);
        rvOase.setLayoutManager(new LinearLayoutManager(OaseActivity.this));
        rvOase.setAdapter(itemList);
    }

    public void getDataArtikel() {
        final APIInterfacesRest apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        final Call<List<ModelOase>> dataOase = apiInterface.getDataArtikel();

        dataOase.enqueue(new Callback<List<ModelOase>>() {
            @Override
            public void onResponse(Call<List<ModelOase>> call, Response<List<ModelOase>> response) {

                dataModelOase =  response.body();

                if (dataModelOase != null){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            findViewById(R.id.framelayout).setVisibility(View.GONE);
                            initRV();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<ModelOase>> call, Throwable t) {
                Log.e("Error", t.getMessage());
                //Toast.makeText(LoginActivity.this, "Terjadi gangguan koneksi (getUser)", Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }

    public void onBackPressed() {
        Intent a = new Intent(OaseActivity.this, HomeActivity.class);
        startActivity(a);
        finish();
    }
}
