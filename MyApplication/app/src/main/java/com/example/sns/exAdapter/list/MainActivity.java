package com.example.sns.exAdapter.list;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sns.R;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_list_activity_main);

        final String[] mid =  {"셜록홈즈","프렌즈","로스트","글리","스킨스","모던패밀리",
                                "셜록홈즈","프렌즈","로스트","글리","스킨스","모던패밀리",
                                "셜록홈즈","프렌즈","로스트","글리","스킨스","모던패밀리",
                                "셜록홈즈","프렌즈","로스트","글리","스킨스","모던패밀리"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, mid);

        ListView list = findViewById(R.id.listView2);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(), mid[arg2], Toast.LENGTH_LONG).show();
            }
        });

    }
}












