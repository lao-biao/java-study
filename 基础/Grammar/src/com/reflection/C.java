package com.reflection;

import java.io.Serializable;

public class C implements Serializable {
    private static final long serialVersionUID = 1L;  // 序列化id


    public void hello() {
        System.out.println("Hello from C.");
    }
}