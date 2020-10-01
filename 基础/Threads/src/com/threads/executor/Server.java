package com.threads.executor;


import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

    //线程池
    private ThreadPoolExecutor executor;

    public Server() {
        //创建默认的线程池
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        //创建指定个数的线程池
        //executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }

    public void submitTask(Task task) {
        System.out.print("Sever: A new task is arrived.\n");
        //执行task
        executor.execute(task);

        System.out.printf("Server: Pool size is %d\n", executor.getPoolSize());
        System.out.printf("Server: Active count is %d\n", executor.getActiveCount());
        System.out.printf("Server: Completed task is %d\n", executor.getCompletedTaskCount());
    }

    public void endServer() {
        //结束服务
        executor.shutdown();
    }
}
