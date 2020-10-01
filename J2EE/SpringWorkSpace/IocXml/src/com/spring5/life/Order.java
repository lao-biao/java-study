package com.spring5.life;

/**
 * @author 周
 * @title Order
 * @date 2020/6/21 15:44
 * @description
 */
public class Order {
    private String name;

    public Order() {
        System.out.println("Order.Order");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Order.setName");
    }

    public void initMethod(){
        System.out.println("Order.initMethod");
    }

    public void destroyMethod(){
        System.out.println("Order.destroyMethod");
    }
}
