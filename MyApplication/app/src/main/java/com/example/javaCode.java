package com.example;

import android.util.Log;

import com.example.Network.MovieAPI;
import com.example.movie.movieAdapter_test;
import com.example.movie.movieData.mv_ResponseDTO;
import com.example.movie.movieData.mv_card_data;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import com.example.Network.mv_NetworkConfig;
import com.example.movie.movieData.mv_detail_data;

public class javaCode {

    movieAdapter_test adapter;


    public void getMovieList(){
        Log.d("apitest", "getDetailList");

        Retrofit retrofit = mv_NetworkConfig.getClient();
        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        movieAPI.getMovieList().enqueue(new Callback<mv_ResponseDTO<mv_detail_data>>() {
            @Override
            public void onResponse(Call<mv_ResponseDTO<mv_detail_data>> call, Response<mv_ResponseDTO<mv_detail_data>> response) {
                Log.d("apitest", response.toString());

                if(response.code() == 200){
                    mv_ResponseDTO mv_responseDTO = response.body();
                    ArrayList<mv_detail_data> list = (ArrayList<mv_detail_data>) mv_responseDTO.getResultData();
                    mv_detail_data mv_detail_data = list.get(0);

                    Log.d("apitest", list.toString());
                    Log.d("apitest", mv_detail_data.getTitle());
                    //Log.d("apitest", mv_detail_data.getContent());
                    Log.d("apitest", mv_detail_data.getMovie_img());

                    resProcess2(list);
                }
            }

            @Override
            public void onFailure(Call<mv_ResponseDTO<mv_detail_data>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }


    void getAmazonList(){
        Log.d("apitest", "getPostList");

        Retrofit retrofit = mv_NetworkConfig.getClient();
        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        movieAPI.getCompanyList("AMAZON PRIME VIDEO").enqueue(new Callback<mv_ResponseDTO<mv_card_data>>() {
            @Override
            public void onResponse(Call<mv_ResponseDTO<mv_card_data>> call, Response<mv_ResponseDTO<mv_card_data>> response) {
                Log.d("apitest", response.toString());

                if(response.code() == 200){
                    mv_ResponseDTO mv_responseDTO = response.body();
                    ArrayList<mv_card_data> list = (ArrayList<mv_card_data>) mv_responseDTO.getResultData();
                    mv_card_data mv_card_data = list.get(0);

                    Log.d("apitest", list.toString());
                    Log.d("apitest", mv_card_data.getTitle());
                    Log.d("apitest", mv_card_data.getContent());
                    Log.d("apitest", mv_card_data.getMovie_img());

                    resProcess(list);
                }
            }

            @Override
            public void onFailure(Call<mv_ResponseDTO<mv_card_data>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }


    void getAppleList(){
        Log.d("apitest", "getPostList");

        Retrofit retrofit = mv_NetworkConfig.getClient();
        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        movieAPI.getCompanyList("APPLE TV+").enqueue(new Callback<mv_ResponseDTO<mv_card_data>>() {
            @Override
            public void onResponse(Call<mv_ResponseDTO<mv_card_data>> call, Response<mv_ResponseDTO<mv_card_data>> response) {
                Log.d("apitest", response.toString());

                if(response.code() == 200){
                    mv_ResponseDTO mv_responseDTO = response.body();
                    ArrayList<mv_card_data> list = (ArrayList<mv_card_data>) mv_responseDTO.getResultData();
                    mv_card_data mv_card_data = list.get(0);

                    Log.d("apitest", list.toString());
                    Log.d("apitest", mv_card_data.getTitle());
                    Log.d("apitest", mv_card_data.getContent());
                    Log.d("apitest", mv_card_data.getMovie_img());

                    resProcess(list);
                }
            }

            @Override
            public void onFailure(Call<mv_ResponseDTO<mv_card_data>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }


    void getCoupangList(){
        Log.d("apitest", "getPostList");

        Retrofit retrofit = mv_NetworkConfig.getClient();
        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        movieAPI.getCompanyList("COUPANG PLAY").enqueue(new Callback<mv_ResponseDTO<mv_card_data>>() {
            @Override
            public void onResponse(Call<mv_ResponseDTO<mv_card_data>> call, Response<mv_ResponseDTO<mv_card_data>> response) {
                Log.d("apitest", response.toString());

                if(response.code() == 200){
                    mv_ResponseDTO mv_responseDTO = response.body();
                    ArrayList<mv_card_data> list = (ArrayList<mv_card_data>) mv_responseDTO.getResultData();
                    mv_card_data mv_card_data = list.get(0);

                    Log.d("apitest", list.toString());
                    Log.d("apitest", mv_card_data.getTitle());
                    Log.d("apitest", mv_card_data.getContent());
                    Log.d("apitest", mv_card_data.getMovie_img());

                    resProcess(list);
                }
            }

            @Override
            public void onFailure(Call<mv_ResponseDTO<mv_card_data>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }


    void getDisneyList(){
        Log.d("apitest", "getPostList");

        Retrofit retrofit = mv_NetworkConfig.getClient();
        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        movieAPI.getCompanyList("DISNEY PLUS").enqueue(new Callback<mv_ResponseDTO<mv_card_data>>() {
            @Override
            public void onResponse(Call<mv_ResponseDTO<mv_card_data>> call, Response<mv_ResponseDTO<mv_card_data>> response) {
                Log.d("apitest", response.toString());

                if(response.code() == 200){
                    mv_ResponseDTO mv_responseDTO = response.body();
                    ArrayList<mv_card_data> list = (ArrayList<mv_card_data>) mv_responseDTO.getResultData();
                    mv_card_data mv_card_data = list.get(0);

                    Log.d("apitest", list.toString());
                    Log.d("apitest", mv_card_data.getTitle());
                    Log.d("apitest", mv_card_data.getContent());
                    Log.d("apitest", mv_card_data.getMovie_img());

                    resProcess(list);
                }
            }

            @Override
            public void onFailure(Call<mv_ResponseDTO<mv_card_data>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }


    void getNetflixList(){
        Log.d("apitest", "getPostList");

        Retrofit retrofit = mv_NetworkConfig.getClient();
        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        movieAPI.getCompanyList("NETFLIX").enqueue(new Callback<mv_ResponseDTO<mv_card_data>>() {
            @Override
            public void onResponse(Call<mv_ResponseDTO<mv_card_data>> call, Response<mv_ResponseDTO<mv_card_data>> response) {
                Log.d("apitest", response.toString());

                if(response.code() == 200){
                    mv_ResponseDTO mv_responseDTO = response.body();
                    ArrayList<mv_card_data> list = (ArrayList<mv_card_data>) mv_responseDTO.getResultData();
                    mv_card_data mv_card_data = list.get(0);

                    Log.d("apitest", list.toString());
                    Log.d("apitest", mv_card_data.getTitle());
                    Log.d("apitest", mv_card_data.getContent());
                    Log.d("apitest", mv_card_data.getMovie_img());

                    resProcess(list);
                }
            }

            @Override
            public void onFailure(Call<mv_ResponseDTO<mv_card_data>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }


     void getTvingList(){
        Log.d("apitest", "getPostList");

        Retrofit retrofit = mv_NetworkConfig.getClient();
        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        movieAPI.getCompanyList("TVING").enqueue(new Callback<mv_ResponseDTO<mv_card_data>>() {
            @Override
            public void onResponse(Call<mv_ResponseDTO<mv_card_data>> call, Response<mv_ResponseDTO<mv_card_data>> response) {
                Log.d("apitest", response.toString());

                if(response.code() == 200){
                    mv_ResponseDTO mv_responseDTO = response.body();
                    ArrayList<mv_card_data> list = (ArrayList<mv_card_data>) mv_responseDTO.getResultData();
                    mv_card_data mv_card_data = list.get(0);

                    Log.d("apitest", list.toString());
                    Log.d("apitest", mv_card_data.getTitle());
                    Log.d("apitest", mv_card_data.getContent());
                    Log.d("apitest", mv_card_data.getMovie_img());

                    resProcess(list);
                }
            }

            @Override
            public void onFailure(Call<mv_ResponseDTO<mv_card_data>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }


    void getWatchaList(){
        Log.d("apitest", "getPostList");

        Retrofit retrofit = mv_NetworkConfig.getClient();
        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        movieAPI.getCompanyList("WATCHA").enqueue(new Callback<mv_ResponseDTO<mv_card_data>>() {
            @Override
            public void onResponse(Call<mv_ResponseDTO<mv_card_data>> call, Response<mv_ResponseDTO<mv_card_data>> response) {
                Log.d("apitest", response.toString());

                if(response.code() == 200){
                    mv_ResponseDTO mv_responseDTO = response.body();
                    ArrayList<mv_card_data> list = (ArrayList<mv_card_data>) mv_responseDTO.getResultData();
                    mv_card_data mv_card_data = list.get(0);

                    Log.d("apitest", list.toString());
                    Log.d("apitest", mv_card_data.getTitle());
                    Log.d("apitest", mv_card_data.getContent());
                    Log.d("apitest", mv_card_data.getMovie_img());

                    resProcess(list);
                }
            }

            @Override
            public void onFailure(Call<mv_ResponseDTO<mv_card_data>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }


    void getWavveList(){
        Log.d("apitest", "getPostList");

        Retrofit retrofit = mv_NetworkConfig.getClient();
        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        movieAPI.getCompanyList("WAVVE").enqueue(new Callback<mv_ResponseDTO<mv_card_data>>() {
            @Override
            public void onResponse(Call<mv_ResponseDTO<mv_card_data>> call, Response<mv_ResponseDTO<mv_card_data>> response) {
                Log.d("apitest", response.toString());

                if(response.code() == 200){
                    mv_ResponseDTO mv_responseDTO = response.body();
                    ArrayList<mv_card_data> list = (ArrayList<mv_card_data>) mv_responseDTO.getResultData();
                    mv_card_data mv_card_data = list.get(0);

                    Log.d("apitest", list.toString());
                    Log.d("apitest", mv_card_data.getTitle());
                    Log.d("apitest", mv_card_data.getContent());
                    Log.d("apitest", mv_card_data.getMovie_img());

                    resProcess(list);
                }
            }

            @Override
            public void onFailure(Call<mv_ResponseDTO<mv_card_data>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }


    public void getDetailList(){
        Log.d("apitest", "getDetailList");

        Retrofit retrofit = mv_NetworkConfig.getClient();
        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        movieAPI.getDetailList("").enqueue(new Callback<mv_ResponseDTO<mv_detail_data>>() {
            @Override
            public void onResponse(Call<mv_ResponseDTO<mv_detail_data>> call, Response<mv_ResponseDTO<mv_detail_data>> response) {
                Log.d("apitest", response.toString());

                if(response.code() == 200){
                    mv_ResponseDTO mv_responseDTO = response.body();
                    ArrayList<mv_detail_data> list = (ArrayList<mv_detail_data>) mv_responseDTO.getResultData();
                    mv_detail_data mv_detail_data = list.get(0);

                    Log.d("apitest", list.toString());
                    Log.d("apitest", mv_detail_data.getTitle());
                    //Log.d("apitest", mv_detail_data.getContent());
                    Log.d("apitest", mv_detail_data.getMovie_img());

                    resProcess2(list);
                }
            }

            @Override
            public void onFailure(Call<mv_ResponseDTO<mv_detail_data>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }




    public void resProcess(ArrayList<mv_card_data> list){

        adapter.addCardDataList(list);

        adapter.notifyDataSetChanged();
    }

    public void resProcess2(ArrayList<mv_detail_data> list){

        adapter.addDetailDataList(list);

        adapter.notifyDataSetChanged();
    }
}


