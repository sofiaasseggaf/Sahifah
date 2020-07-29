package com.project.sahifah.APIService;

/**
 * Created by user on 1/10/2018.
 */


import com.project.sahifah.model.ModelOase;
import com.project.sahifah.model.ModelQuran;
import com.project.sahifah.model.ModelUsers;
import com.project.sahifah.model.doa.ModelDoaHarian;
import com.project.sahifah.model.jadwalsolat.ModelJadwalSolat;
import com.project.sahifah.model.kalender.ModelKalender;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface APIInterfacesRest {

    @GET("api/index.php/api/Alquran")
//    Call<ModelQuran> getDataSurah(@Query("id") String id);
    Call<List<ModelQuran>> getDataSurah();

    @GET("api/index.php/api/Artikel")
    Call<List<ModelOase>> getDataArtikel();

    @GET("api/index.php/api/Doa_harian")
    Call<List<ModelDoaHarian>> getDataDoaHarian();

    @GET("api/index.php/api/Doa_Sholat")
    Call<List<ModelDoaHarian>> getDataDoaSetelahShalat();

    /*@GET("api/index.php/api/Munajat")
    Call<List<ModelMunajat>> getDataMunajat();*/

    @GET("api/index.php/api/Jadwal_Sholat")
    Call<ModelJadwalSolat> getJadwalSolat();

    @GET("api/index.php/api/Hijriyah")
    Call<ModelKalender> getKalender();

    @GET("api/index.php/api/Users")
    Call<List<ModelUsers>>  getUsers();

    @FormUrlEncoded
    @POST("api/index.php/api/Users")
    Call<ModelUsers> sendDataUser(
            @Field("username") String username,
            @Field("password") String password,
            @Field("nama") String nama,
            @Field("email") String email,
            @Field("role") String role,
            @Field("nomor_handphone") String nomor_handphone
    );
}

