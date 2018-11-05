package com.example.huhai.retrofitrxjavademo.login.ui;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.huhai.retrofitrxjavademo.R;
import com.example.huhai.retrofitrxjavademo.base.BaseActivity;
import com.example.huhai.retrofitrxjavademo.login.contract.LoginContract;
import com.example.huhai.retrofitrxjavademo.login.presenter.LoginPresenter;

public class LoginActivity
        extends BaseActivity<LoginPresenter> implements LoginContract.View {

    private static final String TAG = "LoginActivity";
    private TextView mTextView;
    private TextView mTextLoginStutes;
    private TextView mBtnLogin;
    private TextView mTvDialogStatus;


    @Override
    protected void init() {
        mTextView = findViewById(R.id.tv_text);
        mTextLoginStutes = findViewById(R.id.tv_login_status);
        mBtnLogin = findViewById(R.id.btn_login);
        mTvDialogStatus = findViewById(R.id.tv_dialog_status);
        initlistener();
    }

    private void initlistener() {

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在初始化的时候可以请求网络进行登陆
                //设定两个假的号码，
                String number = "13510680920";
                String password = "123456";
                mPresenter.login(number, password);
            }
        });
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }


    //------------------以下全是跟界面相关的处理逻辑----------------------------------

    @Override
    public void showToast(String msg) {
        Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginStatus(String message) {
        mTextLoginStutes.setText(message);
    }

    @Override
    public void showData(String message) {
        mTextView.setText(message);
    }


    @Override
    public void showDialog() {
        //
        mTvDialogStatus.setText("正在显示dialoig");
    }

    @Override
    public void dismissDialog() {
        mTvDialogStatus.setText("dialog消失");
    }

    @Override
    public void toMainActivity() {
        Toast.makeText(LoginActivity.this,"跳转主界面",Toast.LENGTH_SHORT).show();
    }

    //------------------以上全是跟界面相关的处理逻辑----------------------------------
}
