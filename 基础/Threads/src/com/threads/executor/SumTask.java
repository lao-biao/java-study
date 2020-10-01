package com.threads.executor;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author 周
 * @title SumTask
 * @description 线程Callable回调结果
 * @date 2020/5/23 21:20
 */
public class SumTask implements Callable<Integer> {

    // 定义每个线程计算的区间
    private int startNumber;
    private int endNumber;

    public SumTask(int startNumber, int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = startNumber; i <=endNumber; i++) {
            sum += i;
        }
        Thread.sleep(new Random().nextInt(1000));   // 休眠一段时间

        System.out.printf("%s:%d\n", Thread.currentThread().getName(), sum);

        return sum;
    }
}
