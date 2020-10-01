package com.spring5.service;

import com.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 周
 * @title UserService
 * @date 2020/6/21 18:04
 * @description Spring基于注解创建对象
 * value默认为类名首字母小写
 */

// @Component(value = "userService")  // 等价于<bean id="service" class="com.spring5.service.UserService">
@Service(value = "userService")
public class UserService {
    /*
        @Autowired
        @Qualifier(value = "userDaoImpl")   // 根据名称进行注入
        private UserDao userDao;
    */
    // @Resource   // 根据类型注入

    @Resource(name = "userDaoImpl") // 根据名称注入
    private UserDao userDao;

    @Value(value = "Spring")
    private String name;

    public void add() {
        System.out.println("UserService.add");
        System.out.println(name);
        userDao.add();
    }
}
