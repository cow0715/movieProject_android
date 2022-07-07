package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sns.JoinActivity;
import com.example.sns.R;
import com.example.sns.RootActivity;
import com.example.mv_RootActivity;

public class mv_LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mv_login);

        Button btnJoin = findViewById(R.id.mv_signUpbtn);
        btnJoin.setOnClickListener(view -> {
            moveJoinActivity();
        });

        Button btnJLogin = findViewById(R.id.mv_loginBtn);
        btnJLogin.setOnClickListener(view -> {
            moveRootActivity();
        });

    }


    private void moveJoinActivity(){
        Intent intent = new Intent(mv_LoginActivity.this, mv_JoinActivity.class);
        startActivityResult.launch(intent);
    }

    private void moveRootActivity(){
        Intent intent = new Intent(mv_LoginActivity.this, mv_RootActivity.class);
        startActivityResult.launch(intent);
    }


    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {

                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Bundle bundle = result.getData().getExtras();
                        String join = bundle.getString("join");
                        Log.d("join",join);


                        // userid, email, name, password
                    }
                }

            });
}












