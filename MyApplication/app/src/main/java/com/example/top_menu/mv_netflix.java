package com.example.top_menu;

import android.content.Intent;
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
import com.example.javaCode;
import com.example.movie.movieData.mv_ResponseDTO;
import com.example.movie.movieData.mv_card_data;
import com.example.movie.movieAdapter_test;
import com.example.movie.onMovieItemClickListener;
import com.example.nextActivity;
import com.example.sns.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class mv_netflix extends Fragment {

    movieAdapter_test adapter = new movieAdapter_test();
    private View view;
    private RecyclerView recyclerView_netflix;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mv_fragment_netflix, container, false);

        recyclerView_netflix = view.findViewById(R.id.recycler_netflix);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView_netflix.setLayoutManager(gridLayoutManager);



        recyclerView_netflix.setAdapter(adapter);

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






