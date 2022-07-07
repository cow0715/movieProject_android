package com.example.sns.util.sns;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sns.R;
import com.example.sns.data.SnsData;
import com.example.sns.util.SquareImageView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SnsItem extends RecyclerView.ViewHolder {

    CircleImageView post_user_img;
    TextView post_user_name;
    ImageView post_menu;

    SquareImageView post_img;

    ImageView post_img_heart_red;
    ImageView post_img_heart;
    ImageView post_comments;
    ImageView post_send;
    ImageView post_text_save;

    TextView post_text_like;
    TextView post_text_caption;
    TextView post_text_tag;
    TextView post_text_commments;
    TextView post_text_time;



    public SnsItem(@NonNull View itemView) {
        super(itemView);
        post_user_img = itemView.findViewById(R.id.post_user_img);
        post_user_name = itemView.findViewById(R.id.post_user_name);
        post_menu = itemView.findViewById(R.id.post_menu);
        post_img = itemView.findViewById(R.id.post_img);
        post_img_heart_red = itemView.findViewById(R.id.post_img_heart_red);
        post_img_heart = itemView.findViewById(R.id.post_img_heart);
        post_comments = itemView.findViewById(R.id.post_comments);
        post_send = itemView.findViewById(R.id.post_send);
        post_text_save = itemView.findViewById(R.id.post_text_save);
        post_text_like = itemView.findViewById(R.id.post_text_like);
        post_text_caption = itemView.findViewById(R.id.post_text_caption);
        post_text_tag = itemView.findViewById(R.id.post_text_tag);
        post_text_commments = itemView.findViewById(R.id.post_text_commments);
        post_text_time = itemView.findViewById(R.id.post_text_time);



    }

    public void setItemData(SnsData data){

       String imgCode = data.getImg();
       String url = "http://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg";
        if (imgCode != null){

            List<String> files =  data.getFiles();
            if (files != null){
                url = files.get(0);
                url = "http://172.30.1.11:8080" + url;
            }
        }

        Glide
                .with(post_img)
                .load(url)
                .into(post_img);

        Glide
                .with(post_user_img)
                .load(url)
                .into(post_user_img);

        post_user_name.setText(data.getTitle());
        post_text_caption.setText(data.getContent());

    }
}
