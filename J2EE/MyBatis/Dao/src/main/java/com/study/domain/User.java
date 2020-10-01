package com.study.domain;

/**
 * @author 周
 * @title User
 * @date 2020/6/28 22:30
 * @description
 */
public class User {
    private int uid;
    private String uname;
    private String password;

    public User() {
    }

    public User(int uid, String uname, String password) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
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
}
