package com.example.sns.exAdapter.card2.item;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.R;
import com.example.sns.exAdapter.card2.data.CfData;

public class CfItem extends RecyclerView.ViewHolder {
    TextView tv_cfName;
    TextView tv_brand_name;
    TextView tv_brand_color;
    TextView tv_brand_price;

    public CfItem(@NonNull View itemView) {
        super(itemView);

        tv_cfName = itemView.findViewById(R.id.cf_name);
        tv_brand_name = itemView.findViewById(R.id.brand_name);
        tv_brand_color = itemView.findViewById(R.id.brand_color);
        tv_brand_price = itemView.findViewById(R.id.brand_price);

    }

    public void setItem(CfData data){
        tv_cfName.setText(data.getName());
        tv_brand_name.setText(data.getBrand_name());
        tv_brand_color.setText(data.getBrand_color());
        tv_brand_price.setText(data.getBrand_price());
    }
}


