package com.yanheng.fragmentdemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;

import com.yanheng.fragmentdemo.adapter.MypagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    ArrayList<View> viewlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = ((ViewPager) findViewById(R.id.viewpager));
        initView();
        viewPager.setAdapter(new MypagerAdapter(viewlist));
    }

    private void initView() {
        addViewWithId(R.layout.viewpager1);
        addViewWithId(R.layout.viewpager2);
        addViewWithId(R.layout.viewpager3);
        addViewWithId(R.layout.viewpager4);
    }



    private void addViewWithId(int viewpager) {
        View view = View.inflate(this, viewpager, null);
        viewlist.add(view);
    }
}
