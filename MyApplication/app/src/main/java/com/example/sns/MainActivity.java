package com.example.sns;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imgInsta;
    TextView txTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgInsta = (ImageView) findViewById(R.id.mv_mainImage);
        txTitle = (TextView) findViewById(R.id.mv_mainText);

        imgInsta.animate().alpha(0f).setDuration(0);
        txTitle.animate().alpha(0f).setDuration(0);

        imgInsta.animate().alpha(1f).setDuration(1000).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                txTitle.animate().alpha(1f).setDuration(1000);
            }
        });

        //3초후
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}












