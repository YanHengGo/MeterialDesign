package com.yanheng.recyclerview.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.yanheng.recyclerview.recyclerviewdemo.adapter.WaterFallAdapter;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        recyclerView = ((RecyclerView) findViewById(R.id.recyclerView));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,RecyclerView.VERTICAL));
        ArrayList<String> datalist = new ArrayList<>();
        for(int i=0;i<1000;i++){
            datalist.add("item:"+String.valueOf(i));
        }
        recyclerView.setAdapter(new WaterFallAdapter(this,datalist));
    }
}
