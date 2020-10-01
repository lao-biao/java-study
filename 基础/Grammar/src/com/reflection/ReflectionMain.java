package com.reflection;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 周
 * @title ReflectionMain
 * @description
 * @date 2020/5/31 19:57
 */
public class ReflectionMain {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 第一种，直接new
        // A obj1 = new A();
        // obj1.hello();

        // 第二种，克隆
        B obj2 = new B();
        obj2.hello();

        B obj3 = (B) obj2.clone();
        obj3.hello();

        // 第三种，序列化与反序列化
        C obj4 = new C();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
        out.writeObject(obj4);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
        C obj5 = (C) in.readObject();
        in.close();
        obj5.hello();

        // 第四种

        Object obj6 = Class.forName("com.reflection.A").newInstance();
        // A obj7 = (A) Class.forName("A").newInstance();
        Method m = Class.forName("com.reflection.A").getMethod("hello");
        m.invoke(obj6);


        // 第五种
        Constructor<A> constructor = A.class.getConstructor();
        A obj8 = constructor.newInstance();
        obj8.hello();
    }
}

