package com.spring5.test;

import com.spring5.service.UserService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author 周
 * @title JUnitTest5
 * @date 2020/6/26 10:53
 * @description 整合JUnit5
 * import org.junit.jupiter.api.Test;
 */
// @ExtendWith(SpringExtension.class)
// @ContextConfiguration("classpath:transaction.xml")
@SpringJUnitConfig(locations = "classpath:transaction.xml") // 使用复合注解
public class JUnitTest5 {
    @Autowired
    private UserService us;

    @Test
    public void test1() {
        us.accountMoney();
    }
}
