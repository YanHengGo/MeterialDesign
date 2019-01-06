package com.yanheng.fragmentdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.yanheng.fragmentdemo.util.L;

import java.util.ArrayList;

public class MypagerAdapter extends PagerAdapter {

    private final ArrayList<View> viewlist;

    public MypagerAdapter(ArrayList<View> viewlist){
        this.viewlist = viewlist;
    }
    @Override
    public int getCount() {
        return viewlist.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        L.d("load -->"+position);
        View view = viewlist.get(position);
        container.addView(view);
        return view;
    }

    /**
     *
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        L.d("unload -->"+position);
        container.removeView(viewlist.get(position));
    }
}
