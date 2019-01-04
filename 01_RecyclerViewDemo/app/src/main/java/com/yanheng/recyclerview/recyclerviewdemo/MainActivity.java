package com.yanheng.recyclerview.recyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yanheng.recyclerview.recyclerviewdemo.activity.CardViewActivity;
import com.yanheng.recyclerview.recyclerviewdemo.activity.DrawerLayoutActivity;
import com.yanheng.recyclerview.recyclerviewdemo.activity.FifthActivity;
import com.yanheng.recyclerview.recyclerviewdemo.activity.FirstActivity;
import com.yanheng.recyclerview.recyclerviewdemo.activity.FouthActivity;
import com.yanheng.recyclerview.recyclerviewdemo.activity.TabLayoutActivity;
import com.yanheng.recyclerview.recyclerviewdemo.activity.ThirdActivity;
import com.yanheng.recyclerview.recyclerviewdemo.activity.ToolBarActivity;

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
                    case 1:
                        enterActivity(ThirdActivity.class);
                        break;
                    case 2:
                        enterActivity(FouthActivity.class);
                        break;
                    case 3:
                        enterActivity(FifthActivity.class);
                        break;
                    case 4:
                        enterActivity(CardViewActivity.class);
                        break;
                    case 5:
                        enterActivity(TabLayoutActivity.class);
                        break;
                    case 6:
                        enterActivity(ToolBarActivity.class);
                        break;
                    case 7:
                        enterActivity(DrawerLayoutActivity.class);
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
        datalist.add("RecyclerView单行，多行，单横，多横");
        datalist.add("RecyclerView瀑布流效果 条目动画");
        datalist.add("RecyclerView多条目效果展示");
        datalist.add("RecyclerView条目拖动,删除效果");
        datalist.add("CardView效果展示");
        datalist.add("TabLayout效果展示");
        datalist.add("toolbar效果展示");
        datalist.add("DrawerLayout效果展示");
    }
}
