package com.example.sns.movieApi2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.R;
import com.example.sns.movieApi2.DB.DataBaseHelper;
import com.example.sns.movieApi2.Data.MovieData;
import com.example.sns.movieApi2.Data.MovieRes;

import com.example.sns.movieApi2.network.MovieApi2;
import com.example.sns.movieApi2.network.NetworkClient;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {


    MovieAdapter2 movieAdapter;
    DataBaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_card_activity_main);

//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        Button btnDB = findViewById(R.id.btnDB);
//
//
//        dbHelper = new DataBaseHelper(getApplicationContext());

        // LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        // recyclerView.setLayoutManager(layoutManager);
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
//        recyclerView.setLayoutManager(gridLayoutManager);
//
//
//        movieAdapter = new MovieAdapter2();
//        recyclerView.setAdapter(movieAdapter);
//
//        movieAdapter.setOnItemClickListener(new OnMovieItemClickListener2() {
//            @Override
//            public void onItemClickListener(RecyclerView.ViewHolder holder, View view, int position) {
//               MovieData movieData =  movieAdapter.getMovieData(position);
//
//              Toast.makeText(getApplicationContext(), "선택 : " + movieData.getTitle(), Toast.LENGTH_LONG).show();
////                insertRecord(String mtitle, String mlink, String mimage, String msubtitle, String mpubDate, String mdirector, String mactor, String muserRating)
//                dbHelper.insertRecord(
//                        movieData.getTitle(),
//                        movieData.getLink(),
//                        movieData.getImage(),
//                        movieData.getSubtitle(),
//                        movieData.getPubDate(),
//                        movieData.getDirector(),
//                        movieData.getActor(),
//                        movieData.getUserRating()
//                ); //db
//
//
//            }
//
//        });
//
//        btnDB.setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity2.this, DBActivity.class);
//            startActivity(intent);
//        });
//
//
//        movieReq();
    }

    private void movieReq(){
        Log.d("Movie", "movieRequest");
//    https://openapi.naver.com/v1/
//    search/movie.json?
//    query=love&display=10&start=1&genre=1

//     headers.put("X-Naver-Client-Id","zPLJzJBVNOKp20sdrIix");
//     headers.put("X-Naver-Client-Secret","LLIDSy_UnJ");

        MovieApi2 movieApi = NetworkClient.getClient().create(MovieApi2.class);
        Call<MovieRes> call = movieApi.getMovieList(
                "zPLJzJBVNOKp20sdrIix",
                "LLIDSy_UnJ",
                "movie.json",
                "love",
                "10",
                "1",
                "1"
        );

        call.enqueue(new Callback<MovieRes>() {
            @Override
            public void onResponse(Call<MovieRes> call, Response<MovieRes> response) {


                if (response.isSuccessful() && response.body() != null)
                {
                    MovieRes result = response.body();
                    Log.e("m2", "성공 : " + result);

                    resProcess(result);
                }
                else
                {
                    Log.e("m2", "실패 : " + response.body());
                }
            }

            @Override
            public void onFailure(Call<MovieRes> call, Throwable t) {
                Log.e("m2", "에러 : " + t.getMessage());
            }
        });
    }

    public void resProcess( MovieRes movieRes){

        Log.d("movie", String.valueOf(movieRes.items.size()));

        movieAdapter.addItems(movieRes.items);

        movieAdapter.notifyDataSetChanged();
    }

    public void movieQuery(){

        ArrayList<MovieData> result = dbHelper.movieQuery();

        movieAdapter.addItems(result);
        movieAdapter.notifyDataSetChanged();
    }

}












