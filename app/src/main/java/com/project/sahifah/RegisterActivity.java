package com.project.sahifah;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.project.sahifah.APIService.APIClient;
import com.project.sahifah.APIService.APIInterfacesRest;
import com.project.sahifah.model.ModelUsers;
import com.project.sahifah.utility.PreferenceUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    TextView txt_masuk;
    EditText txt_regisusername, txt_regispassword, txt_regisnama, txt_regisemail, txt_registelepon;
    String un, pw, nama, email, tlp, role;
    Button btn_daftar;

    ModelUsers dataUser;
    List<ModelUsers> dataModelUsers = new ArrayList<>();
    List<ModelUsers> dataModelUsers2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txt_masuk = findViewById(R.id.txt_masuk);
        txt_regisusername = findViewById(R.id.txt_regisusername);
        txt_regispassword = findViewById(R.id.txt_regispassword);
        txt_regisnama = findViewById(R.id.txt_regisnama);
        txt_regisemail = findViewById(R.id.txt_regisemail);
        txt_registelepon = findViewById(R.id.txt_registelepon);
        btn_daftar = findViewById(R.id.btn_daftar);

        getDataUsers();

        txt_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(a);
                finish();
            }
        });

        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daftar();
            }
        });

    }

    public void daftar(){
        un = txt_regisusername.getText().toString();
        pw = txt_regispassword.getText().toString();
        nama = txt_regisnama.getText().toString();
        email = txt_regisemail.getText().toString();
        tlp = txt_registelepon.getText().toString();
        role = String.valueOf(8);

        if ( !un.isEmpty() && !pw.isEmpty() && !nama.isEmpty() && !email.isEmpty() && !tlp.isEmpty() ){
            for (int i=0; i<dataModelUsers.size(); i++){
                if (un.equalsIgnoreCase(dataModelUsers.get(i).getUsername())){
                    Toast.makeText(this, "username telah dimiliki", Toast.LENGTH_SHORT).show();
                } else if(!un.equalsIgnoreCase(dataModelUsers.get(i).getUsername())){
                    findViewById(R.id.framelayout).setVisibility(View.VISIBLE);
                    thread();
                }
            }
        } else {
            Toast.makeText(this, "isi field yang kosong !", Toast.LENGTH_SHORT).show();
        }
    }

    private void thread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                sendDataUser();
            }
        }).start();
    }

    private void sendDataUser(){
        final APIInterfacesRest apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        final Call<ModelUsers> data = apiInterface.sendDataUser(
                un,
                pw,
                nama,
                email,
                role,
                tlp);

        /*try {
            data.execute();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    findViewById(R.id.framelayout).setVisibility(View.GONE);
                    Toast.makeText(RegisterActivity.this, " Berhasil Register ! ", Toast.LENGTH_LONG).show();
                    getDataUsers2();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        data.enqueue(new Callback<ModelUsers>() {
            @Override
            public void onResponse(Call<ModelUsers> call, Response<ModelUsers> response) {
                try {
                    if (response.body() != null) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                findViewById(R.id.framelayout).setVisibility(View.GONE);
                                Toast.makeText(RegisterActivity.this, " Berhasil Register ! ", Toast.LENGTH_LONG).show();
                                getDataUsers2();
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(final Call<ModelUsers> call, Throwable t) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        findViewById(R.id.framelayout).setVisibility(View.GONE);
                        Toast.makeText(RegisterActivity.this, "Terjadi gangguan koneksi", Toast.LENGTH_LONG).show();
                        call.cancel();
                    }
                });
            }
        });
    }

    public void getDataUsers() {
        final APIInterfacesRest apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        final Call<List<ModelUsers>> dataUsers = apiInterface.getUsers();

        dataUsers.enqueue(new Callback<List<ModelUsers>>() {
            @Override
            public void onResponse(Call<List<ModelUsers>> call, Response<List<ModelUsers>> response) {

                dataModelUsers = response.body();
            }

            @Override
            public void onFailure(Call<List<ModelUsers>> call, Throwable t) {
                Log.e("Error", t.getMessage());
                call.cancel();
            }
        });
    }

    public void getDataUsers2() {
        final APIInterfacesRest apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        final Call<List<ModelUsers>> dataUsers = apiInterface.getUsers();

        dataUsers.enqueue(new Callback<List<ModelUsers>>() {
            @Override
            public void onResponse(Call<List<ModelUsers>> call, Response<List<ModelUsers>> response) {

                dataModelUsers2 = response.body();

                for (int i=0; i<dataModelUsers2.size(); i++){
                    if (un.equalsIgnoreCase(dataModelUsers2.get(i).getUsername())){
                       dataUser = dataModelUsers2.get(i);
                    }
                }
                PreferenceUtils.saveUsername(dataUser.getUsername(),getApplicationContext());
                PreferenceUtils.savePassword(dataUser.getPassword(), getApplicationContext());
                PreferenceUtils.saveName(dataUser.getNama(), getApplicationContext());
                Intent a = new Intent(RegisterActivity.this, HomeActivity.class);
                a.putExtra("dataUser", (Parcelable) dataUser);
                startActivity(a);
                finish();
            }

            @Override
            public void onFailure(Call<List<ModelUsers>> call, Throwable t) {
                Log.e("Error", t.getMessage());
                call.cancel();
            }
        });
    }

    @Override
    public void onBackPressed() {
       Intent a = new Intent(RegisterActivity.this, LoginActivity.class);
       startActivity(a);
       finish();
    }
}