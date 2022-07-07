package com.example.sns.exAdapter.movieApi2.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class NetworkClient {

    private final static String BASE_URL = "https://openapi.naver.com/v1/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create( gson))
                    .build();
        }

        return retrofit;
    }

}
