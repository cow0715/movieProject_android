package com.example.movie.movieItem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie.movieData.mv_detail_data;
import com.example.movie.movieData.mv_search_data;
import com.example.movie.onMovieItemClickListener;
import com.example.sns.R;


public class mv_search_item extends RecyclerView.ViewHolder {

    ImageView search_img;
    TextView search_title;
    TextView search_company;
    TextView search_content;
    TextView search_genre;
    TextView search_year;

    public mv_search_item(@NonNull View itemView, final onMovieItemClickListener listener) {
        super(itemView);

        search_img = itemView.findViewById(R.id.mv_search_img);
        search_title = itemView.findViewById(R.id.mv_search_title);
        search_company = itemView.findViewById(R.id.mv_search_company);
        search_content = itemView.findViewById(R.id.mv_search_content);
        search_genre = itemView.findViewById(R.id.mv_search_genre);
        search_year = itemView.findViewById(R.id.mv_search_released_year);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();

                if(listener != null){
                    listener.onItemClickListener(mv_search_item.this, view, position);
                }
            }
        });

    }

    public void setItemData(mv_search_data search_data){

        final String url = search_data.getMovie_img();
        Glide
                .with(search_img)
                .load(url)
                .into(search_img);


        search_title.setText(search_data.getTitle());
        search_company.setText(search_data.getCompany());
        search_content.setText(search_data.getContent());
        search_genre.setText(search_data.getGenre());
        search_year.setText(search_data.getRelease_year());

    }
}
