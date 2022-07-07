package com.example.sns.exAdapter.list;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sns.R;

import java.util.ArrayList;

public class ListMainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_list2_activity_main);

        final ArrayList<String> midList = new ArrayList<String>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, midList);

        ListView list = findViewById(R.id.listView2);

        list.setAdapter(adapter);

        EditText edtMsg = findViewById(R.id.edtMSG);

        Button btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(view -> {

            midList.add(edtMsg.getText().toString());
            adapter.notifyDataSetChanged();

            edtMsg.setText("");


        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(), midList.get(arg2), Toast.LENGTH_LONG).show();

            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                midList.remove(i);
                adapter.notifyDataSetChanged();

                return false;
            }
        });
    }
}












