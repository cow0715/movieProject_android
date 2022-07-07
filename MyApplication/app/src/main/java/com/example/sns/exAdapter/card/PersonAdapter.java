package com.example.sns.exAdapter.card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.R;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> implements OnPsersonItemClickListner {

    ArrayList<Person> items = new ArrayList<Person>();
    OnPsersonItemClickListner listner;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.ex_card_person, parent, false);

        return  new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {

        return items.size(); //3
    }


    public void addItem(Person item){
        items.add(item);
    }

    public Person getItem(int position){

        return items.get(position);
    }

    public void setOnItemClickListener(OnPsersonItemClickListner listner){

        this.listner = listner;
    }

    //listner
    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listner != null){
            listner.onItemClick(holder,view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewPhone;

        public ViewHolder( View itemView ,final OnPsersonItemClickListner listner) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.mv_search_title);
            textViewPhone = itemView.findViewById(R.id.textViewPhone);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listner != null){
                        listner.onItemClick(ViewHolder.this, view, position );
                    }
                }
            });
        }

        public void setItem(Person item){
            textViewName.setText(item.getName());
            textViewPhone.setText(item.getPhone());
        }
    }

}
