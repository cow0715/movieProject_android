package com.example.sns.exAdapter.card2.item;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.R;
import com.example.sns.exAdapter.card2.data.CfData;
import com.example.sns.exAdapter.card2.data.InsData;

public class InsItem extends RecyclerView.ViewHolder {
    TextView tv_name;
    TextView tv_like;
    TextView tv_tag;



    public InsItem(@NonNull View itemView) {
        super(itemView);

        tv_name = itemView.findViewById(R.id.name);
        tv_like = itemView.findViewById(R.id.like);
        tv_tag = itemView.findViewById(R.id.tag);


    }

    public void setItem(InsData data){
        tv_name.setText(data.getName());
        tv_like.setText(data.getLike());
        tv_tag.setText(data.getTag());

    }
}


