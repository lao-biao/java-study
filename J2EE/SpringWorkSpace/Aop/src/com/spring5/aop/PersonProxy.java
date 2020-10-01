package com.spring5.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 周
 * @title PersonProxy
 * @date 2020/6/25 13:56
 * @description
 */
@Aspect // 生成代理对象
@Component
@Order(2)
public class PersonProxy {

    @Before(value = "execution(* com.spring5.aop.User.add(..))")
    public void before() {
        System.out.println("PersonProxy.before");
    }

}
