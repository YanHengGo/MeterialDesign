package com.yanheng.fragmentdemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;

import com.yanheng.fragmentdemo.adapter.MypagerAdapter;
import com.yanheng.fragmentdemo.util.L;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    ArrayList<View> viewlist = new ArrayList<>();
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = ((ViewPager) findViewById(R.id.viewpager));
        initView();
        viewPager.setAdapter(new MypagerAdapter(viewlist));
        setTimer();
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
                        L.d();
                        int currentItem = viewPager.getCurrentItem();
                        currentItem++;
                        if(currentItem==viewlist.size()){
                            currentItem=0;
                        }
                        viewPager.setCurrentItem(currentItem);
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
        if(disposable!=null && !disposable.isDisposed()){
            L.d();
            disposable.dispose();
        }
    }
}
