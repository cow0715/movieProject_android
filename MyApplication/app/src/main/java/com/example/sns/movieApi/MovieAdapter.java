package com.example.sns.movieApi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.R;
import com.example.sns.exAdapter.card2.data.InsData;
import com.example.sns.movieApi.Data.MovieData;
import com.example.sns.movieApi.Item.MovieItem;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnMovieItemClickListener{
    ArrayList<MovieData> movieItems = new ArrayList<MovieData>();


    OnMovieItemClickListener listener;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.ex_movie_item, parent, false);

        return new MovieItem(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MovieData movieData = movieItems.get(position);
        MovieItem movieItem =(MovieItem) holder;

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

    @Override
    public void onItemClickListener(RecyclerView.ViewHolder holder, View view, int position) {

        if (listener != null){
            listener.onItemClickListener(holder, view, position);
        }
    }



    public void setOnItemClickListener(OnMovieItemClickListener mainListener){

        listener = mainListener;
    }





}
