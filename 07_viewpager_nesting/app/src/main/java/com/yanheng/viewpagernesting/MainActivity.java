package com.yanheng.viewpagernesting;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yanheng.viewpagernesting.fragment.Fragment1;
import com.yanheng.viewpagernesting.fragment.Fragment2;
import com.yanheng.viewpagernesting.fragment.Fragment3;

public class MainActivity extends FragmentActivity
        implements Fragment1.OnFragmentInteractionListener,
        Fragment2.OnFragmentInteractionListener,
        Fragment3.OnFragmentInteractionListener{

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        L.d();
        viewPager = ((ViewPager) findViewById(R.id.outter_viewpager));
        L.d();
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                Fragment fragment = null;
                switch (i){
                    case 0:
                        fragment = Fragment1.newInstance("","");
                        break;
                    case 1:
                        fragment = Fragment2.newInstance("","");
                        break;
                    case 2:
                        fragment = Fragment3.newInstance("","");
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        L.d();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
