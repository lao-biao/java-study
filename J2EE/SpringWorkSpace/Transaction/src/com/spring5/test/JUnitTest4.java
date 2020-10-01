package com.spring5.test;

import com.spring5.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 周
 * @title JUnitTest4
 * @date 2020/6/26 10:51
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:transaction.xml")

public class JUnitTest4 {
    @Autowired
    private UserService us;

    @Test
    public void test1() {
        us.accountMoney();
    }
}

