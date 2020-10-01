package com.spring5.pojo;

/**
 * @author 周
 * @title User
 * @date 2020/6/25 15:01
 * @description
 */
public class Book {
    private int uid;
    private String uname;
    private String ustatus;

    public Book() {
    }

    public Book(int uid, String uname, String ustatus) {
        this.uid = uid;
        this.uname = uname;
        this.ustatus = ustatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", ustate='" + ustatus + '\'' +
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

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustate) {
        this.ustatus = ustate;
    }
}
