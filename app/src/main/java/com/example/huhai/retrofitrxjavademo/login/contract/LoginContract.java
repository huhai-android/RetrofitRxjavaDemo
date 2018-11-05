package com.example.huhai.retrofitrxjavademo.login.contract;

import com.example.huhai.retrofitrxjavademo.login.entity.Login;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo.login.contract
 *  @文件名:   LoginContract
 *  @创建者:   huhai
 *  @创建时间:  2018/11/5 9:21
 *  @描述：
 */
public interface LoginContract {
    interface Model {
        /**
         * login的网络请求
         */
        void login(String number, String password);

        //获取验证码



        interface Callback {

            /**
             * 登陆成功
             */
            void onLoginSuccess(Login login);

            /**
             * 登陆失败
             */
            void onLoginFailed(String msg);


            /**
             * 获取验证码成功
             */




            /**
             * 获取验证码失败
             */



        }

    }

    interface View {
        //跟界面展示相关，比如弹出土司，显示dialog等等
        void showToast(String msg);
        //展示登陆状态
        void showLoginStatus(String message);

        //展示登陆数据
        void showData(String message);


        //显示dialog
        void showDialog();

        //隐藏dialog
        void dismissDialog();

        //跳转mainactivity
        void toMainActivity();
    }

    interface Presenter {
        void login(String number, String password);
    }
}
