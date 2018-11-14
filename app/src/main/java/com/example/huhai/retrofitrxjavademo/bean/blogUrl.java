package com.example.huhai.retrofitrxjavademo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo.bean
 *  @文件名:   blogUrl
 *  @创建者:   huhai
 *  @创建时间:  2018/11/14 9:37
 *  @描述：
 */
@Entity
public class blogUrl {

    @Id
    private Long id;
    @Unique
    private String name;

    @Generated(hash = 2015312800)
    public blogUrl(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 963357834)
    public blogUrl() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "blogUrl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
