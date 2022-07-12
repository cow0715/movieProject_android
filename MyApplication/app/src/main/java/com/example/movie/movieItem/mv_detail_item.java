package com.example.movie.movieItem;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie.movieData.mv_detail_data;
import com.example.movie.movieData.mv_search_data;
import com.example.movie.onMovieItemClickListener;
import com.example.nextActivity;
import com.example.sns.R;


public class mv_detail_item extends RecyclerView.ViewHolder {
    private WebView webView;

    ImageView detail_img;
    TextView running_time;
    TextView release_date;
    TextView country;
    TextView story;
    TextView rate;
    TextView detail_title;
    TextView detail_genre;
    TextView detail_movie_url;


    public mv_detail_item(@NonNull View itemView, final onMovieItemClickListener listener) {
        super(itemView);

        detail_img = itemView.findViewById(R.id.mv_detail_img);
        detail_title = itemView.findViewById(R.id.mv_detail_title);
        country = itemView.findViewById(R.id.mv_detail_country);
        story = itemView.findViewById(R.id.mv_detail_story);
        rate = itemView.findViewById(R.id.mv_detail_rate);
        detail_genre = itemView.findViewById(R.id.mv_detail_genre);
        running_time = itemView.findViewById(R.id.mv_detail_runningTime);
        release_date = itemView.findViewById(R.id.mv_detail_releaseDate);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();

                if(listener != null){
                    listener.onItemClickListener(mv_detail_item.this, view, position);
                }
            }
        });
    }

    public void setItemData(mv_detail_data detail_data){

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


        webView = (WebView) webView.findViewById(R.id.mv_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());
        //webView.setWebViewClient(new nextActivity.WebViewClientClass());

    }
}
