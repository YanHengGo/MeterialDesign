package com.yanheng.recyclerview.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanheng.recyclerview.recyclerviewdemo.FirstActivity;
import com.yanheng.recyclerview.recyclerviewdemo.R;
import com.yanheng.recyclerview.recyclerviewdemo.viewhoder.SimpleViewHolder;

import java.util.ArrayList;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    private final Context context;
    private final ArrayList<String> datalist;

    public SimpleAdapter(Context context, ArrayList<String> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    /**
     * 更新条件1：recyclerView.setAdapter
     * 更新条件2：notifychange
     *
     * 创建VIEWHOLDER
     * @param parent
     * @param position
     * @return
     */
    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.simle_item, parent, false);
        SimpleViewHolder simpleViewHolder = new SimpleViewHolder(view);
        return simpleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder simpleViewHolder, int position) {
        simpleViewHolder.setlayout(datalist.get(position));
    }

    /**
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return datalist.size();
    }
}
