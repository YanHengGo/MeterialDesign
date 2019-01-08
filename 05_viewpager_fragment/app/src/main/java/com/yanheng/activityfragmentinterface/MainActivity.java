package com.yanheng.activityfragmentinterface;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yanheng.activityfragmentinterface.bean.WebInfo;
import com.yanheng.activityfragmentinterface.fragment.NewsFragment;

public class MainActivity extends AppCompatActivity implements NewsFragment.OnFragmentInteractionListener {
    String [] urls =  {
            "www.toutiao.com",
            "www.yule.com",
            "www.八卦.com",
            "www.科技.com",
            "www.体育.com",
    };
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = ((ViewPager) findViewById(R.id.viewpager));
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                NewsFragment newsFragment = NewsFragment.newInstance(urls[i],new WebInfo("www.test1.com","test site"));

                return newsFragment;
            }

            @Override
            public int getCount() {
                return urls.length;
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
