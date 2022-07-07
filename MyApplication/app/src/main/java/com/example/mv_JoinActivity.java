package com.example;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sns.R;

public class mv_JoinActivity extends AppCompatActivity {
    EditText userId;
    EditText userPw;
    EditText userEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mv_signup);

        userId = findViewById(R.id.mv_id);
        userPw = findViewById(R.id.mv_pw);
        userEmail = findViewById(R.id.mv_email);



        Button btnSignUp = findViewById(R.id.mv_successBtn);
        btnSignUp.setOnClickListener(view -> {

            Log.d("joinact","btnSignup");

            AlertDialog.Builder builder = new AlertDialog.Builder(mv_JoinActivity.this);
            builder.setTitle("join");
            builder.setMessage("join join");
            builder.setIcon(android.R.drawable.ic_lock_lock);
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(), "join yes", Toast.LENGTH_SHORT).show();
//                    Intent intent = getIntent();
//                    intent.putExtra("join",edtName.getText().toString());
//
//                    setResult(RESULT_OK, intent);
                    Intent intent = getIntent();
                    intent.putExtra("userid","1");
                    intent.putExtra("email","test data");
                    intent.putExtra("password","1234");
                    setResult(RESULT_OK, intent);


                    finish();
                }
            });
            builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(), "join no", Toast.LENGTH_SHORT).show();
                    userId.setText("");
                    userPw.setText("");
                    userEmail.setText("");

                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        });


    }
}












