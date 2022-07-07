package com.example.sns.util.sns;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.R;
import com.example.sns.data.SnsData;


import java.util.ArrayList;

public class SnsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    ArrayList<SnsData> snsItems = new ArrayList<SnsData>();



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_post_item, parent, false);

        return new SnsItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SnsData snsData = snsItems.get(position);
        SnsItem postItem =(SnsItem) holder;

        postItem.setItemData(snsData);
    }

    @Override
    public int getItemCount() {
        return snsItems.size();
    }

    public void addSns(SnsData data){

        snsItems.add(data);
    }

    public SnsData getSns(int position){

        return snsItems.get(position);
    }

    public void addSnsList(ArrayList<SnsData>  snsList){

        snsItems.addAll(snsList);
    }






}
