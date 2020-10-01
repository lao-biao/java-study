package com.spring5.autowire;

/**
 * @author 周
 * @title Emp
 * @date 2020/6/21 16:44
 * @description
 */
public class Emp {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }

    public void test(){
        System.out.println(dept);
    }
}
