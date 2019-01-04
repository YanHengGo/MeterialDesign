package com.yanheng.recyclerview.recyclerviewdemo.activity;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.yanheng.recyclerview.recyclerviewdemo.R;
import com.yanheng.recyclerview.recyclerviewdemo.adapter.WaterFallAdapter;
import com.yanheng.recyclerview.recyclerviewdemo.listener.OnItemCliclistener;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> datalist;
    private WaterFallAdapter waterFallAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        recyclerView = ((RecyclerView) findViewById(R.id.recyclerView));
        swipeRefreshLayout = ((SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout));
        swipeRefreshLayout.setColorSchemeColors(Color.RED,Color.GREEN,Color.YELLOW);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        datalist.add(0,"new item");
//                        waterFallAdapter.notifyItemInserted(0);
                        waterFallAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },2000);
            }
        });
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,RecyclerView.VERTICAL));
        datalist = new ArrayList<>();
        for(int i=0;i<1000;i++){
            datalist.add("item:"+String.valueOf(i));
        }
        waterFallAdapter = new WaterFallAdapter(this, datalist);
        waterFallAdapter.setOnitemClickListener(new OnItemCliclistener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(ThirdActivity.this,""+position+" clicked",Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(waterFallAdapter);
    }

    public void addItem(View view) {
        int position = 2;
        datalist.add(position,"haha");
        waterFallAdapter.notifyItemInserted(position);
    }

    public void deleteItem(View view) {
        int position = 4;
        datalist.remove(position);
        waterFallAdapter.notifyItemRemoved(position);
    }
}
