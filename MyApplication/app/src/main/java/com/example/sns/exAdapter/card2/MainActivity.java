package com.example.sns.exAdapter.card2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.R;
import com.example.sns.exAdapter.card.OnPsersonItemClickListner;
import com.example.sns.exAdapter.card.Person;
import com.example.sns.exAdapter.card.PersonAdapter;
import com.example.sns.exAdapter.card2.data.CfData;
import com.example.sns.exAdapter.card2.data.InsData;
import com.example.sns.exAdapter.card2.data.PersonData;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_card_activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

       // LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
       // recyclerView.setLayoutManager(layoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);


        InstagramAdapter adapter = new InstagramAdapter();

        InsData insData1 = new InsData(0,"devcation1","100","#korea #android #test");
        InsData insData5 = new InsData(0,"devcation5","100","#korea #android #test");
        CfData CfData2 = new CfData(1,"nike","testname","test color","1000");
        PersonData personData = new PersonData(2,"kss", "010101");


        adapter.addInsData(insData1);
        adapter.addCfData(CfData2);
        adapter.addInsData( insData5);
        adapter.addPersonData(personData);

        recyclerView.setAdapter(adapter);



    }
}












