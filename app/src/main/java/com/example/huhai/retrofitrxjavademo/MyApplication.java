package com.example.huhai.retrofitrxjavademo;

import android.app.Application;
import android.content.Context;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo
 *  @文件名:   MyApplication
 *  @创建者:   huhai
 *  @创建时间:  2018/11/1 9:42
 *  @描述：
 */
public class MyApplication extends Application {
    public static Context mContext;
    /**
     * 得到上下文
     */
    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
    }
}
