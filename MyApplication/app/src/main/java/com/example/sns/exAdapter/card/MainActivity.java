package com.example.sns.exAdapter.card;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_card_activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);


        Person person1 = new Person("korea","111-1111-1111");
        Person person2 = new Person("dev","22222222");


        PersonAdapter adapter = new PersonAdapter();
        adapter.addItem(person1);
        adapter.addItem(person2);
        adapter.addItem(new Person("dev1","22222222"));
        adapter.addItem(new Person("dev2","22222222"));
        adapter.addItem(new Person("dev3","22222222"));
        adapter.addItem(new Person("dev4","22222222"));
        adapter.addItem(new Person("dev5","22222222"));
        adapter.addItem(new Person("dev6","22222222"));
        adapter.addItem(new Person("dev7","22222222"));
        adapter.addItem(new Person("dev8","22222222"));
        adapter.addItem(new Person("dev9","22222222"));
        adapter.addItem(new Person("dev0","22222222"));
        adapter.addItem(new Person("dev-","22222222"));



        recyclerView.setAdapter(adapter);



        adapter.setOnItemClickListener(new OnPsersonItemClickListner() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);

                Log.d("adapter", item.name);
                Log.d("adapter", item.phone);
            }
        });
    }
}












