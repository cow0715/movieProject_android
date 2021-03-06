package com.example.bottom_nav;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ViewPagerAdapter;
import com.example.movie.movieAdapter_test;
import com.example.movie.movieData.mv_search_data;
import com.example.movie.movieData.mv_detail_data;
import com.example.movie.onMovieItemClickListener;
import com.example.nextActivity;
import com.example.sns.R;
import com.example.sns.data.ResponseDTO;
import com.example.sns.data.SnsData;
import com.example.sns.network.NetworkConfig;
import com.example.sns.network.SnsV1API;
import com.example.sns.util.sns.SnsAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.top_menu.mv_amazon;
import com.example.top_menu.mv_apple;
import com.example.top_menu.mv_coupang;
import com.example.top_menu.mv_disney;
import com.example.top_menu.mv_netflix;
import com.example.top_menu.mv_tving;
import com.example.top_menu.mv_watcha;
import com.example.top_menu.mv_wavve;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class mv_HomeFragment extends Fragment {



    private View view;
    private RecyclerView recyclerView_home;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mv_null, container, false);



//        recyclerView_home = view.findViewById(R.id.mv_recycler_home);
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
//        recyclerView_home.setLayoutManager(gridLayoutManager);



        movieAdapter_test adapter = new movieAdapter_test();


//        mv_search_data search_data = new mv_search_data(1,"????????? ???","https://i.ytimg.com/vi/53T3RIohIi0/maxresdefault.jpg","??????","2019","?????????","????????????");
//        mv_search_data search_data2 = new mv_search_data(1,"??????","https://upload.wikimedia.org/wikipedia/ko/2/20/%ED%83%91%EA%B1%B4_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg","??????","2022","??????","?????????");
//        mv_search_data search_data3 = new mv_search_data(1,"??????","http://t1.daumcdn.net/movie/72e53e2dc1550ae95fe82a73b80d82221a617a10","??????","2017","??????","??????");
//
//        adapter.addSearchData(search_data);
//        adapter.addSearchData(search_data2);
//        adapter.addSearchData(search_data3);

//        mv_detail_data detail_data = new mv_detail_data(2,"????????? ???","https://i.ytimg.com/vi/53T3RIohIi0/maxresdefault.jpg", 120, "??????","2020-01-01", "??????","????????? ??? ??? ????????? ???????????? ?????? ????????? ??? ?????????????????? ?????? ?????? ???????????? ????????? ??? ???","19??? ?????????");

//        adapter.addDetailData(detail_data);
//        adapter.addDetailData(detail_data);
//        adapter.addDetailData(detail_data);
//        recyclerView_home.setAdapter(adapter);
//
//        adapter.setOnItemClickListener(new onMovieItemClickListener() {
//            @Override
//            public void onItemClickListener(RecyclerView.ViewHolder holder, View view, int position) {
//                mv_detail_data detailData = adapter.getDetailData(position);
//
//                Intent intent = new Intent(getContext(), nextActivity.class);
//                startActivity(intent);
//            }
//        });



        return view;
    }
}










