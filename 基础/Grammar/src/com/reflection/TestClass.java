package com.reflection;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 周
 * @title TestClass
 * @description 测试Class的三种获取方式
 * @date 2020/5/31 21:02
 */
public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String s1 = "abc";
        Class c1 = s1.getClass();
        System.out.println(c1.getName());

        Class c2 = Class.forName("java.lang.String");
        System.out.println(c2.getName());

        Class c3 = String.class;
        System.out.println(c3.getName());
    }

    public static Object arrCopy(Object oldArray, int newLength) {
        // Array类型
        Class clazz = oldArray.getClass();
        // 获取数组中的单个元素类型
        Class componentType = clazz.getComponentType();
        // 旧数组长度
        int oldLength = Array.getLength(oldArray);
        // 创建新数组
        Object newArray = Array.newInstance(componentType, newLength);
        // 拷贝旧数据
        System.arraycopy(newArray, 0, oldArray, 0, oldLength);
        return newArray;
    }
}
