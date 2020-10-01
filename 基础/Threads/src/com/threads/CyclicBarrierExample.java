package com.threads;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 周
 * @title CyclicBarrierExample
 * @description
 * @date 2020/5/24 10:27
 */
public class CyclicBarrierExample {
    /**
     * 三个一维向量用三个线程分别求和，最后计算总和
     *
     * @param args
     */
    public static void main(String[] args) {
        final int[][] numbers = new int[3][5];
        final int[] results = new int[3];
        int[] row1 = {1, 2, 3, 4, 5};
        int[] row2 = {6, 7, 8, 9, 10};
        int[] row3 = {11, 12, 13, 14, 15};
        numbers[0] = row1;
        numbers[1] = row2;
        numbers[2] = row3;

        CalculateFinalResult finalResultCalculator = new CalculateFinalResult(results);
        CyclicBarrier barrier = new CyclicBarrier(3, finalResultCalculator);

        // 当有3个线程在barrier上await时，就执行finalResultCalculator

        for (int i = 0; i < 3; i++) {
            CalculateEachRow rowCalculator = new CalculateEachRow(numbers, i, results, barrier);
            new Thread(rowCalculator).start();
        }

    }
}

class CalculateEachRow implements Runnable {

    final int[][] numbers;
    final int rowNumbers;
    final int[] res;
    final CyclicBarrier barrier;

    public CalculateEachRow(int[][] numbers, int rowNumbers, int[] res, CyclicBarrier barrier) {
        this.numbers = numbers;
        this.rowNumbers = rowNumbers;
        this.res = res;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        int[] row = numbers[rowNumbers];
        int sum = 0;
        for (int datum : row) {
            sum += datum;
            res[rowNumbers] = sum;
        }
        try {
            System.out.println(Thread.currentThread().getName() + ":计算第" + (rowNumbers + 1) + "行结束，结果为-->" + sum);
            barrier.await(); // 等待，只要超过3个，就放行
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class CalculateFinalResult implements Runnable {

    final int[] eachRowRes;
    int finalRes;

    public CalculateFinalResult(int[] eachRowRes) {
        this.eachRowRes = eachRowRes;
    }

    public int getFinalRes() {
        return finalRes;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int datum : eachRowRes) {
            sum += datum;
        }
        finalRes = sum;
        System.out.println("最终结果为-->" + finalRes);
    }
}