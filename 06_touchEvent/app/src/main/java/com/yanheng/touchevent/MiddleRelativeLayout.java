package com.yanheng.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class MiddleRelativeLayout extends RelativeLayout {
    public MiddleRelativeLayout(Context context) {
        super(context);
    }

    public MiddleRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MiddleRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MiddleRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        L.d();
        return true;
    }

}
