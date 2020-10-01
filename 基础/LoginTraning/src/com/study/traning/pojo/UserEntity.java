package com.study.traning.pojo;

/**
 * @author 周超
 * @title UserEntity
 * @date 2020/7/24 15:48
 * @description 用户实体类
 */

public class UserEntity {

    private String username;
    private String password;

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
