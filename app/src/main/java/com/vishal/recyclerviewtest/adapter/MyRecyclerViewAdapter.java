package com.vishal.recyclerviewtest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vishal.recyclerviewtest.MainActivity;
import com.vishal.recyclerviewtest.R;


/**
 * Created by Vishal Aroor on 08-Aug-17.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    public MyRecyclerViewAdapter() {}

    MainActivity activity;
    String[] countryList;
    String[] countryFlags;

    public MyRecyclerViewAdapter(MainActivity activity, String[] countryList, String[] countryFlags) {

        this.activity = activity;
        this.countryList = countryList;
        this.countryFlags = countryFlags;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView2);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.myitemlayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(countryList[position]);
        Picasso.with(activity).load(countryFlags[position]).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return countryList.length;
    }

}
