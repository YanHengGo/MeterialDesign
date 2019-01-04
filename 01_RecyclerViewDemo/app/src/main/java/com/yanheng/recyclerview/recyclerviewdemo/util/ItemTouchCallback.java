package com.yanheng.recyclerview.recyclerviewdemo.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.yanheng.recyclerview.recyclerviewdemo.listener.ItemTouchListener;
import com.yanheng.recyclerview.recyclerviewdemo.util.L;

public class ItemTouchCallback extends ItemTouchHelper.Callback {

    private final ItemTouchListener itemTouchListener;

    public ItemTouchCallback(ItemTouchListener itemTouchListener) {
        this.itemTouchListener = itemTouchListener;
    }

    /**
     * 拖动和删除的类型
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
//        int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int swipedFlag = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlag,swipedFlag);
    }

    /**
     *
     * @param recyclerView
     * @param viewHolder      拖动之前的容器
     * @param target     拖动之后的容器
     * @return
     */
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        int oldPosition = viewHolder.getAdapterPosition();
        int newPosition = target.getAdapterPosition();
        itemTouchListener.onMove(oldPosition,newPosition);
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        L.d(String.valueOf(position));
        itemTouchListener.onSwiped(viewHolder.getAdapterPosition());
    }
}
