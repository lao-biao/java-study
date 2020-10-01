package com.springboot.pojo;

/**
 * @author 周
 * @title User
 * @date 2020/6/26 22:55
 * @description
 */
public class User {
    private String uname;
    private String gender;
    private int age;

    public User() {
    }

    public User(String uname, String gender, int age) {
        this.uname = uname;
        this.gender = gender;
        this.age = age;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
