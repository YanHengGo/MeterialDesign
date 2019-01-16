package com.yanheng.mycloseto.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
 *  项目名：  CloseTo 
 *  包名：    com.liuguilin.closeto.utils
 *  文件名:   ProcessUtils
 *  创建者:   刘某人程序员
 *  创建时间:  2017/5/31 23:13
 *  描述：    进程封装
 */
public class ProcessUtils {

    //获取主进程
    public static String getTopProcess() {
        try {
            File file = new File("/proc/" + android.os.Process.myPid() + "/" + "cmdline");
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String processName = bf.readLine().trim();
            bf.close();
            return processName;
        } catch (Exception e) {
            return null;
        }
    }
}
