package com.yanheng.recyclerview.recyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listview = (ListView) findViewById(R.id.list_view);
        initdata();
        listview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datalist));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        enterActivity(FirstActivity.class);
                        break;
                    case 2:
                        enterActivity(ThirdActivity.class);
                        break;
                    case 3:
                        enterActivity(FouthActivity.class);
                        break;
                }
            }
        });
    }
    public void enterActivity(Class clazz){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }

    private void initdata() {
        datalist = new ArrayList<>();
        datalist.add("单行，多行，单横，多横");
        datalist.add("添加下划线");
        datalist.add("瀑布流效果 条目动画");
        datalist.add("多条目效果展示");
        datalist.add("条目拖动删除效果");
        datalist.add("下拉刷新上拉加载");
    }
}
