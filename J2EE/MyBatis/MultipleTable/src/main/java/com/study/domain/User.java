package com.study.domain;

import java.util.Date;
import java.util.List;

/**
 * @author 周
 * @title User
 * @date 2020/6/29 16:04
 * @description User实体类
 */
public class User {
    private int uid;
    private String uname;
    private String password;
    private Date birthday;

    // 订单
    private List<Order> order;

    // 用户的角色
    private List<Role> role;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                // ", order=" + order +
                ", role=" + role +
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

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
