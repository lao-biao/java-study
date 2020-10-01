package com.study.domain;

import java.util.Date;

/**
 * @author 周
 * @title User
 * @date 2020/6/29 14:39
 * @description User实体类
 */
public class User {
    private int uid;
    private String uname;
    private String password;
    private Date birthday;

    public User() {
    }

    public User(int uid, String uname, String password, Date birthday) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
