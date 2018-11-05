package com.example.huhai.retrofitrxjavademo.login.model;

import com.example.huhai.retrofitrxjavademo.base.BaseModel;
import com.example.huhai.retrofitrxjavademo.bean.BaseEntity;
import com.example.huhai.retrofitrxjavademo.login.contract.LoginContract;
import com.example.huhai.retrofitrxjavademo.login.entity.Login;
import com.example.huhai.retrofitrxjavademo.net.BaseObserver;
import com.example.huhai.retrofitrxjavademo.net.RetrofitFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo.login.model
 *  @文件名:   LoginModel
 *  @创建者:   huhai
 *  @创建时间:  2018/11/5 9:23
 *  @描述：
 */
public class LoginModel extends BaseModel<LoginContract.Model.Callback> implements LoginContract.Model {

    public LoginModel(Callback callback) {
        super(callback);
    }


    @Override
    public void login(String number, String password) {
        RetrofitFactory.getInstence().creatService()
                .login(number, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Login>() {
                    @Override
                    protected void onSuccees(BaseEntity<Login> t) throws Exception {
                        mCallback.onLoginSuccess(t.getData());
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        mCallback.onLoginFailed(e.toString());
                    }
                });
    }
}
