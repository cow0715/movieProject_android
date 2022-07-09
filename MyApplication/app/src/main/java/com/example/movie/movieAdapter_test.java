package com.example.movie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.movieData.mv_card_data;
import com.example.movie.movieData.mv_detail_data;
import com.example.movie.movieData.mv_search_data;
import com.example.movie.movieItem.mv_card_item;
import com.example.movie.movieItem.mv_detail_item;
import com.example.movie.movieItem.mv_search_item;
import com.example.sns.R;
import com.example.sns.exAdapter.card2.data.CfData;
import com.example.sns.exAdapter.card2.data.InsData;
import com.example.sns.exAdapter.card2.data.PersonData;
import com.example.sns.exAdapter.card2.item.InsItem;
import com.example.sns.exAdapter.card2.item.PersonItem;
import com.example.sns.exAdapter.movieApi.OnMovieItemClickListener;

import java.util.ArrayList;

public class movieAdapter_test extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements onMovieItemClickListener {


    onMovieItemClickListener listener;

    ArrayList<Object> items = new ArrayList<Object>();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == 0){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.mv_cardview, parent, false);
            return new mv_card_item(itemView,this);

        }else if(viewType == 1){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.mv_search_view, parent, false);
            return new mv_search_item(itemView, this);

        }else if(viewType == 2){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.mv_detail_page, parent, false);
            return new mv_detail_item(itemView, this);

        }else {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.mv_cardview, parent, false);
            return new mv_card_item(itemView, (onMovieItemClickListener) this);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Object obj = items.get(position);

        if (obj instanceof mv_card_data){
            mv_card_data cardData = (mv_card_data) obj;

            mv_card_item card_item = (mv_card_item) holder;

            card_item.setItemData(cardData);


        } else if(obj instanceof mv_search_data){
            mv_search_data search_data = (mv_search_data) obj;

            mv_search_item search_item = (mv_search_item) holder;

            search_item.setItemData(search_data);

        }else if(obj instanceof mv_detail_data) {
            mv_detail_data detail_data = (mv_detail_data) obj;

            mv_detail_item detail_item = (mv_detail_item) holder;

            detail_item.setItemData(detail_data);

        }else{
            mv_card_data cardData = (mv_card_data) obj;

            mv_card_item card_item = (mv_card_item) holder;

            card_item.setItemData(cardData);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object obj = items.get(position);

        if (obj instanceof mv_card_data){
            mv_card_data cardData = (mv_card_data) obj;
            return cardData.getType();

        } else if(obj instanceof mv_search_data) {
            mv_search_data search_data = (mv_search_data) obj;
            return search_data.getType();

        }else if(obj instanceof mv_detail_data) {
            mv_detail_data detail_data = (mv_detail_data) obj;
            return detail_data.getType();

        }else{
            return 0;
        }

    }

    public void addCardData(mv_card_data cardData){
        items.add(cardData);
    }

    public void addSearchData(mv_search_data search_data){
        items.add(search_data);
    }

    public void addDetailData(mv_detail_data detail_data){
        items.add(detail_data);
    }

    public mv_card_data getCardData(int position){
        return (mv_card_data) items.get(position);
    }

    public mv_search_data getSearchData(int position){
        return (mv_search_data) items.get(position);
    }

    public mv_detail_data getDetailData(int position){
        return (mv_detail_data) items.get(position);
    }

    public void addCardDataList(ArrayList<mv_card_data> card_data){
        items.addAll(card_data);
    }


    //리스너

    public void onItemClickListener(RecyclerView.ViewHolder holder, View view, int position ){

        if(listener != null){
            listener.onItemClickListener(holder, view, position);
        }

    }

    public void setOnItemClickListener(onMovieItemClickListener mainListener){

        listener = mainListener;
    }






}
