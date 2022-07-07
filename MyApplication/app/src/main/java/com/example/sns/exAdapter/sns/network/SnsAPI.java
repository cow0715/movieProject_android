package com.example.sns.exAdapter.sns.network;

import com.example.sns.exAdapter.sns.data.Sns;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SnsAPI {

    @GET("sns")
        // 전체목록
    Call<ArrayList<Sns>> getSnsList();

    @GET("sns/{sid}")
        // 상세
    Call<Sns> getSns(@Path("sid") int sid);

    @POST("sns")
        // 등록
    Call<String> addSns(@Body Sns sns);

    @PATCH("sns/{sid}")
    Call<String> updateSns(@Path("sid") int sid, @Body Sns sns);

    @DELETE("sns/{sid}")
    Call<String> deleteSns(@Path("sid") int sid);


}
