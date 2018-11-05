package com.example.huhai.retrofitrxjavademo.base;

import android.content.Context;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo.base
 *  @文件名:   BaseModel
 *  @创建者:   huhai
 *  @创建时间:  2018/11/5 9:16
 *  @描述：
 */
public class BaseModel<I> {
    protected I mCallback;
    protected Context mContext;

    public BaseModel(Context context) {
        mContext = context;
    }

    @Deprecated
    public BaseModel(I callback) {
        mCallback = callback;
    }

    @Deprecated
    public BaseModel(Context context, I callback) {
        mCallback = callback;
        mContext = context;
    }
}
