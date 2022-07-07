package com.example;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bottom_nav.mv_HomeFragment;
import com.example.bottom_nav.mv_LikeFragment;
import com.example.bottom_nav.mv_SearchFragment;
import com.example.sns.R;
import com.example.top_menu.mv_amazon;
import com.example.top_menu.mv_apple;
import com.example.top_menu.mv_coupang;
import com.example.top_menu.mv_disney;
import com.example.top_menu.mv_netflix;
import com.example.top_menu.mv_tving;
import com.example.top_menu.mv_watcha;
import com.example.top_menu.mv_wavve;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import androidx.viewpager.widget.ViewPager;

public class mv_RootActivity extends AppCompatActivity {

    private FragmentPagerAdapter fragmentPagerAdapter;

    Fragment fragmentHome;
    Fragment fragmentSearch;
    Fragment fragmentLikes;

    Fragment fragmentNetflix;
    Fragment fragmentDisney;
    Fragment fragmentApple;
    Fragment fragmentAmazon;
    Fragment fragmentWavve;
    Fragment fragmentWatcha;
    Fragment fragmentTving;
    Fragment fragmentCoupang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mv_root);

       ViewPager viewPager = findViewById(R.id.mv_viewpager);
       fragmentPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

       TabLayout tabLayout = findViewById(R.id.mv_tabLayout);
       viewPager.setAdapter(fragmentPagerAdapter);
       tabLayout.setupWithViewPager(viewPager);






        fragmentHome     = new mv_HomeFragment();
        fragmentSearch   = new mv_SearchFragment();
        fragmentLikes    = new mv_LikeFragment();

        fragmentNetflix  = new mv_netflix();
        fragmentDisney   = new mv_disney();
        fragmentApple    = new mv_apple();
        fragmentAmazon   = new mv_amazon();
        fragmentWavve   = new mv_wavve();
        fragmentWatcha   = new mv_watcha();
        fragmentTving   = new mv_tving();
        fragmentCoupang   = new mv_coupang();


        // 하단 메뉴 버튼 (홈, 검색, 찜)
        getSupportFragmentManager().beginTransaction().replace(R.id.mv_container,  fragmentHome).commit();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_nav);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {

                    case R.id.mv_home:
                        fragment = fragmentHome;
                        break;

                    case R.id.mv_search:
                        fragment = fragmentSearch;
                        break;

                    case R.id.mv_like:
                        fragment = fragmentLikes;
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.mv_container, fragment).commit();
                return true;
            }
        });




        // 상단 회사 버튼
//        Button button = findViewById(R.id.mv_btn1);
//        button.setOnClickListener(view -> {
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.mv_container, fragmentNetflix).commit();
//
//
//        });
//
//        Button button2 = findViewById(R.id.mv_btn2);
//        button2.setOnClickListener(view -> {
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.mv_container, fragmentDisney).commit();
//
//        });
//
//        Button button3 = findViewById(R.id.mv_btn3);
//        button3.setOnClickListener(view -> {
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.mv_container, fragmentApple).commit();
//
//        });
//
//        Button button4 = findViewById(R.id.mv_btn4);
//        button4.setOnClickListener(view -> {
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.mv_container, fragmentAmazon).commit();
//
//        });
//
//        Button button5 = findViewById(R.id.mv_btn5);
//        button5.setOnClickListener(view -> {
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.mv_container, fragmentWavve).commit();
//
//        });
//
//        Button button6 = findViewById(R.id.mv_btn6);
//        button6.setOnClickListener(view -> {
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.mv_container, fragmentWatcha).commit();
//
//        });
//
//        Button button7 = findViewById(R.id.mv_btn7);
//        button7.setOnClickListener(view -> {
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.mv_container, fragmentTving).commit();
//
//        });
//
//        Button button8 = findViewById(R.id.mv_btn8);
//        button8.setOnClickListener(view -> {
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.mv_container, fragmentCoupang).commit();
//
//        });





    }


}
