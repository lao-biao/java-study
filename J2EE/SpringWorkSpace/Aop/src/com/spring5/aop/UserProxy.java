package com.spring5.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 周
 * @title UserProxy
 * @date 2020/6/21 22:01
 * @description 增强类
 */
@Aspect // 生成代理对象
@Component
@Order(1)
public class UserProxy {

    // 相同切入点抽取
    @Pointcut(value = "execution(* com.spring5.aop.User.add(..))")
    public void pointCut(){

    }

    // 前置通知
    @Before("pointCut()")
    public void before() {
        System.out.println("UserProxy.before");
    }

    // 最终通知
    @After("pointCut()")
    public void after() {
        System.out.println("UserProxy.after");
    }
    // 返回通知/后置通知
    @AfterReturning("pointCut()")
    public void afterRunning() {
        System.out.println("UserProxy.afterRunning");
    }

    // 异常通知
    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("UserProxy.afterThrowing");
    }

    // 环绕通知
    @Around("pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("UserProxy.around--before");
        proceedingJoinPoint.proceed();
        System.out.println("UserProxy.around--after");

    }
}
