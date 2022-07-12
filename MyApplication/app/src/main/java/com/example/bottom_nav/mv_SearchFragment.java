package com.example.bottom_nav;

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
import com.example.movie.movieAdapter_test;
import com.example.movie.movieData.mv_ResponseDTO;
import com.example.movie.onMovieItemClickListener;
import com.example.nextActivity;
import com.example.sns.R;

import com.example.movie.movieData.mv_card_data;
import com.example.movie.movieData.mv_search_data;
import com.example.movie.movieData.mv_detail_data;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class mv_SearchFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView_search;
    movieAdapter_test adapter = new movieAdapter_test();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mv_fragment_search, container, false);

        recyclerView_search = view.findViewById(R.id.recycler_search);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView_search.setLayoutManager(gridLayoutManager);



        recyclerView_search.setAdapter(adapter);

        adapter.setOnItemClickListener(new onMovieItemClickListener() {
            @Override
            public void onItemClickListener(RecyclerView.ViewHolder holder, View view, int position) {
                mv_search_data searchData = adapter.getSearchData(position);
                String mv_title = searchData.getTitle();

                Intent intent = new Intent(getContext(), nextActivity.class);
                intent.putExtra("title", mv_title);
                startActivity(intent);
            }
        });

        getSearchList();
        return view;
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

    public void resProcess3(ArrayList<mv_search_data> list){

        adapter.addSearchDataList(list);

        adapter.notifyDataSetChanged();
    }
}
