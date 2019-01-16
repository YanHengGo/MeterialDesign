package com.yanheng.mycloseto.utils;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

/**
 * ProjectName: CloseTo
 * PackageName: com.liuguilin.closeto.utils
 * User:        LiuGuiLinAndroid
 * Email:       lgl@szokl.com.cn
 * Date:        2017/11/11 22:50
 * Desc:        ...
 */

public class SystemUIUtils {

    public static void showWindowUI(Activity activity) {

        if (VersionUtils.isLollipop()) {
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            //5.0以下
        }
    }
}
