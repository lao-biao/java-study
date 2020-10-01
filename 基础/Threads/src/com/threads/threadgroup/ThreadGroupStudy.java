package com.threads.threadgroup;

import java.util.concurrent.TimeUnit;

/**
 * 使用线程组管理多个线程
 */
public class ThreadGroupStudy {
    public static void main(String[] args) {
        //创建线程组
        ThreadGroup threadGroup = new ThreadGroup("Search");
        Result result = new Result();
        //创建线程任务
        Searcher searchTask = new Searcher(result);
        for (int i = 0; i < 10; i++) {
            //以searchTask为模板创建线程
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("----------分割线----------");
        //查看线程组消息
        System.out.printf("active count:%d\n", threadGroup.activeCount());
        System.out.println("线程组信息明细");
        //打印线程组的所有信息
        threadGroup.list();
        System.out.println("----------分割线----------");
        //遍历线程组
        Thread[] threads = new Thread[threadGroup.activeCount()];
        //将线程组中active线程拷贝到数组中
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }
        System.out.println("----------分割线----------");

        //等待活动线程数小于10
        waitFinish(threadGroup);
        //线程组发出中断命令
        threadGroup.interrupt();
    }

    public static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount()>9){
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
