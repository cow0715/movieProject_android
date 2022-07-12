package com.example;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.Network.MovieAPI;
import com.example.Network.mv_NetworkConfig;
import com.example.movie.movieAdapter_test;
import com.example.movie.movieData.mv_ResponseDTO;
import com.example.movie.movieData.mv_detail_data;
import com.example.sns.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Url;

public class nextActivity extends AppCompatActivity {

    movieAdapter_test adapter = new movieAdapter_test();
    String url;

    ImageView detail_img;
    TextView running_time;
    TextView release_date;
    TextView country;
    TextView story;
    TextView rate;
    TextView detail_title;
    TextView detail_genre;

    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mv_detail_page);




        detail_img = findViewById(R.id.mv_detail_img);
        detail_title = findViewById(R.id.mv_detail_title);
        country = findViewById(R.id.mv_detail_country);
        story = findViewById(R.id.mv_detail_story);
        rate = findViewById(R.id.mv_detail_rate);
        detail_genre = findViewById(R.id.mv_detail_genre);
        running_time = findViewById(R.id.mv_detail_runningTime);
        release_date = findViewById(R.id.mv_detail_releaseDate);
        webView = findViewById(R.id.mv_webview);


        String movieTitle = getIntent().getStringExtra("title");
        getDetailList(movieTitle);


    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;

        }


        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public void getDetailList(String title){
        Log.d("apitest", "getDetailList");

        Retrofit retrofit = mv_NetworkConfig.getClient();
        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        movieAPI.getDetailList(title).enqueue(new Callback<mv_ResponseDTO<mv_detail_data>>() {
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

    public void resProcess2(ArrayList<mv_detail_data> list){




        mv_detail_data mv_detail_data = list.get(0);

        final String imgUrl = mv_detail_data.getMovie_img();
        Glide
                .with(detail_img)
                .load(imgUrl)
                .into(detail_img);


        detail_title.setText(mv_detail_data.getTitle());
        country.setText(mv_detail_data.getCountry());
        story.setText(mv_detail_data.getStory());
        rate.setText(mv_detail_data.getRate());
        detail_genre.setText(mv_detail_data.getGenre());
        running_time.setText(String.valueOf(mv_detail_data.getRunning_time()));
        release_date.setText(mv_detail_data.getRelease_date());
        url = mv_detail_data.getMovie_url();

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClientClass());



    }

    public void setItemData(mv_detail_data detail_data) {

        final String url = detail_data.getMovie_img();
        Glide
                .with(detail_img)
                .load(url)
                .into(detail_img);


        detail_title.setText(detail_data.getTitle());
        country.setText(detail_data.getCountry());
        story.setText(detail_data.getStory());
        rate.setText(detail_data.getRate());
        detail_genre.setText(detail_data.getGenre());
        running_time.setText(String.valueOf(detail_data.getRunning_time()));
        release_date.setText(detail_data.getRelease_date());
    }




}
