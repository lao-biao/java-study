package com.spring5;

/**
 * @author 周
 * @title Order
 * @date 2020/6/20 19:45
 * @description 通过有参构造方法注入属性
 */
public class Order {
    private String name;
    private String address;

    public Order(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void test(){
        System.out.println("name:"+name+"\naddress:"+address);
    }

}
