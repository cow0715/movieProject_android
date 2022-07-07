package com.example.sns.exAdapter.movieApi.Item;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sns.R;
import com.example.sns.exAdapter.movieApi.Data.MovieData;
import com.example.sns.exAdapter.movieApi.OnMovieItemClickListener;

public class MovieItem extends RecyclerView.ViewHolder {
    ImageView movie_img;


    TextView movie_title;
    TextView movie_subtitle;
    TextView movie_actor;
    TextView movie_director;
    TextView movie_rating;
    TextView movie_date;
    TextView movie_link;

    public MovieItem(@NonNull View itemView, final OnMovieItemClickListener listener) {
        super(itemView);
        movie_img = itemView.findViewById(R.id.movie_img);
        movie_title = itemView.findViewById(R.id.movie_title);
        movie_subtitle = itemView.findViewById(R.id.movie_subtitle);
        movie_actor = itemView.findViewById(R.id.movie_actor);
        movie_director = itemView.findViewById(R.id.movie_director);
        movie_rating = itemView.findViewById(R.id.movie_rating);
        movie_date = itemView.findViewById(R.id.movie_date);
        movie_link = itemView.findViewById(R.id.movie_link);

        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();

                if (listener != null){
                    listener.onItemClickListener(MovieItem.this, view, position);
                }
            }
        });
    }

    public void setItemData(MovieData data){

        final String url = data.image;
        Glide
                .with(movie_img)
                .load(url)
                .into(movie_img);


        movie_title.setText(data.getTitle());
        movie_subtitle.setText(data.getSubtitle());
        movie_actor.setText(data.getActor());
        movie_director.setText(data.getDirector());
        movie_rating.setText(data.getUserRating());
        movie_date.setText(data.getPubDate());
        movie_link.setText(data.getLink());
    }
}
