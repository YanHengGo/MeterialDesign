package com.yanheng.mycloseto.utils;


import java.math.BigDecimal;

/**
 * FileName: FormatUtils
 * Founder: LiuGuiLin
 * Create Date: 2018/4/17 13:27
 * Email: lgl@szokl.com.cn
 * Profile: 格式化
 */
public class FormatUtils {

    public static String formatSize(long size){
        LogUtils.d("size:" + size);
        double kilo = size/ 1024;
        LogUtils.d(" kilo size:" + kilo);
        if(kilo < 1){
            return size + "B";
        }
        double megaByte = kilo / 1024 ;
        LogUtils.d(" megaByte size:" + megaByte);
        if(megaByte < 1){
            BigDecimal bgByte1 = new BigDecimal(Double.toString(kilo));
            return  bgByte1.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }
        double gigaM = megaByte / 1024 ;
        LogUtils.d(" gigaM size:" + gigaM);
        if(megaByte < 1){
            BigDecimal bgByte2 = new BigDecimal(Double.toString(megaByte));
            return  bgByte2.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }

        double tear = gigaM / 1024 ;
        LogUtils.d(" tear size:" + tear);
        BigDecimal bgByte3 = new BigDecimal(Double.toString(gigaM));
        return bgByte3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
    }
}
