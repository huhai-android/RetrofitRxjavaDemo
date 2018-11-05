package com.example.huhai.retrofitrxjavademo.net;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo.net
 *  @文件名:   InterceptorUtil
 *  @创建者:   EDZ
 *  @创建时间:  2018/11/1 10:46
 *  @描述：
 */
public class InterceptorUtil {
    public static String TAG="InterceptorUtil";
    //日志拦截器
    public static HttpLoggingInterceptor LogInterceptor(){
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.w(TAG, "log: "+message );
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);//设置打印数据的级别
    }

    public static Interceptor HeaderInterceptor(){
        return   new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request mRequest=chain.request();
                //在这里你可以做一些想做的事,比如token失效时,重新获取token
                //或者添加header等等



                return chain.proceed(mRequest);
            }
        };

    }


}
