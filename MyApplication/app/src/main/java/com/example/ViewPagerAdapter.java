package com.example;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.top_menu.mv_amazon;
import com.example.top_menu.mv_apple;
import com.example.top_menu.mv_coupang;
import com.example.top_menu.mv_disney;
import com.example.top_menu.mv_netflix;
import com.example.top_menu.mv_tving;
import com.example.top_menu.mv_watcha;
import com.example.top_menu.mv_wavve;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new mv_amazon();
            case 1:
                return new mv_apple();
            case 2:
                return new mv_coupang();
            case 3:
                return new mv_disney();
            case 4:
                return new mv_netflix();
            case 5:
                return new mv_tving();
            case 6:
                return new mv_watcha();
            case 7:
                return new mv_wavve();
            default:
                return null;
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "AMAZON PRIME VIDEO";
            case 1:
                return "APPLE TV+";
            case 2:
                return "COUPANG PLAY";
            case 3:
                return "DISNEY PLUS";
            case 4:
                return "NETFLIX";
            case 5:
                return "TVING";
            case 6:
                return "WATCHA";
            case 7:
                return "WAVVE";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 8;
    }
}
