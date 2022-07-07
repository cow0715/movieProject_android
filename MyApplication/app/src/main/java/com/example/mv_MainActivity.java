package com.example;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sns.LoginActivity;
import com.example.sns.R;

public class mv_MainActivity extends AppCompatActivity {

    ImageView mv_mainImg;
    TextView mv_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mv_activity_main);

        mv_mainImg = (ImageView) findViewById(R.id.mv_mainImage);
        mv_text = (TextView) findViewById(R.id.mv_mainText);

        mv_mainImg.animate().alpha(0f).setDuration(0);
        mv_text.animate().alpha(0f).setDuration(0);

        mv_mainImg.animate().alpha(1f).setDuration(1000).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mv_text.animate().alpha(1f).setDuration(1000);
            }
        });

        //3초후
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mv_MainActivity.this, mv_LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}












