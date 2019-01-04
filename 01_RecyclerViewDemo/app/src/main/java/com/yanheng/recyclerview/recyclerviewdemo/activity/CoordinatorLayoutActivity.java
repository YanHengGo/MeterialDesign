package com.yanheng.recyclerview.recyclerviewdemo.activity;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yanheng.recyclerview.recyclerviewdemo.R;
import com.yanheng.recyclerview.recyclerviewdemo.fragment.NewsFragment;

public class CoordinatorLayoutActivity extends AppCompatActivity implements NewsFragment.OnFragmentInteractionListener {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String [] datalists = {"新闻","推荐","头条","八卦","娱乐","体育","美女","帅哥","其他"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);

        initView();
    }

    private void initView() {
        viewPager = ((ViewPager) findViewById(R.id.viewpager));
        tabLayout = ((TabLayout) findViewById(R.id.tablayout));
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return NewsFragment.newInstance(datalists[position],"");
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return datalists[position];
            }

            @Override
            public int getCount() {
                return datalists.length;
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
