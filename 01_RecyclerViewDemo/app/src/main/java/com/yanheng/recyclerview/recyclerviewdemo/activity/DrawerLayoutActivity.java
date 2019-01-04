package com.yanheng.recyclerview.recyclerviewdemo.activity;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.yanheng.recyclerview.recyclerviewdemo.R;

import java.util.ArrayList;

public class DrawerLayoutActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private ArrayList<String> datalist;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        drawerLayout = ((DrawerLayout) findViewById(R.id.activity_drawer_layout));
        listView = ((ListView) findViewById(R.id.list_view));
        initData();
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datalist));

        //toolbar
        toolbar = ((Toolbar) findViewById(R.id.toolbar));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
//                Toast.makeText(DrawerLayoutActivity.this,"onDrawerSlide called",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {
                Toast.makeText(DrawerLayoutActivity.this,"onDrawerOpened called",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
                Toast.makeText(DrawerLayoutActivity.this,"onDrawerClosed called",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDrawerStateChanged(int i) {
//                Toast.makeText(DrawerLayoutActivity.this,"onDrawerStateChanged called",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initData() {
        datalist = new ArrayList<>();
        for(int i=0;i<100;i++){
            datalist.add("条目 :"+String.valueOf(i));
        }
    }
}
