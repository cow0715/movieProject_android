package com.example.sns.exAdapter.card2.item;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.R;
import com.example.sns.exAdapter.card2.data.PersonData;

public class PersonItem extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewPhone;

        public PersonItem(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.mv_search_title);
            textViewPhone = itemView.findViewById(R.id.textViewPhone);

        }

        public void setItem(PersonData data){
            textViewName.setText(data.getName());
            textViewPhone.setText(data.getPhone());
        }


    }

