package com.example.huhai.retrofitrxjavademo.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo
 *  @文件名:   BaseActivity
 *  @创建者:   huhai
 *  @创建时间:  2018/11/1 11:02
 *  @描述：
 */
public abstract class BaseActivity<P> extends FragmentActivity {
    protected P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        mPresenter = createPresenter();
        init();
    }

    protected abstract void init();

    @LayoutRes
    protected abstract int bindLayoutId();

    protected abstract P createPresenter();

    public <T> ObservableTransformer<T,T> setThread(){
        return new ObservableTransformer<T,T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}


