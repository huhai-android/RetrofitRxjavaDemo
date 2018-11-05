package com.example.huhai.retrofitrxjavademo.base;

import android.content.Context;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo.base
 *  @文件名:   BasePresenter
 *  @创建者:   huhai
 *  @创建时间:  2018/11/5 9:13
 *  @描述：
 */
public abstract class BasePresenter<V, M> {
    protected V mView;
    protected M mModel;
    protected Context mContext;

    @Deprecated
    public BasePresenter(V view) {
        mView = view;
        mModel = createModel();
    }

    protected abstract M createModel();

    public BasePresenter(Context context, V view) {
        mContext = context;
        mView = view;
        mModel = createModel();
    }

}
