package com.yanheng.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class RootFragmentLayout extends FrameLayout {
    public RootFragmentLayout( Context context) {
        super(context);
    }

    public RootFragmentLayout( Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public RootFragmentLayout( Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RootFragmentLayout( Context context,  AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.d();
        super.dispatchTouchEvent(ev);
        L.d();
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        L.d();
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        L.d();
        return false;
    }



}
