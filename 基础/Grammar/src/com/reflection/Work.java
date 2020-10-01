package com.reflection;

import java.lang.reflect.Method;
import java.util.TimerTask;

class Work{
    public static void hello(){
        System.out.println("Hello World!");
    }
}
class MyTask extends TimerTask {
    public void run(){
        try{
            Method m= Class.forName("com.reflection.Work").getMethod("hello");
            m.invoke(null);	// 静态方法可以不用new对象
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}