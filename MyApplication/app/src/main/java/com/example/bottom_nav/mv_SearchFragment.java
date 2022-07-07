package com.example.bottom_nav;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.movie.movieAdapter_test;
import com.example.movie.onMovieItemClickListener;
import com.example.nextActivity;
import com.example.sns.R;

import com.example.movie.movieData.mv_card_data;
import com.example.movie.movieData.mv_search_data;
import com.example.movie.movieData.mv_detail_data;


public class mv_SearchFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView_search;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mv_fragment_search, container, false);

        recyclerView_search = view.findViewById(R.id.recycler_search);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView_search.setLayoutManager(gridLayoutManager);

//        movie movie1 = new movie("https://www.kukinews.com/data/kuk/image/2022/05/18/kuk202205180005.680x.0.jpg","범죄도시", "영화");
//        movie movie2 = new movie("https://i.ytimg.com/vi/53T3RIohIi0/maxresdefault.jpg","종이의 집", "드라마");
//        movie movie3 = new movie("https://img6.yna.co.kr/etc/inner/KR/2018/01/12/AKR20180112117600005_01_i_P4.jpg","무한도전", "예능");
//        movie movie4 = new movie("https://upload.wikimedia.org/wikipedia/ko/2/20/%ED%83%91%EA%B1%B4_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg","탑건", "영화");
//        movie movie5 = new movie("https://w.namu.la/s/14dac81ade297be4e913f88d6761744e0b4d4648af98e4a5c39fb456e4407a8411d8551acd45a2034bed4c35d93a674bb7ccca4f3d41a2aebcdb2a3eaa7a61a6ae7d992bb131a9d765f0ed3a05accf72","원펀맨", "애니");
//        movie movie6 = new movie("https://i.ytimg.com/vi/WTJFKRxCWIk/maxresdefault.jpg","누들로드", "다큐멘터리");
//        movie movie7 = new movie("http://t1.daumcdn.net/movie/72e53e2dc1550ae95fe82a73b80d82221a617a10","마녀", "영화");
//        movie movie8 = new movie("https://upload.wikimedia.org/wikipedia/ko/5/5a/%EC%A7%80%EA%B8%88%2C_%EB%A7%8C%EB%82%98%EB%9F%AC_%EA%B0%91%EB%8B%88%EB%8B%A4_%28%EC%98%81%ED%99%94%29_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg","지금 만나러 갑니다", "영화");
//        movie movie9 = new movie("https://image.yes24.com/momo/TopCate09/MidCate07/862194.jpg","아마겟돈", "영화");





        movieAdapter_test adapter = new movieAdapter_test();

        //mv_card_data cardData = new mv_card_data("범죄도시","https://www.kukinews.com/data/kuk/image/2022/05/18/kuk202205180005.680x.0.jpg","영화");
        //mv_detail_data detail_data = new mv_detail_data("누들로드","https://i.ytimg.com/vi/WTJFKRxCWIk/maxresdefault.jpg",150,"다큐","2019-01-01","한국","kbs 다큐멘터리","전체관람가");

        mv_search_data search_data = new mv_search_data(1,"종이의 집","https://i.ytimg.com/vi/53T3RIohIi0/maxresdefault.jpg","범죄","2019","드라마","넷플릭스");
        mv_search_data search_data2 = new mv_search_data(1,"탑건","https://upload.wikimedia.org/wikipedia/ko/2/20/%ED%83%91%EA%B1%B4_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg","액션","2022","영화","아마존");
        //adapter.addCardData(cardData);
        adapter.addSearchData(search_data);
        adapter.addSearchData(search_data2);
        adapter.addSearchData(search_data);
        adapter.addSearchData(search_data2);
        adapter.addSearchData(search_data);
        adapter.addSearchData(search_data2);
        adapter.addSearchData(search_data);
        adapter.addSearchData(search_data2);
        adapter.addSearchData(search_data);
        adapter.addSearchData(search_data2);
        adapter.addSearchData(search_data);
        adapter.addSearchData(search_data2);
        adapter.addSearchData(search_data);
        adapter.addSearchData(search_data2);
        adapter.addSearchData(search_data);
        adapter.addSearchData(search_data2);
        adapter.addSearchData(search_data);
        adapter.addSearchData(search_data2);
        //adapter.addDetailData(detail_data);


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
