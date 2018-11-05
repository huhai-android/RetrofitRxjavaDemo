package com.example.huhai.retrofitrxjavademo.login.presenter;

import com.example.huhai.retrofitrxjavademo.base.BasePresenter;
import com.example.huhai.retrofitrxjavademo.login.contract.LoginContract;
import com.example.huhai.retrofitrxjavademo.login.entity.Login;
import com.example.huhai.retrofitrxjavademo.login.model.LoginModel;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo.login.presenter
 *  @文件名:   LoginPresenter
 *  @创建者:   huhai
 *  @创建时间:  2018/11/5 9:20
 *  @描述：
 */
public class LoginPresenter extends BasePresenter<LoginContract.View, LoginModel> implements LoginContract.Presenter, LoginContract.Model.Callback {
    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    protected LoginModel createModel() {
        return new LoginModel(this);
    }


    //具体的逻辑，在model中去完成，model中主要是获取数据  ，presenter中主要的逻辑转换，比如出来i请求网络，处理回掉，处理界面显示等等
    @Override
    public void login(String number, String password) {
        mView.showDialog();
        mModel.login(number,password);
    }



    //接口数据请求回掉
    @Override
    public void onLoginSuccess(Login login) {
        mView.showToast(login.toString());
        mView.showLoginStatus("login success");
        mView.showData(login.toString());
        mView.dismissDialog();
        mView.toMainActivity();
    }

    @Override
    public void onLoginFailed(String msg) {
        mView.showToast(msg);
        mView.showLoginStatus("login failed");
        mView.dismissDialog();
    }

}
