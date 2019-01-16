package com.yanheng.mycloseto.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * FileName: CacheSizeUtils
 * Founder: LiuGuiLin
 * Create Date: 2018/5/19 16:50
 * Email: lgl@szokl.com.cn
 * Profile:获取缓存大小
 */
public class CacheSizeUtils {

    //获取缓存大小
    public static String getCacheSize(Context mContext){
        long cacheSize = getFileSize(mContext.getCacheDir());
        if(Environment.getExternalStorageDirectory().equals(Environment.MEDIA_MOUNTED)){
            cacheSize += getFileSize(mContext.getExternalCacheDir());
        }
        return FormatUtils.formatSize(cacheSize);
    }

    //清理缓存
    public static void clearAllCache(Context mContext){
        deleteFile(mContext.getCacheDir());
        if(Environment.getExternalStorageDirectory().equals(Environment.MEDIA_MOUNTED)){
            deleteFile(mContext.getExternalCacheDir());
        }
    }

    //获取文件大小
    public static long getFileSize(File file){
        long size = 0;
        File[] fileList = file.listFiles();
        if(fileList != null && fileList.length > 0){
            for (int i = 0; i < fileList.length; i++) {
                //如果下面有文件夹
                if(fileList[i].isDirectory()){
                    //递归
                    size = size + getFileSize(fileList[i]);
                }else {
                    size = size  + fileList[i].length();
                }
            }
        }
        return size;
    }

    //删除指定文件
    public static boolean deleteFile(File dir){
        if(dir != null && dir.isDirectory()){
            String[] children = dir.list();
            int size = 0;
            if(children != null && children.length >0 ){
                for (int i = 0; i < children.length; i++) {
                    boolean isOk = deleteFile(new File(dir,children[i]));
                    if(!isOk){
                        return  false;
                    }
                }
            }
        }
        //是文件
        if(dir == null){
            return true;
        }else {
            return dir.delete();
        }
    }
}
