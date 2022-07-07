package com.example.bottom_nav;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.movieAdapter_test;
import com.example.movie.movieData.mv_search_data;

import com.example.movie.onMovieItemClickListener;
import com.example.nextActivity;
import com.example.sns.R;
import com.example.mv_RootActivity;


public class mv_LikeFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView_search;

    private Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mv_fragment_like, container, false);

        recyclerView_search = view.findViewById(R.id.recycler_like);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView_search.setLayoutManager(gridLayoutManager);



        movieAdapter_test adapter = new movieAdapter_test();


        mv_search_data search_data = new mv_search_data(1,"종이의 집","https://i.ytimg.com/vi/53T3RIohIi0/maxresdefault.jpg","범죄","2019","드라마","넷플릭스");
        mv_search_data search_data2 = new mv_search_data(1,"탑건","https://upload.wikimedia.org/wikipedia/ko/2/20/%ED%83%91%EA%B1%B4_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg","액션","2022","영화","아마존");
        mv_search_data search_data3 = new mv_search_data(1,"마녀","http://t1.daumcdn.net/movie/72e53e2dc1550ae95fe82a73b80d82221a617a10","액션","2017","영화","왓챠");

        adapter.addSearchData(search_data);
        adapter.addSearchData(search_data2);
        adapter.addSearchData(search_data3);
        adapter.addSearchData(search_data);
        adapter.addSearchData(search_data2);
        adapter.addSearchData(search_data3);
        adapter.addSearchData(search_data);
        adapter.addSearchData(search_data2);
        adapter.addSearchData(search_data3);
        adapter.addSearchData(search_data);
        adapter.addSearchData(search_data2);
        adapter.addSearchData(search_data3);



        recyclerView_search.setAdapter(adapter);

        adapter.setOnItemClickListener(new onMovieItemClickListener() {
            @Override
            public void onItemClickListener(RecyclerView.ViewHolder holder, View view, int position) {
                mv_search_data searchData = adapter.getSearchData(position);

                Intent intent = new Intent(getContext(), nextActivity.class);
                startActivity(intent);
            }
        });


        return view;


    }
}
