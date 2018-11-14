package com.example.huhai.retrofitrxjavademo.manager;

import com.example.huhai.retrofitrxjavademo.MyApplication;
import com.example.huhai.retrofitrxjavademo.greendao.DaoMaster;
import com.example.huhai.retrofitrxjavademo.greendao.DaoSession;
import com.example.huhai.retrofitrxjavademo.greendao.PersonDao;
import com.example.huhai.retrofitrxjavademo.greendao.blogUrlDao;

import org.greenrobot.greendao.query.QueryBuilder;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo.manager
 *  @文件名:   Dbhelper
 *  @创建者:   huhai
 *  @创建时间:  2018/11/14 9:41
 *  @描述：
 */
public class Dbhelper {

    private static final String TAG = "Dbhelper";
    private static DaoSession daoSession;
    private static PersonDao personDao;
    private static blogUrlDao urlDao;

    public static void initGreenDao(){

        //初始化GreenDao
        //创建数据库，参数1：上下文，参数2：库名，参数3：游标工厂
        DaoMaster.DevOpenHelper devOpenHelper=new DaoMaster.DevOpenHelper(MyApplication.getContext(),"huhai.db",null);
        //实例化DaoMaster对象
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        //实例化DaoSession对象
        daoSession=daoMaster.newSession();
        QueryBuilder.LOG_SQL=true;
        QueryBuilder.LOG_VALUES=true;

        
    }

    public static DaoSession  getDaoSession(){
        return daoSession;
    }

    
}
