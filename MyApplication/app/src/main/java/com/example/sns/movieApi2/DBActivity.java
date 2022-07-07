package com.example.sns.movieApi2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.R;
import com.example.sns.movieApi2.DB.DataBaseHelper;
import com.example.sns.movieApi2.Data.MovieData;
import com.example.sns.movieApi2.Data.MovieRes;
import com.example.sns.movieApi2.MovieAdapter2;
import com.example.sns.movieApi2.OnMovieItemClickListener2;
import com.example.sns.movieApi2.network.MovieApi2;
import com.example.sns.movieApi2.network.NetworkClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DBActivity extends AppCompatActivity {


    MovieAdapter2 movieAdapter;
    DataBaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_card_activity_db);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewDB);

        dbHelper = new DataBaseHelper(getApplicationContext());

        // LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        // recyclerView.setLayoutManager(layoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);


        movieAdapter = new MovieAdapter2();
        recyclerView.setAdapter(movieAdapter);


        movieAdapter.setOnItemClickListener(new OnMovieItemClickListener2() {
            @Override
            public void onItemClickListener(RecyclerView.ViewHolder holder, View view, int position) {
               MovieData movieData =  movieAdapter.getMovieData(position);

              Toast.makeText(getApplicationContext(), "선택 : " + movieData.getTitle(), Toast.LENGTH_LONG).show();
//                insertRecord(String mtitle, String mlink, String mimage, String msubtitle, String mpubDate, String mdirector, String mactor, String muserRating)


                dbHelper.deleteRecord(movieData.title);  //삭제
                movieAdapter.removeItem(position);
                movieAdapter.notifyDataSetChanged();
            }

        });


        movieQuery(); // 조회

    }



    public void movieQuery(){

        ArrayList<MovieData> result = dbHelper.movieQuery();

        movieAdapter.addItems(result);
        movieAdapter.notifyDataSetChanged();
    }

}












