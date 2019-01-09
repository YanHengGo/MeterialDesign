package com.yanheng.touchevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.d();
        super.dispatchTouchEvent(ev);
        L.d();
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        L.d();
        return true;
    }

}
