package com.example.sns.network.test;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sns.R;
import com.example.sns.data.ResponseDTO;
import com.example.sns.data.Sns;
import com.example.sns.data.SnsData;
import com.example.sns.network.NetworkConfig;
import com.example.sns.network.SnsV1API;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NetworkActivity extends AppCompatActivity {

    ArrayList<Sns> list;
    Retrofit retrofit;
    SnsV1API snsV1API;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        retrofit = NetworkConfig.getClient();
        snsV1API = retrofit.create(SnsV1API.class);

        getSnsList();
         //addSns();
        // deleteSns();
//

    }



    void getSnsList(){
        Log.d("apiTest ","getPostList");

        snsV1API = retrofit.create(SnsV1API.class);
        snsV1API.getSnsList().enqueue(new Callback<ResponseDTO<SnsData>>() {
            @Override
            public void onResponse(Call<ResponseDTO<SnsData>> call, Response<ResponseDTO<SnsData>> response) {

                Log.d("apitest", response.toString());

                if (response.code() == 200){
                    ResponseDTO responseDTO = response.body();
                    ArrayList<SnsData> list =(ArrayList<SnsData>) responseDTO.getResultData();
                    SnsData sns = list.get(0);

                    Log.d("apitest", list.toString());
                    Log.d("apitest", sns.getTitle());
                    Log.d("apitest", sns.getContent());
                }
            }

            @Override
            public void onFailure(Call<ResponseDTO<SnsData>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });

    }

    void addSns(){
        Log.d("apiTest ","addSns");
        SnsData sns = new SnsData();
        sns.setTitle("타이틀");
        sns.setImg("http://placehold.it/150X150");
        sns.setContent("안드로이드 업로더 내용");


        snsV1API.addSns(sns).enqueue(new Callback<ResponseDTO<SnsData>>() {
            @Override
            public void onResponse(Call<ResponseDTO<SnsData>> call, Response<ResponseDTO<SnsData>> response) {
                if (response.code() == 200){
                    Log.d("apitest", response.toString());

                }
            }

            @Override
            public void onFailure(Call<ResponseDTO<SnsData>> call, Throwable t) {

            }
        });
    }
//
    void getSns(){
//
        snsV1API.getSns(232).enqueue(new Callback<ResponseDTO<SnsData>>() {
            @Override
            public void onResponse(Call<ResponseDTO<SnsData>> call, Response<ResponseDTO<SnsData>> response) {
                ResponseDTO responseDTO = response.body();
                ArrayList<SnsData> list =(ArrayList<SnsData>) responseDTO.getResultData();
                SnsData sns = list.get(0);

                Log.d("apitest", list.toString());
                Log.d("apitest", sns.getTitle());
                Log.d("apitest", sns.getContent());
            }

            @Override
            public void onFailure(Call<ResponseDTO<SnsData>> call, Throwable t) {

            }
        });
    }

    void patchSns(){
        SnsData sns = new SnsData();
        sns.setTitle("타이틀 수정 ");
        sns.setImg("http://placehold.it/150X150");
        sns.setContent("업데이트 요청 내용");

        snsV1API.updateSns(232, sns).enqueue(new Callback<ResponseDTO<SnsData>>() {

            @Override
            public void onResponse(Call<ResponseDTO<SnsData>> call, Response<ResponseDTO<SnsData>> response) {

                if(response.code() == 200){

                    Log.d("apiTest",response.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseDTO<SnsData>> call, Throwable t) {

            }
        });
    }

    void deleteSns(){
        snsV1API.deleteSns(232).enqueue(new Callback<ResponseDTO<SnsData>>() {


            @Override
            public void onResponse(Call<ResponseDTO<SnsData>> call, Response<ResponseDTO<SnsData>> response) {

                if(response.code() == 200){

                    Log.d("apiTest",response.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseDTO<SnsData>> call, Throwable t) {

            }
        });
    }

}