package com.example.top_menu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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
import com.example.movie.movieData.mv_detail_data;
import com.example.movie.onMovieItemClickListener;
import com.example.nextActivity;
import com.example.sns.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class mv_amazon extends Fragment {

    private View view;
    private RecyclerView recyclerView_amazon;
    movieAdapter_test adapter = new movieAdapter_test();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mv_fragment_amazon, container, false);

        recyclerView_amazon = view.findViewById(R.id.recycler_amazon);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView_amazon.setLayoutManager(gridLayoutManager);

//        mv_card_data cardData = new mv_card_data(0,"범죄도시","https://www.kukinews.com/data/kuk/image/2022/05/18/kuk202205180005.680x.0.jpg","영화");
//        mv_card_data cardData2 = new mv_card_data(0,"범죄도시","https://img6.yna.co.kr/etc/inner/KR/2018/01/12/AKR20180112117600005_01_i_P4.jpg","영화");
//
//
//        adapter.addCardData(cardData);
//        adapter.addCardData(cardData2);
//        adapter.addCardData(cardData);
//        adapter.addCardData(cardData2);
//        adapter.addCardData(cardData);
//        adapter.addCardData(cardData2);

        recyclerView_amazon.setAdapter(adapter);

        adapter.setOnItemClickListener(new onMovieItemClickListener() {
            @Override
            public void onItemClickListener(RecyclerView.ViewHolder holder, View view, int position) {
                mv_card_data card_data = adapter.getCardData(position);
                String mv_title = card_data.getTitle();

                Intent intent = new Intent(getContext(), nextActivity.class);
                intent.putExtra("title", mv_title);
                startActivity(intent);
            }
        });

        getAmazonList();
        return view;


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

    public void resProcess(ArrayList<mv_card_data> list){

        adapter.addCardDataList(list);

        adapter.notifyDataSetChanged();
    }



}