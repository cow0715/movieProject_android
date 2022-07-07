package com.example.movie;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public interface onMovieItemClickListener {
    public void onItemClickListener(RecyclerView.ViewHolder holder, View view, int position);
}
