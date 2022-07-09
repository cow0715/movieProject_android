package com.example;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Network.MovieAPI;
import com.example.Network.mv_NetworkConfig;
import com.example.movie.movieAdapter_test;
import com.example.movie.movieData.mv_ResponseDTO;
import com.example.movie.movieData.mv_card_data;
import com.example.movie.movieData.mv_detail_data;
import com.example.movie.movieData.mv_search_data;
import com.example.sns.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class testtest extends AppCompatActivity {
    movieAdapter_test adapter = new movieAdapter_test();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testtest);


        getSearchList();
        //getMovieList();
    }

    void getMovieList(){
        Log.d("apitest", "getMovieList");

        Retrofit retrofit = mv_NetworkConfig.getClient();
        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        movieAPI.getMovieList().enqueue(new Callback<mv_ResponseDTO<mv_card_data>>() {
            @Override
            public void onResponse(Call<mv_ResponseDTO<mv_card_data>> call, Response<mv_ResponseDTO<mv_card_data>> response) {
                Log.d("apitest", response.toString());

                if(response.code() == 200){
                    mv_ResponseDTO mv_responseDTO = response.body();
                    ArrayList<mv_card_data> list = (ArrayList<mv_card_data>) mv_responseDTO.getResultData();

                    for(int i=0; i<list.size(); i++){
                        mv_card_data mv_card_data = list.get(i);

                        Log.d("apitest", list.toString());
                        Log.d("apitest", mv_card_data.getTitle());
                        Log.d("apitest", mv_card_data.getMovie_img());

                    }


                    resProcess(list);
                }
            }

            @Override
            public void onFailure(Call<mv_ResponseDTO<mv_card_data>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }

    void getSearchList(){
        Log.d("apitest", "getSearchList");

        Retrofit retrofit = mv_NetworkConfig.getClient();
        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        movieAPI.getSearchViewList().enqueue(new Callback<mv_ResponseDTO<mv_search_data>>() {
            @Override
            public void onResponse(Call<mv_ResponseDTO<mv_search_data>> call, Response<mv_ResponseDTO<mv_search_data>> response) {
                Log.d("apitest", response.toString());

                if(response.code() == 200){
                    mv_ResponseDTO mv_responseDTO = response.body();
                    ArrayList<mv_search_data> list = (ArrayList<mv_search_data>) mv_responseDTO.getResultData();

                    for(int i=0; i<list.size(); i++){
                        mv_search_data mv_search_data = list.get(i);

                        Log.d("apitest", list.toString());
                        Log.d("apitest", mv_search_data.getTitle());
                        Log.d("apitest", mv_search_data.getMovie_img());

                    }


                    resProcess3(list);
                }
            }

            @Override
            public void onFailure(Call<mv_ResponseDTO<mv_search_data>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }




    public void resProcess2(ArrayList<mv_detail_data> list){

        adapter.addDetailDataList(list);

        adapter.notifyDataSetChanged();
    }

    public void resProcess(ArrayList<mv_card_data> list){

        adapter.addCardDataList(list);

        adapter.notifyDataSetChanged();
    }

    public void resProcess3(ArrayList<mv_search_data> list){

        adapter.addSearchDataList(list);

        adapter.notifyDataSetChanged();
    }
}



