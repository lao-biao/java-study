package com.spring5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 周
 * @title Stu
 * @date 2020/6/20 21:25
 * @description 数组、list、map、set属性的配置
 */
public class Stu {
    // 数组类型属性
    private String[] array;
    // List列表类型属性
    private List<String> list;
    // Map集合类型属性
    private Map<String, String> map;
    // Set集合类型属性
    private Set<String> set;
    // list-->course
    private List<Course> courseList;

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void test() {
        System.out.println(Arrays.toString(array));
        System.out.println(list.toString());
        System.out.println(map.toString());
        System.out.println(set.toString());
        System.out.println(courseList.toString());
    }
}

