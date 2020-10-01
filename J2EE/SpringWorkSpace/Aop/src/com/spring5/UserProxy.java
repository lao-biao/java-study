package com.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author 周
 * @title UserProxy
 * @date 2020/6/21 20:08
 * @description JDK动态代理--Proxy
 */
public class UserProxy {
    public static void main(String[] args) {
        // 创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        // 使用匿名内部类
        // Proxy.newProxyInstance(UserProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
        //     @Override
        //     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //         return null;
        //     }
        // });
        UserDao udi = new UserDaoImpl();
        UserDao ud = (UserDao) Proxy.newProxyInstance(UserProxy.class.getClassLoader(), interfaces, new UserDaoProxy(udi));
        int res = ud.add(1, 2);
        System.out.println(res);
    }
}

class UserDaoProxy implements InvocationHandler {


    private Object object;

    public UserDaoProxy(Object object) {
        this.object = object;
    }

    // 增强的逻辑代码
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法之前
        System.out.println("方法之前执行-->" + method.getName() + "-->参数:" + Arrays.toString(args));

        // 被增强的方法执行
        Object res = method.invoke(object, args);
        // 方法之后
        System.out.println("方法之后执行-->" + object);
        return res;
    }
}
