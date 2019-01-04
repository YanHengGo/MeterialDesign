package com.yanheng.recyclerview.recyclerviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yanheng.recyclerview.recyclerviewdemo.R;
import com.yanheng.recyclerview.recyclerviewdemo.adapter.SimpleAdapter;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> datalist;
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        recyclerView = ((RecyclerView) findViewById(R.id.recyclerView));
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        simpleAdapter = new SimpleAdapter(this, datalist);
        recyclerView.setAdapter(simpleAdapter);
    }

    private void initData() {
        datalist = new ArrayList<>();
        for(int i=0;i<1000;i++){
            datalist.add("条目"+i);
        }
    }

    public void sinleVertical(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        simpleAdapter.notifyDataSetChanged();
    }

    public void moreVertical(View view) {
        recyclerView.setLayoutManager(new GridLayoutManager(this,3,RecyclerView.VERTICAL,false));
        simpleAdapter.notifyDataSetChanged();
    }

    public void sinleHorizontal(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        simpleAdapter.notifyDataSetChanged();
    }

    public void moreHorizontal(View view) {
        recyclerView.setLayoutManager(new GridLayoutManager(this,3,RecyclerView.HORIZONTAL,false));
        simpleAdapter.notifyDataSetChanged();
    }
}
