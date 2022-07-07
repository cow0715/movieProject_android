package com.example.sns.movieApi2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sns.R;
import com.example.sns.movieApi.Data.MovieData;
import com.example.sns.movieApi.Data.MovieRes;
import com.example.sns.movieApi.MovieAdapter;
import com.example.sns.movieApi.OnMovieItemClickListener;
import com.example.sns.movieApi2.network.MovieApi;
import com.example.sns.movieApi2.network.NetworkClient;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_card_activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        // recyclerView.setLayoutManager(layoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);


        movieAdapter = new MovieAdapter();
        recyclerView.setAdapter(movieAdapter);

        movieAdapter.setOnItemClickListener(new OnMovieItemClickListener() {
            @Override
            public void onItemClickListener(RecyclerView.ViewHolder holder, View view, int position) {
               MovieData movieData =  movieAdapter.getMovieData(position);

                Toast.makeText(getApplicationContext(), "선택 : " + movieData.getTitle(), Toast.LENGTH_LONG).show();
            }
        });

        movieReq();


    }

    private void movieReq(){
        Log.d("Movie", "movieRequest");
//    https://openapi.naver.com/v1/
//    search/movie.json?
//    query=love&display=10&start=1&genre=1

//     headers.put("X-Naver-Client-Id","zPLJzJBVNOKp20sdrIix");
//     headers.put("X-Naver-Client-Secret","LLIDSy_UnJ");

        MovieApi movieApi = NetworkClient.getClient().create(MovieApi.class);
        Call<String> call = movieApi.getMovieList(
                "zPLJzJBVNOKp20sdrIix",
                "LLIDSy_UnJ",
                "movie.json",
                "love",
                "10",
                "1",
                "1"
        );

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful() && response.body() != null)
                {
                    String result = response.body();
                    Log.e("m2", "성공 : " + result);
                }
                else
                {
                    Log.e("m2", "실패 : " + response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("m2", "에러 : " + t.getMessage());
            }
        });
    }

    public void resProcess(String response){
        Gson gson = new Gson();
        MovieRes movieRes = gson.fromJson(response, MovieRes.class);

        Log.d("movie", String.valueOf(movieRes.items.size()));

        for(int i = 0; i < movieRes.items.size(); i++){

            MovieData movieData = movieRes.items.get(i);

            movieAdapter.addMovieData(movieData);

        }

        movieAdapter.notifyDataSetChanged();
    }

}












