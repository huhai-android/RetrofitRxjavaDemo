package com.example.huhai.retrofitrxjavademo.net;

import com.example.huhai.retrofitrxjavademo.bean.BaseEntity;
import com.example.huhai.retrofitrxjavademo.login.entity.Login;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo.net
 *  @文件名:   NetServices
 *  @创建者:   EDZ
 *  @创建时间:  2018/11/1 10:48
 *  @描述：
 */
public interface NetServices {

    @POST("/login/submit")
    Observable<BaseEntity<Login>> login(@Query("phone") String phone,
                                        @Query("password") String password);
}
