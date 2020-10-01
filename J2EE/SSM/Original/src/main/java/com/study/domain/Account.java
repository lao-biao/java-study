package com.study.domain;

/**
 * @author 周
 * @title Account
 * @date 2020/6/30 10:19
 * @description 实体库
 */
public class Account {
    private Integer uid;
    private String uname;
    private double money;

    @Override
    public String toString() {
        return "Account{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", money=" + money +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
