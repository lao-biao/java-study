package com.pojo;

/**
 * @author 周
 * @title User
 * @date 2020/6/18 20:58
 * @description
 */
public class User {
    private int uid;
    private String uname;
    private String fav;
    private Address addr;

    public User() {

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

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", fav='" + fav + '\'' +
                ", addr=" + addr +
                '}';
    }

    public User(int uid, String uname, String fav, Address addr) {
        this.uid = uid;
        this.uname = uname;
        this.fav = fav;
        this.addr = addr;
    }
}
