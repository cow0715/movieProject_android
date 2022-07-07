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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
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


//        mv_search_data search_data = new mv_search_data(1,"종이의 집","https://i.ytimg.com/vi/53T3RIohIi0/maxresdefault.jpg","범죄","2019","드라마","넷플릭스");
//        mv_search_data search_data2 = new mv_search_data(1,"탑건","https://upload.wikimedia.org/wikipedia/ko/2/20/%ED%83%91%EA%B1%B4_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg","액션","2022","영화","아마존");
//        mv_search_data search_data3 = new mv_search_data(1,"마녀","http://t1.daumcdn.net/movie/72e53e2dc1550ae95fe82a73b80d82221a617a10","액션","2017","영화","왓챠");
//
//        adapter.addSearchData(search_data);
//        adapter.addSearchData(search_data2);
//        adapter.addSearchData(search_data3);

//        mv_detail_data detail_data = new mv_detail_data(2,"종이의 집","https://i.ytimg.com/vi/53T3RIohIi0/maxresdefault.jpg", 120, "범죄","2020-01-01", "한국","수백만 년 전 인류를 실험하기 위해 지구로 온 셀레스티얼이 만든 우주 에너지를 조종할 수 있","19세 관람가");

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










