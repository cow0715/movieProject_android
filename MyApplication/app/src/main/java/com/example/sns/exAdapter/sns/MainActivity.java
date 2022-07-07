package com.example.sns.exAdapter.sns;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sns.R;
import com.example.sns.exAdapter.sns.data.Sns;
import com.example.sns.exAdapter.sns.network.NetworkClient;
import com.example.sns.exAdapter.sns.network.SnsAPI;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    ArrayList<Sns> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sns);

        list = new ArrayList<>();

        findViewById(R.id.btnApi0).setOnClickListener(view -> {

            getList();
        });

        findViewById(R.id.btnApi1).setOnClickListener(view -> {

            getSns();
        });

        findViewById(R.id.btnApi2).setOnClickListener(view -> {
            addSns();
        });

        findViewById(R.id.btnApi3).setOnClickListener(view -> {
            updateSns();
        });

        findViewById(R.id.btnApi4).setOnClickListener(view -> {
            deleteSns();
        });
    }

    public void getList(){
        Retrofit retrofit = NetworkClient.getClient();
        SnsAPI snsAPI = retrofit.create(SnsAPI.class);

        snsAPI.getSnsList().enqueue(new Callback<ArrayList<Sns>>() {
            @Override
            public void onResponse(Call<ArrayList<Sns>> call, Response<ArrayList<Sns>> response) {

                if(response.code() == 200){
                    list = response.body();

                    //adapter <- list

                    Sns sns = list.get(0);

                    Log.d("sns", sns.getTitle());
                    Log.d("sns", list.toString());

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Sns>> call, Throwable t) {
                Log.d("sns", t.getMessage());
            }
        });
    }

    public void getSns(){
        Retrofit retrofit = NetworkClient.getClient();
        SnsAPI snsAPI = retrofit.create(SnsAPI.class);

        snsAPI.getSns(67).enqueue(new Callback<Sns>() {
            @Override
            public void onResponse(Call<Sns> call, Response<Sns> response) {
                Sns sns = response.body();
                Log.d("sns", sns.getTitle());
                Log.d("sns", sns.getContent());
            }

            @Override
            public void onFailure(Call<Sns> call, Throwable t) {
                Log.d("sns", t.getMessage());
            }
        });
    }

    public void addSns(){
        Retrofit retrofit = NetworkClient.getClient();
        SnsAPI snsAPI = retrofit.create(SnsAPI.class);

        Sns sns = new Sns();

        sns.setTitle("111안드로이드 restful api test");
        sns.setImg("img");
        sns.setContent("안녕하세요 ");

        snsAPI.addSns(sns).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String resultcode = response.body();
                Log.d("sns", resultcode);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("sns", t.getMessage());
            }
        });
    }

    public void updateSns(){
        Retrofit retrofit = NetworkClient.getClient();
        SnsAPI snsAPI = retrofit.create(SnsAPI.class);

        Sns sns = new Sns();

        sns.setTitle("수정 updateSns");
        sns.setImg("img234234");
        sns.setContent("updateSns123123123 ");
        //202

        snsAPI.updateSns(202, sns).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String resultcode = response.body();
                Log.d("sns", resultcode);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("sns", t.getMessage());
            }
        });
    }

    public void deleteSns(){
        Retrofit retrofit = NetworkClient.getClient();
        SnsAPI snsAPI = retrofit.create(SnsAPI.class);

        snsAPI.deleteSns(202).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String resultcode = response.body();
                Log.d("sns", resultcode);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("sns", t.getMessage());
            }
        });
    }

}

























