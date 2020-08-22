package com.project.sahifah;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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

import com.project.sahifah.APIService.APIClient;
import com.project.sahifah.APIService.APIInterfacesRest;
import com.project.sahifah.model.ModelUsers;
import com.project.sahifah.utility.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    List<ModelUsers> dataModelUsers = new ArrayList<>();
    ModelUsers dataUser;

    EditText txt_username, txt_password;
    String un,pw;
    TextView txt_daftar;
    boolean isValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        txt_username = findViewById(R.id.txt_username);
        txt_password = findViewById(R.id.txt_password);
        txt_daftar = findViewById(R.id.txt_daftar);

        first();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread();
            }
        });

        txt_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(a);
                finish();
            }
        });
    }

    private void thread() {
        findViewById(R.id.framelayout).setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                login();
            }
        }).start();
    }

    private void first(){
        if (PreferenceUtils.getUsername(this) == null || PreferenceUtils.getUsername(this).equalsIgnoreCase("")){
            second();
        } else {
            Intent a = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(a);
            finish();
        }

        /*if (PreferenceUtils.getUsername(getApplicationContext()) != null || !PreferenceUtils.getUsername(this).equalsIgnoreCase("")){
            Intent a = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(a);
            finish();
        } else {
            second();
        }*/
    }

    private void second(){
        findViewById(R.id.framelayout).setVisibility(View.VISIBLE);
        getDataUsers();
    }

    public void login(){

        if (!txt_username.getText().toString().isEmpty() && !txt_password.getText().toString().isEmpty()) {
            isValid = false;
            for (int i = 0; i < dataModelUsers.size(); i++) {
                un = dataModelUsers.get(i).getUsername();
                pw = dataModelUsers.get(i).getPassword();

                if (un.equalsIgnoreCase(txt_username.getText().toString()) && pw.equalsIgnoreCase(txt_password.getText().toString())) {
                    dataUser = dataModelUsers.get(i);
                    isValid = true;
                    if (isValid == true) {
                        saveData();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                findViewById(R.id.framelayout).setVisibility(View.GONE);
                                Intent a = new Intent(LoginActivity.this, HomeActivity.class);
                                a.putExtra("dataUser", (Parcelable) dataUser);
                                startActivity(a);
                                Toast.makeText(LoginActivity.this, "Login Succes", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                    } else {
                        isValid = false;
                        if (isValid == false) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    findViewById(R.id.framelayout).setVisibility(View.GONE);
                                    Toast.makeText(LoginActivity.this, "akun belum terdaftar", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }
            }
        } else if (txt_username.getText().toString().isEmpty() && !txt_password.getText().toString().isEmpty()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    findViewById(R.id.framelayout).setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, "please fill any empty field", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (txt_password.getText().toString().isEmpty() && !txt_username.getText().toString().isEmpty()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    findViewById(R.id.framelayout).setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, "please fill any empty field", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (txt_password.getText().toString().isEmpty() && txt_username.getText().toString().isEmpty()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    findViewById(R.id.framelayout).setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, "please fill any empty field", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void saveData()
    {
        PreferenceUtils.saveUsername(dataUser.getUsername(),getApplicationContext());
        PreferenceUtils.savePassword(dataUser.getPassword(), getApplicationContext());
        PreferenceUtils.saveName(dataUser.getNama(), getApplicationContext());
        PreferenceUtils.saveAlarmSubuh("off", getApplicationContext());
        PreferenceUtils.saveAlarmZuhur("off", getApplicationContext());
        PreferenceUtils.saveAlarmAshar("off", getApplicationContext());
        PreferenceUtils.saveAlarmMagrib("off", getApplicationContext());
        PreferenceUtils.saveAlarmIsya("off", getApplicationContext());
        PreferenceUtils.saveAlarmCoba("off", getApplicationContext());
    }
    public void getDataUsers() {
        final APIInterfacesRest apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        final Call<List<ModelUsers>> dataUsers = apiInterface.getUsers();

        dataUsers.enqueue(new Callback<List<ModelUsers>>() {
            @Override
            public void onResponse(Call<List<ModelUsers>> call, Response<List<ModelUsers>> response) {

                dataModelUsers =  response.body();

                if (response.body()!=null){
                    findViewById(R.id.framelayout).setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<ModelUsers>> call, Throwable t) {
                Log.e("Error", t.getMessage());
                //Toast.makeText(LoginActivity.this, "Terjadi gangguan koneksi (getUser)", Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Anda Mau Menutup Aplikasi")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        LoginActivity.super.onBackPressed();
                        finish();
                        finishAffinity();
                    }
                })

                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog =builder.create();
        alertDialog.show();
    }
}