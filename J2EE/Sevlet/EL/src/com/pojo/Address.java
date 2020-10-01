package com.pojo;

/**
 * @author 周
 * @title Address
 * @date 2020/6/18 21:00
 * @description
 */
public class Address {
    private String pre;
    private String city;
    private String town;

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Address(String pre, String city, String town) {
        this.pre = pre;
        this.city = city;
        this.town = town;
    }
}
