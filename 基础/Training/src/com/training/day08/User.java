package com.training.day08;

import java.sql.Date;

/**
 * @author 周超
 * @title User
 * @date 2020/7/22 20:21
 * @description 实体类对象
 */
public class User {
    private String id;
    private String name;
    private String gender;
    private double salary;
    private Date birthday;

    public User() {
    }

    public User(String id, String name, String gender, double salary, Date birthday) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public java.sql.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
