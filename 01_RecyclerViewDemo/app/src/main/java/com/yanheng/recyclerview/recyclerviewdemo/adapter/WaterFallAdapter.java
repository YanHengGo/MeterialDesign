package com.yanheng.recyclerview.recyclerviewdemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanheng.recyclerview.recyclerviewdemo.R;
import com.yanheng.recyclerview.recyclerviewdemo.listener.OnItemCliclistener;
import com.yanheng.recyclerview.recyclerviewdemo.viewhoder.SimpleViewHolder;

import java.util.ArrayList;

public class WaterFallAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    private final Context context;
    private final ArrayList<String> datalist;

    ArrayList<Integer> heightList = new ArrayList<>();
    private OnItemCliclistener cliclistener;

    public WaterFallAdapter(Context context, ArrayList<String> datalist) {
        this.context = context;
        this.datalist = datalist;
        for(int i=0;i<1000;i++){
            heightList.add(((int) (100 + Math.random() * 200)));
        }
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
    public void onBindViewHolder(@NonNull SimpleViewHolder simpleViewHolder, final int position) {
        ViewGroup.LayoutParams layoutParams = simpleViewHolder.getTextView().getLayoutParams();
        layoutParams.height = heightList.get(position);
        simpleViewHolder.getTextView().setLayoutParams(layoutParams);
        simpleViewHolder.getTextView().setBackgroundColor(
                Color.rgb(100 + ((int) (Math.random() * 155)),
                        100 + ((int) (Math.random() * 155)),
                        100 + ((int) (Math.random() * 155)))
        );
        simpleViewHolder.setlayout(datalist.get(position));
        ((View) simpleViewHolder.getRootView()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliclistener.onItemClick(position);
            }
        });
    }

    /**
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public void setOnitemClickListener(OnItemCliclistener onItemCliclistener) {
        cliclistener = onItemCliclistener;
    }
}
