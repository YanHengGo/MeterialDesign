package com.yanheng.mycloseto.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/*
 *  项目名：  CloseTo 
 *  包名：    com.liuguilin.closeto.utils
 *  文件名:   GlideUtils
 *  创建者:   刘某人程序员
 *  创建时间:  2017/6/26 11:12
 *  描述：    Glide封装
 */
public class GlideUtils {

    //标准的加载方式
    public static void loadImageview(Context mContext, String url, ImageView imageView) {
        Glide.with(mContext).load(url).into(imageView);
    }

    //居中的加载方式
    public static void loadImageviewCenterCrop(Context mContext, String url, ImageView imageView) {
        Glide.with(mContext).load(url).centerCrop().into(imageView);
    }

    //加载bitmap
    public static void loadBitmap(Context mContext, String url, final OnSimpleTargetListener targetListener) {
        Glide.with(mContext).load(url).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                targetListener.onResourceReady(resource);
            }
        });
    }

    public interface OnSimpleTargetListener {
        void onResourceReady(Bitmap resource);
    }
}
