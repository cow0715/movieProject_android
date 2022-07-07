package com.example.sns.view.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.R;
import com.example.sns.data.ResponseDTO;
import com.example.sns.data.SnsData;
import com.example.sns.network.NetworkConfig;
import com.example.sns.network.SnsV1API;
import com.example.sns.util.sns.SnsAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class HomeFragment extends Fragment {
    private RecyclerView recyclerView_home;
    SnsAdapter snsAdapter;

    ArrayList<SnsData> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView_home = view.findViewById(R.id.recycler_home);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView_home.setLayoutManager(gridLayoutManager);

        snsAdapter = new SnsAdapter();
        recyclerView_home.setAdapter(snsAdapter);

        getSnsList();
        //getSnsList2();

        return view;
    }

    void getSnsList(){
        Log.d("apiTest ","getPostList");
        Retrofit retrofit = NetworkConfig.getClient();
        SnsV1API snsAPI = retrofit.create(SnsV1API.class);

        snsAPI.getSnsList().enqueue(new Callback<ResponseDTO<SnsData>>() {
            @Override
            public void onResponse(Call<ResponseDTO<SnsData>> call, Response<ResponseDTO<SnsData>> response) {
                if(response.code() == 200){
                    ResponseDTO resDTO = response.body();
                    list = (ArrayList<SnsData>) resDTO.getResultData();
                    SnsData snsdata = list.get(1);

                    Log.d("apiTest",list.toString());
                    Log.d("apiTest",snsdata.getTitle());
                    Log.d("apiTest",snsdata.getContent());

                    resProcess(list);
                }
            }

            @Override
            public void onFailure(Call<ResponseDTO<SnsData>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }

    void getSnsList2(){
        Log.d("apiTest ","getPostList");
        Retrofit retrofit = NetworkConfig.getClient();
        SnsV1API snsAPI = retrofit.create(SnsV1API.class);

        snsAPI.getSnsListV2().enqueue(new Callback<ResponseDTO<SnsData>>() {
            @Override
            public void onResponse(Call<ResponseDTO<SnsData>> call, Response<ResponseDTO<SnsData>> response) {
                if(response.code() == 200){
                    ResponseDTO resDTO = response.body();
                    list = (ArrayList<SnsData>) resDTO.getResultData();
                    SnsData snsdata = list.get(1);

                    Log.d("apiTest",list.toString());
                    Log.d("apiTest",snsdata.getTitle());
                    Log.d("apiTest",snsdata.getContent());

                    resProcess(list);
                }
            }

            @Override
            public void onFailure(Call<ResponseDTO<SnsData>> call, Throwable t) {
                Log.d("apiTest",t.getMessage());
            }
        });
    }



    public void resProcess(ArrayList<SnsData> list){

        snsAdapter.addSnsList(list);


        snsAdapter.notifyDataSetChanged();
    }
}










