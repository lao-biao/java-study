package com.spring5.bean;

/**
 * @author 周
 * @title Employee
 * @date 2020/6/20 20:42
 * @description 员工类
 */
public class Employee {
    private String name;
    private String gender;
    private Department dep;

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
