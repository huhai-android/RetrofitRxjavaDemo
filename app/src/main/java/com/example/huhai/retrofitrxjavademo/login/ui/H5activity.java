package com.example.huhai.retrofitrxjavademo.login.ui;

import android.os.CountDownTimer;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.huhai.retrofitrxjavademo.R;
import com.example.huhai.retrofitrxjavademo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo.login.ui
 *  @文件名:   H5activity
 *  @创建者:   huhai
 *  @创建时间:  2018/11/13 18:52
 *  @描述：
 */
public class H5activity extends BaseActivity {
    private List<String> url = new ArrayList<>();
    private Random random=new Random();
    @Override
    protected void init() {
        url.add("https://blog.csdn.net/qq_16177199/article/details/84023681");
        url.add("https://blog.csdn.net/qq_16177199/article/details/83651426");
        url.add("https://blog.csdn.net/qq_16177199/article/details/83541133");
        url.add("https://blog.csdn.net/qq_16177199/article/details/79668003");
        url.add("https://blog.csdn.net/qq_16177199/article/details/79668003");
        url.add("https://blog.csdn.net/qq_16177199/article/details/79542086");
        url.add("https://blog.csdn.net/qq_16177199/article/details/79526442");
        url.add("https://blog.csdn.net/qq_16177199/article/details/79138917");

        WebView webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        //设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        webView.loadUrl(url.get(random.nextInt(url.size())));

        webView.setWebViewClient(new WebViewClient());

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_h5;
    }

    @Override
    protected Object createPresenter() {
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        timer.start();
    }

    CountDownTimer timer = new CountDownTimer(5000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {

            int remainTime = (int) (millisUntilFinished / 1000L);
            Log.d("H5activity", "======remainTime=====" + remainTime);
        }

        @Override
        public void onFinish() {
            finish();
        }
    }.start();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        timer = null;
    }
}
