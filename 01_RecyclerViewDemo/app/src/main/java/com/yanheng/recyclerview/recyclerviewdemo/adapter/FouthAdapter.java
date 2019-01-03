package com.yanheng.recyclerview.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanheng.recyclerview.recyclerviewdemo.R;
import com.yanheng.recyclerview.recyclerviewdemo.viewhoder.FirstTypeHolder;
import com.yanheng.recyclerview.recyclerviewdemo.viewhoder.SecondTypeHolder;
import com.yanheng.recyclerview.recyclerviewdemo.viewhoder.ThirdTypeHolder;

public class FouthAdapter extends RecyclerView.Adapter {

    private final Context context;

    public class TYPE {
        public static final int FIRST = 0;
        public static final int SECOND = 1;
        public static final int THIRD = 2;
    }
    public FouthAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
        RecyclerView.ViewHolder viewHolder = null;
        View view = LayoutInflater.from(context).inflate(R.layout.type_first_layout,parent,false);
        switch (viewtype){
            case TYPE.FIRST:
                view = LayoutInflater.from(context).inflate(R.layout.type_first_layout,parent,false);
                viewHolder=new FirstTypeHolder(view);
                break;
            case TYPE.SECOND:
                view = LayoutInflater.from(context).inflate(R.layout.type_second_layout,parent,false);
                viewHolder=new SecondTypeHolder(view);
                break;
            case TYPE.THIRD:
                view = LayoutInflater.from(context).inflate(R.layout.type_third_layout,parent,false);
                viewHolder=new ThirdTypeHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemViewType(int position) {
        if(position ==0){
            return TYPE.FIRST;
        }else if(position==1){
            return TYPE.SECOND;
        }
        return TYPE.THIRD;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
