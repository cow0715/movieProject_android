package com.example.Network;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.movie.movieAdapter_test;
import com.example.movie.movieData.mv_ResponseDTO;
import com.example.movie.movieData.mv_card_data;
import com.example.sns.R;
import com.example.sns.data.SnsData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class mv_NetworkActivity extends AppCompatActivity {

    ArrayList<mv_card_data> list;
    Retrofit retrofit;
    MovieAPI movieAPI;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mv_activity_main);

        list = new ArrayList<>();

        retrofit = mv_NetworkConfig.getClient();
        movieAPI = retrofit.create(MovieAPI.class);

    }


}
