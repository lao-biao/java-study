package com.study.domain;

import java.util.Date;

/**
 * @author 周
 * @title Order
 * @date 2020/6/29 16:07
 * @description Order订单实体类
 */
public class Order {
    private int oid;
    private Date orderTime;
    private double total;
    // 当前订单属于哪一个用户
    private User user;

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", orderTime=" + orderTime +
                ", total=" + total +
                ", user=" + user +
                '}';
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
