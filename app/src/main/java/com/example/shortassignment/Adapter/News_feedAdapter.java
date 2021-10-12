package com.example.shortassignment.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.shortassignment.DetailPageActivity;
import com.example.shortassignment.Model.News_feed;
import com.example.shortassignment.R;

import java.util.ArrayList;

public class News_feedAdapter extends RecyclerView.Adapter<News_feedAdapter.MyViewHolder> {
    private ArrayList<News_feed> mList = new ArrayList<>();

    public News_feedAdapter(ArrayList<News_feed> mList)
    {
        this.mList = mList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(mList.get(position).getName());
        holder.tv_body.setText(mList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        private TextView tv_body;
        private CardView cv_row;
        private TextView tv_read;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_body = itemView.findViewById(R.id.tv_body);
            tv_name = itemView.findViewById(R.id.tv_name);
            cv_row = itemView.findViewById(R.id.cv_row);
            tv_read = itemView.findViewById(R.id.tv_read);

            cv_row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("body",mList.get(getPosition()).getFullDesc());
                    bundle.putString("name",tv_name.getText().toString());

                    Intent intent = new Intent(itemView.getContext(), DetailPageActivity.class);
                    intent.putExtras(bundle);

                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }
}
