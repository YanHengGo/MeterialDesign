package com.yanheng.recyclerview.recyclerviewdemo.listener;

public interface ItemTouchListener {
    void onMove(int oldPosition , int newPosition);
    void onSwiped(int position);
}
