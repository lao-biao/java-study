package com.pojo;

/**
 * @author 周
 * @title User
 * @date 2020/6/18 16:31
 * @description
 */
public class User {
    private int uid;
    private String uname;
    private double price;
    private String location;
    private String description;

    public User() {
        this.uid = uid;
        this.uname = uname;
        this.price = price;
        this.location = location;
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
