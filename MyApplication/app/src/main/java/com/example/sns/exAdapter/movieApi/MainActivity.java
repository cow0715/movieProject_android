package com.example.sns.exAdapter.movieApi;

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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sns.R;
import com.example.sns.exAdapter.movieApi.Data.MovieData;
import com.example.sns.exAdapter.movieApi.Data.MovieRes;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    static RequestQueue requestQueue;
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

        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        movieReq();


    }

    private void movieReq(){
        Log.d("Movie", "movieRequest");
        String url ="https://openapi.naver.com/v1/search/movie.json?query=love&display=10&start=1&genre=1";

        StringRequest request = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d("Movie", response);
                resProcess(response);


            }

        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Movie", error.getMessage());
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
               Map<String, String> headers = super.getHeaders();

               if(headers == null || headers.equals(Collections.emptyMap())){

                   headers = new HashMap<String, String>();
               }

               headers.put("X-Naver-Client-Id","zPLJzJBVNOKp20sdrIix");
               headers.put("X-Naver-Client-Secret","LLIDSy_UnJ");

               return  headers;
            }
        };

        request.setShouldCache(false);
        requestQueue.add(request);

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












