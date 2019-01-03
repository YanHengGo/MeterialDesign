package com.yanheng.recyclerview.recyclerviewdemo.viewhoder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yanheng.recyclerview.recyclerviewdemo.R;

public class SimpleViewHolder extends RecyclerView.ViewHolder{


    private final TextView textView;
    private final View rootView;

    public SimpleViewHolder(@NonNull View itemView) {
        super(itemView);
        rootView = itemView;
        textView = (TextView) itemView.findViewById(R.id.tv_text);
    }

    public void setlayout(String s) {
        textView.setText(s);
    }

    public TextView getTextView() {
        return textView;
    }

    public View getRootView() {
        return rootView;
    }
}
