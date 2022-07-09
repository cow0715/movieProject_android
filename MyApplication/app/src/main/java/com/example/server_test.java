package com.example;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Network.MovieAPI;
import com.example.Network.mv_NetworkConfig;
import com.example.movie.movieAdapter_test;
import com.example.movie.movieData.mv_ResponseDTO;
import com.example.movie.movieData.mv_card_data;
import com.example.sns.R;
import com.example.sns.data.ResponseDTO;
import com.example.sns.data.SnsData;
import com.example.sns.network.NetworkConfig;
import com.example.sns.network.SnsV1API;
import com.example.sns.util.sns.SnsAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class server_test extends Fragment {
    private RecyclerView recyclerView_home;
    movieAdapter_test snsAdapter;

    ArrayList<SnsData> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.server_test, container, false);
        recyclerView_home = view.findViewById(R.id.recycler_test);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView_home.setLayoutManager(gridLayoutManager);

        snsAdapter = new movieAdapter_test();
        recyclerView_home.setAdapter(snsAdapter);


        getNetflixList();

        return view;
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


//                    for(int i=0; i<list.size(); i++){
//                        mv_card_data mv_card_data = list.get(i);
//                        Log.d("apitest", mv_card_data.getContent());
//                        Log.d("apitest", list.toString());
//                        Log.d("apitest", mv_card_data.getTitle());
//                        Log.d("apitest", mv_card_data.getMovie_img());
//
//
//
//
//                    }

//                    mv_card_data movie1 = new mv_card_data(0,"범죄도시","https://www.kukinews.com/data/kuk/image/2022/05/18/kuk202205180005.680x.0.jpg", "영화");
//
//                    snsAdapter.addCardData(movie1);
//                    snsAdapter.notifyDataSetChanged();

                    resProcess(list);
                }
            }

            @Override
            public void onFailure(Call<mv_ResponseDTO<mv_card_data>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }

    public void resProcess(ArrayList<mv_card_data> list){

        snsAdapter.addCardDataList(list);

        snsAdapter.notifyDataSetChanged();
    }
}










