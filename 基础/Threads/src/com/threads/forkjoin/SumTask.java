package com.threads.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author 周
 * @title SumTask
 * @description
 * @date 2020/5/23 21:59
 */
public class SumTask extends RecursiveTask<Long> {

    private int start;
    private int end;

    public static final int threadHold = 5; // 求和最小个数

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long sum = 0L;

        // 如果任务足够小就直接执行
        boolean canCompute = (end - start) <= threadHold;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 任务大于阀值，分为2个任务
            int middle = start + (end - start) / 2;
            SumTask sumTaskLeft = new SumTask(start, middle);
            SumTask sumTaskRight = new SumTask(middle + 1, end);

            invokeAll(sumTaskLeft, sumTaskRight);

            Long sumLeft = sumTaskLeft.join();
            Long sumRight = sumTaskRight.join();

            // 合并结果
            sum = sumLeft + sumRight;
        }
        return sum;
    }
}
