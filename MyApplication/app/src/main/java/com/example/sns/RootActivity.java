package com.example.sns;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.sns.view.home.HomeFragment;
import com.example.sns.view.like.LikeFragment;
import com.example.sns.view.post.PostFragment;
import com.example.sns.view.profile.ProfileFragment;
import com.example.sns.view.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RootActivity extends AppCompatActivity {

    Fragment fragmentHome;
    Fragment fragmentSearch;
    Fragment fragmentPost;
    Fragment fragmentLikes;
    Fragment fragmentProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        fragmentHome     = new HomeFragment();
        fragmentSearch   = new SearchFragment();
        fragmentPost     = new PostFragment();
        fragmentLikes    = new LikeFragment();
        fragmentProfile  = new ProfileFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,  fragmentHome).commit();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.Home:
                        fragment = fragmentHome;
                        break;

                    case R.id.mv_like:
                        fragment = fragmentSearch;
                        break;

                    case R.id.post:
                        fragment = fragmentPost;
                        break;
                    case R.id.likes:
                        fragment = fragmentLikes;
                        break;
                    case R.id.profile:
                        fragment = fragmentProfile;
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                return true;
            }
        });
    }
}