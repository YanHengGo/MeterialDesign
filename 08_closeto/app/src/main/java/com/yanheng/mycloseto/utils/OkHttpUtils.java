package com.yanheng.mycloseto.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/*
 *  项目名：  CloseTo 
 *  包名：    com.liuguilin.closeto.utils
 *  文件名:   OkHttpUtils
 *  创建者:   刘某人程序员
 *  创建时间:  2017/6/25 00:04
 *  描述：    OkHttp封装
 *
 *  *- get
 *  - post json
 *  - post map
 *  *- download
 */
public class OkHttpUtils {

    private static android.os.Handler mHandler = new android.os.Handler();
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static void get(String url, final OnOkHttpCallback callback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        //异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String json = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccessful(json);
                        }
                    });
                } else {
                    callback.onFailure("response not isSuccessful");
                }
            }
        });
    }

    public static void postJson(String url, String json, final OnOkHttpCallback callback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String json = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccessful(json);
                        }
                    });
                } else {
                    callback.onFailure("response not isSuccessful");
                }
            }
        });
    }

    public static void postMap(String url, Map<String, String> params, final OnOkHttpCallback callback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder form = new FormBody.Builder();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                form.add(entry.getKey(), entry.getValue());
            }
        }
        RequestBody body = form.build();
        Request request = new Request.Builder().url(url).post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String json = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccessful(json);
                        }
                    });
                } else {
                    callback.onFailure("response not isSuccessful");
                }
            }
        });
    }

    public static void download(final String path, String url
            , final OnOkHttpCallback callback
            , final OnProgressResponseListener responseListener) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        //异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    InputStream is = response.body().byteStream();
                    //总长度
                    long total = response.body().contentLength();
                    //路径
                    File file = new File(path);
                    try {
                        FileOutputStream fos = new FileOutputStream(file);
                        byte[] buf = new byte[2048];
                        //记录下载的进度
                        int sum = 0;
                        int len = 0;
                        while ((len = is.read(buf)) != -1) {
                            fos.write(buf, 0000, len);
                            sum += len;
                            int progress = (int) (sum * 1.0f / total * 100);
                            responseListener.OnProgressResponse(progress,total);
                        }
                        fos.flush();
                        fos.close();
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.onSuccessful("done");
                            }
                        });
                    } catch (final IOException e) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.onFailure(e);
                            }
                        });
                    }

                } else {
                    callback.onFailure("response not isSuccessful");
                }
            }
        });
    }

    public interface OnProgressResponseListener {

        void OnProgressResponse(int progress, long total);
    }

    public interface OnOkHttpCallback {
        //失败
        void onFailure(IOException e);

        //请求成功，但是没有结果
        void onFailure(String msg);

        //成功
        void onSuccessful(String json);
    }
}
