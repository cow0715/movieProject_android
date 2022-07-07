package com.example.sns.exAdapter.card2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.R;
import com.example.sns.exAdapter.card.OnPsersonItemClickListner;
import com.example.sns.exAdapter.card.Person;
import com.example.sns.exAdapter.card2.data.CfData;
import com.example.sns.exAdapter.card2.data.InsData;
import com.example.sns.exAdapter.card2.data.PersonData;
import com.example.sns.exAdapter.card2.item.CfItem;
import com.example.sns.exAdapter.card2.item.InsItem;
import com.example.sns.exAdapter.card2.item.PersonItem;

import java.util.ArrayList;

public class InstagramAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    ArrayList<Object> items = new ArrayList<Object>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == 0){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.ex_instagram_item, parent, false);
            return new InsItem(itemView);

        }else if(viewType == 1){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.ex_cf_item, parent, false);
            return new CfItem(itemView);

        }else if(viewType == 2){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.ex_card_person, parent, false);
            return new PersonItem(itemView);

        }else {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.ex_instagram_item, parent, false);
            return new InsItem(itemView);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        position 0 - 4

        Object obj = items.get(position);

        if (obj instanceof InsData){
            InsData ins = (InsData) obj;

            InsItem insItem = (InsItem) holder;

            insItem.setItem(ins);


        } else if(obj instanceof CfData){
            CfData cf = (CfData) obj;

            CfItem cfItem = (CfItem) holder;

            cfItem.setItem(cf);

        }else if(obj instanceof PersonData){
            PersonData person = (PersonData) obj;

            PersonItem personItem = (PersonItem) holder;

            personItem.setItem(person);

        }else{
            InsData ins = (InsData) obj;

            InsItem insItem = (InsItem) holder;

            insItem.setItem(ins);
        }
    }

    @Override
    public int getItemCount() {
        return items.size(); // 5
    }


    @Override
    public int getItemViewType(int position) {
        Object obj = items.get(position);

        if (obj instanceof InsData){
            InsData ins = (InsData) obj;
            return ins.getType();

        } else if(obj instanceof CfData) {
            CfData cf = (CfData) obj;
            return cf.getType();

        }else if(obj instanceof PersonData) {
            PersonData pdata = (PersonData) obj;
            return pdata.getType();

        }else{
            return 0;
        }

    }

    public void addInsData(InsData data){
        items.add(data);
    }

    public void addCfData(CfData data){
        items.add(data);
    }

    public void addPersonData(PersonData data){
        items.add(data);
    }

}
