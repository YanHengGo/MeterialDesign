package com.yanheng.mycloseto.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.view.WindowManager;

import static android.content.Context.WINDOW_SERVICE;

/*
 *  项目名：  CloseTo 
 *  包名：    com.liuguilin.closeto.utils
 *  文件名:   ScreenUtils
 *  创建者:   刘某人程序员
 *  创建时间:  2017/5/31 22:07
 *  描述：    屏幕封装
 */
public class ScreenUtils {

    public static int width;
    public static int height;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void init(Context mContext) {
        WindowManager wm = (WindowManager) mContext.getSystemService(WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point point = new Point();
        if (VersionUtils.isJELLY_BEAN_MR1()) {
            display.getRealSize(point);
        } else {
            display.getSize(point);
        }
        width = point.x;
        height = point.y;
    }
}
