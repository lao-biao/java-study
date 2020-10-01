package com.study.domain;

import java.util.Date;
import java.util.List;


/**
 * @author 周
 * @title User
 * @date 2020/6/29 20:37
 * @description User实体类
 */

public class User {
    private int uid;
    private String uname;
    private String password;
    private Date birthday;

    // private List<Order> orders;

    private List<Role> roles;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                // ", orders=" + orders +
                ", roles=" + roles +
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

    // public List<Order> getOrders() {
    //     return orders;
    // }

    // public void setOrders(List<Order> orders) {
    //     this.orders = orders;
    // }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
