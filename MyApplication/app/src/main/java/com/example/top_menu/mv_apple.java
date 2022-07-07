package com.example.top_menu;

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

import com.example.movie.movieData.mv_card_data;
import com.example.movie.movieAdapter_test;
import com.example.movie.onMovieItemClickListener;
import com.example.nextActivity;
import com.example.sns.R;


public class mv_apple extends Fragment {

    private View view;
    private RecyclerView recyclerView_apple;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mv_fragment_apple, container, false);

        recyclerView_apple = view.findViewById(R.id.recycler_apple);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView_apple.setLayoutManager(gridLayoutManager);

        mv_card_data movie1 = new mv_card_data(0,"범죄도시","https://www.kukinews.com/data/kuk/image/2022/05/18/kuk202205180005.680x.0.jpg", "영화");
        mv_card_data movie2 = new mv_card_data(0,"종이의 집","https://i.ytimg.com/vi/53T3RIohIi0/maxresdefault.jpg", "드라마");
        mv_card_data movie3 = new mv_card_data(0,"무한도전","https://img6.yna.co.kr/etc/inner/KR/2018/01/12/AKR20180112117600005_01_i_P4.jpg", "예능");
        mv_card_data movie4 = new mv_card_data(0,"탑건","https://upload.wikimedia.org/wikipedia/ko/2/20/%ED%83%91%EA%B1%B4_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg", "영화");
        mv_card_data movie5 = new mv_card_data(0,"원펀맨","https://w.namu.la/s/14dac81ade297be4e913f88d6761744e0b4d4648af98e4a5c39fb456e4407a8411d8551acd45a2034bed4c35d93a674bb7ccca4f3d41a2aebcdb2a3eaa7a61a6ae7d992bb131a9d765f0ed3a05accf72", "애니");
        mv_card_data movie6 = new mv_card_data(0,"누들로드","https://i.ytimg.com/vi/WTJFKRxCWIk/maxresdefault.jpg", "다큐멘터리");
        mv_card_data movie7 = new mv_card_data(0,"마녀","http://t1.daumcdn.net/movie/72e53e2dc1550ae95fe82a73b80d82221a617a10", "영화");
        mv_card_data movie8 = new mv_card_data(0,"지금 만나러 갑니다","https://upload.wikimedia.org/wikipedia/ko/5/5a/%EC%A7%80%EA%B8%88%2C_%EB%A7%8C%EB%82%98%EB%9F%AC_%EA%B0%91%EB%8B%88%EB%8B%A4_%28%EC%98%81%ED%99%94%29_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg", "영화");
        mv_card_data movie9 = new mv_card_data(0,"아마겟돈","https://image.yes24.com/momo/TopCate09/MidCate07/862194.jpg", "영화");

        movieAdapter_test adapter = new movieAdapter_test();
        adapter.addCardData(movie1);
        adapter.addCardData(movie2);
        adapter.addCardData(movie3);
        adapter.addCardData(movie4);
        adapter.addCardData(movie5);
        adapter.addCardData(movie6);
        adapter.addCardData(movie7);
        adapter.addCardData(movie8);
        adapter.addCardData(movie9);


        recyclerView_apple.setAdapter(adapter);

        adapter.setOnItemClickListener(new onMovieItemClickListener() {
            @Override
            public void onItemClickListener(RecyclerView.ViewHolder holder, View view, int position) {
                mv_card_data card_data = adapter.getCardData(position);

                Intent intent = new Intent(getContext(), nextActivity.class);
                startActivity(intent);
            }
        });

        return view;




    }
}
