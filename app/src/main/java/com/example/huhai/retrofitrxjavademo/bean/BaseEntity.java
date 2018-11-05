package com.example.huhai.retrofitrxjavademo.bean;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo.bean
 *  @文件名:   BaseEntity
 *  @创建者:   huhai
 *  @创建时间:  2018/11/1 10:53
 *  @描述：
 */
public class BaseEntity<T> {


    /**
     * code : 1001
     * msg : 账号或密码错误
     * data : {"deviceId":1001,"token":"账号或密码错误"}
     */

    private static int SUCCESS_CODE=0;//成功的code
    private int code;
    private String msg;
    private T data;


    public boolean isSuccess(){
        return getCode()==SUCCESS_CODE;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "BaseEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}


