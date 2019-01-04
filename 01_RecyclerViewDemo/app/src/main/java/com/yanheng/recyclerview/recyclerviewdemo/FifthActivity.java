package com.yanheng.recyclerview.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.yanheng.recyclerview.recyclerviewdemo.adapter.ItemAnimatorAdapter;
import com.yanheng.recyclerview.recyclerviewdemo.listener.ItemTouchListener;
import com.yanheng.recyclerview.recyclerviewdemo.listener.OnItemCliclistener;
import com.yanheng.recyclerview.recyclerviewdemo.util.L;

import java.util.ArrayList;
import java.util.Collections;

public class FifthActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> datalist;
    private ItemAnimatorAdapter itemAnimatorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        L.d();
        recyclerView = ((RecyclerView) findViewById(R.id.recyclerView));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,RecyclerView.VERTICAL));
        datalist = new ArrayList<>();
        for(int i=0;i<1000;i++){
            datalist.add("item:"+String.valueOf(i));
        }
        itemAnimatorAdapter = new ItemAnimatorAdapter(this, datalist);
        itemAnimatorAdapter.setOnitemClickListener(new OnItemCliclistener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(FifthActivity.this,""+position+" clicked",Toast.LENGTH_SHORT).show();
            }
        });
        L.d();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchCallback(new ItemTouchListener() {
            @Override
            public void onMove(int oldPosition, int newPosition) {
                Collections.swap(datalist,oldPosition,newPosition);
                itemAnimatorAdapter.notifyItemMoved(oldPosition,newPosition);
            }

            @Override
            public void onSwiped(int position) {
                L.d(String.valueOf(position));
                datalist.remove(position);
                itemAnimatorAdapter.notifyItemRemoved(position);
            }
        }));
        itemTouchHelper.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(itemAnimatorAdapter);
    }

    public void addItem(View view) {
//        int position = 2;
//        datalist.add(position,"haha");
//        itemAnimatorAdapter.notifyItemInserted(position);
    }

    public void deleteItem(View view) {
//        int position = 4;
//        datalist.remove(position);
//        itemAnimatorAdapter.notifyItemRemoved(position);
    }

}
