package com.example.movie.movieItem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie.movieData.mv_card_data;
import com.example.movie.movieData.mv_detail_data;
import com.example.movie.onMovieItemClickListener;
import com.example.sns.R;


public class mv_card_item extends RecyclerView.ViewHolder {

    ImageView cardImg;
    TextView cardTitle;
    TextView cardContent;

    public mv_card_item(@NonNull View itemView, final onMovieItemClickListener listener) {
        super(itemView);

        cardImg = itemView.findViewById(R.id.mv_card_img);
        cardTitle = itemView.findViewById(R.id.mv_card_title);
        cardContent = itemView.findViewById(R.id.mv_card_content);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();

                if(listener != null){
                    listener.onItemClickListener(mv_card_item.this, view, position);
                }
            }
        });


    }

    public void setItemData(mv_card_data cardData){

        final String url = cardData.getMovie_img();
        Glide
                .with(cardImg)
                .load(url)
                .into(cardImg);


        cardTitle.setText(cardData.getTitle());
        cardContent.setText(cardData.getContent());

    }
}
