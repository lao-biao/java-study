package com.training.day08;

import java.sql.Date;
import java.util.List;

/**
 * @author 周超
 * @title Client
 * @date 2020/7/22 20:20
 * @description 测试UserDao的增删改查
 */
public class Client {
    public static final UserDao userDao = new UserDao();

    public static void main(String[] args) {
        // 测试插入数据
        // testInsert();

        // 测试修改数据
        // testUpdate();

        // 测试删除数据
        // testDelete();

        // 测试查询数据
        testSelectAll();
    }

    private static void testSelectAll() {
        List<User> userList = userDao.selectAll();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    private static void testDelete() {
        int deleteResult = userDao.delete("0002");
        System.out.println("删除数据结果==>" + deleteResult);
    }

    private static void testUpdate() {
        User user = new User("0001", "King", "1", 3000.00, new Date(System.currentTimeMillis()));
        int updateResult = userDao.update(user);
        System.out.println("更新数据结果==>" + updateResult);
    }

    private static void testInsert() {
        User user = new User("0008", "Mary", "0", 5000.00, new Date(System.currentTimeMillis()));
        int insertResult = userDao.insert(user);
        System.out.println("插入数据结果==>" + insertResult);
    }
}
