package com.yanheng.fragmentdemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;

import com.yanheng.fragmentdemo.adapter.MypagerAdapter;
import com.yanheng.fragmentdemo.bean.News;
import com.yanheng.fragmentdemo.util.L;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    ArrayList<News> dataList = new ArrayList<>();
    private Disposable disposable;
    private boolean isTouching = false;
    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = ((ViewPager) findViewById(R.id.viewpager));
        initData();
        viewPager.setAdapter(new MypagerAdapter(this,dataList, new MypagerAdapter.OnClickViewListener() {
            @Override
            public void isTouchDown() {
                isTouching = true;
            }

            @Override
            public void isTouchUp() {
                isTouching = false;
            }
        }));
        viewPager.setCurrentItem(1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             *
             * @param position   索引值
             * @param positionoffset   偏移量 0----1
             * @param positionOffsetPixels  偏移像素值
             */
            @Override
            public void onPageScrolled(int position, float positionoffset, int positionOffsetPixels) {

            }

            /**
             *
             * @param position
             */
            @Override
            public void onPageSelected(int position) {
                currentPosition= position;
                L.d(""+position);
                if(position == dataList.size() -1){
                    currentPosition = 1;
                }else if (position == 0){
                    currentPosition = dataList.size() -2 ;
                }
            }

            /**
             * @param state
             * idle 静止，settling 惯性过程，dragging 拖动过程
             */
            @Override
            public void onPageScrollStateChanged(int state) {
                if(state == ViewPager.SCROLL_STATE_IDLE){
                    viewPager.setCurrentItem(currentPosition,false);
                }

            }
        });

        setTimer();
    }

    private void initData() {
        dataList.add(new News("第四张图片",R.mipmap.ad));
        dataList.add(new News("第一张图片",R.mipmap.aa));
        dataList.add(new News("第二张图片",R.mipmap.ab));
        dataList.add(new News("第三张图片",R.mipmap.ac));
        dataList.add(new News("第四张图片",R.mipmap.ad));
        dataList.add(new News("第一张图片",R.mipmap.aa));
    }

    private void setTimer(){
        Observable.interval(2000,TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        MainActivity.this.disposable = disposable;
                        L.d();
                    }

                    @Override
                    public void onNext(Long aLong) {
                        L.d(""+isTouching);
                        int currentItem = viewPager.getCurrentItem();
                        currentItem++;
//                        if(currentItem==dataList.size()-1){
//                            currentItem=1;
//                        }
                        if(!isTouching){
                            L.d();
                            viewPager.setCurrentItem(currentItem);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        L.d();
                    }

                    @Override
                    public void onComplete() {
                        L.d();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        L.d();
        cancelTimer();
    }
    private void cancelTimer(){
        if(disposable!=null && !disposable.isDisposed()){
            L.d();
            disposable.dispose();
        }
    }
}
