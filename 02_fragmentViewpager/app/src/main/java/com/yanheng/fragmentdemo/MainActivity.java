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

        setTimer();
    }

    private void initData() {
        dataList.add(new News("第一张图片",R.mipmap.aa));
        dataList.add(new News("第二张图片",R.mipmap.ab));
        dataList.add(new News("第三张图片",R.mipmap.ac));
        dataList.add(new News("第四张图片",R.mipmap.ad));
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
                        if(currentItem==dataList.size()){
                            currentItem=0;
                        }
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
