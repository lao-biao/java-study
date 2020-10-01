package com.threads.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author 周
 * @title SumTest
 * @description
 * @date 2020/5/23 21:59
 */
public class SumTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建执行线程池
        ForkJoinPool pool = new ForkJoinPool();
        //ForkJoinPool pool = new ForkJoinPool(4);

        // 创建任务
        SumTask task = new SumTask(1, 10000000);

        // 提交任务
        ForkJoinTask<Long> result = pool.submit(task);

        // 等待结果,每隔50ms检查一次
        do {
            System.out.println("Main:Active Thread Count-->" + pool.getActiveThreadCount());
            System.out.println("Main:Parallelism-->" + pool.getParallelism());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        // 输出结果
        System.out.println(result.get().toString());
    }
}
