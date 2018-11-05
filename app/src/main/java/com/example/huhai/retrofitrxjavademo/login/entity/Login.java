package com.example.huhai.retrofitrxjavademo.login.entity;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo.bean
 *  @文件名:   Login
 *  @创建者:   huhai
 *  @创建时间:  2018/11/1 10:53
 *  @描述：
 */
public class Login {
    private String deviceId;
    private String token;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Login{" +
                "deviceId='" + deviceId + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
