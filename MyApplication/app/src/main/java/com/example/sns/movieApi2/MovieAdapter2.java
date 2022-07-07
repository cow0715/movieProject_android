package com.example.sns.movieApi2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.R;
import com.example.sns.movieApi.Item.MovieItem;
import com.example.sns.movieApi2.Data.MovieData;
import com.example.sns.movieApi2.Item.MovieItem2;


import java.util.ArrayList;

public class MovieAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnMovieItemClickListener2 {
    ArrayList<MovieData> movieItems = new ArrayList<MovieData>();


    OnMovieItemClickListener2 listener;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.ex_movie_item, parent, false);

        return new MovieItem2(itemView,  this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MovieData movieData = movieItems.get(position);
        MovieItem2 movieItem =(MovieItem2) holder;

        movieItem.setItemData(movieData);
    }

    @Override
    public int getItemCount() {
        return movieItems.size();
    }

    public void addMovieData(MovieData data){

        movieItems.add(data);
    }

    public void addItems(ArrayList<MovieData> items){

        movieItems.addAll(items);
    }

    public MovieData getMovieData(int position){

        return movieItems.get(position);
    }


    public void removeItem(int position){

         movieItems.remove(position);
    }


    @Override
    public void onItemClickListener(RecyclerView.ViewHolder holder, View view, int position) {

        if (listener != null){
            listener.onItemClickListener(holder, view, position);
        }
    }



    public void setOnItemClickListener(OnMovieItemClickListener2 mainListener){

        listener = mainListener;
    }





}
