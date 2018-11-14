package com.example.huhai.retrofitrxjavademo.login.ui;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.huhai.retrofitrxjavademo.R;
import com.example.huhai.retrofitrxjavademo.adapter.MyAdapter;
import com.example.huhai.retrofitrxjavademo.base.BaseActivity;
import com.example.huhai.retrofitrxjavademo.bean.blogUrl;
import com.example.huhai.retrofitrxjavademo.manager.Dbhelper;

import java.util.ArrayList;
import java.util.List;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo.login.ui
 *  @文件名:   BolgUrlEditActivity
 *  @创建者:   huhai
 *  @创建时间:  2018/11/14 11:23
 *  @描述：
 */
public class BolgUrlEditActivity extends BaseActivity {
    private static final String TAG = "BolgUrlEditActivity";
    List<blogUrl> data = new ArrayList<>();
    private MyAdapter adapter;
    private Button save;
    private Button clear;
    private EditText editText;
    private ListView listView;

    @Override
    protected void init() {
        listView = findViewById(R.id.list);
        save = findViewById(R.id.save);
        clear = findViewById(R.id.clear);
        editText = findViewById(R.id.et_url);
        adapter = new MyAdapter(data, this);
        listView.setAdapter(adapter);
        initData();
        initlistener();

    }

    private void initlistener() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editText.getText().toString())) {
                    blogUrl blogUrl = new blogUrl();
                    blogUrl.setName(editText.getText().toString());
                    Dbhelper.getDaoSession().getBlogUrlDao().insertOrReplace(blogUrl);
                    initData();
                }

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
    }

    private void initData() {
        data = Dbhelper.getDaoSession().getBlogUrlDao().loadAll();
        Log.d(TAG, data.toString());
        adapter.setdata(data);

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_blog;
    }

    @Override
    protected Object createPresenter() {
        return null;
    }


}
