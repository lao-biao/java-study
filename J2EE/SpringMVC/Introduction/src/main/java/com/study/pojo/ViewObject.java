package com.study.pojo;

import java.util.List;

/**
 * @author 周
 * @title ViewObject
 * @date 2020/6/28 11:32
 * @description
 */
public class ViewObject {
    private List<User> lu;

    public ViewObject(List<User> lu) {
        this.lu = lu;
    }

    public ViewObject() {
    }

    @Override
    public String toString() {
        return "ViewObject{" +
                "lu=" + lu +
                '}';
    }

    public List<User> getLu() {
        return lu;
    }

    public void setLu(List<User> lu) {
        this.lu = lu;
    }
}
