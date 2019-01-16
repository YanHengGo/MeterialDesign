package com.yanheng.mycloseto.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

/**
 * FileName: MacUtils
 * Founder: LiuGuiLin
 * Create Date: 2018/4/17 13:13
 * Email: lgl@szokl.com.cn
 * Profile:MAC地址
 */
public class MacUtils {

    public static String getMac(Context mContext) {
        WifiManager wifiManager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        String mac = wifiManager.getConnectionInfo().getMacAddress();
        if(!TextUtils.isEmpty(mac)){
            return mac;
        }
        return  "";
    }
}
