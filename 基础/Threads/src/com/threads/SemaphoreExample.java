package com.threads;

import java.util.concurrent.Semaphore;

/**
 * @author 周
 * @title SemaphoreExample
 * @description
 * @date 2020/5/24 10:14
 */
public class SemaphoreExample {

    // 信号量，车位数为5
    private final Semaphore placeSemaphore = new Semaphore(5);

    /**
     * 5个车位，10辆车需要停放，每次停放时，去申请信号量
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        int tryToParkCnt = 10;
        SemaphoreExample semaphoreExample = new SemaphoreExample();
        Thread[] parker = new Thread[tryToParkCnt];

        for (int i = 0; i < tryToParkCnt; i++) {
            parker[i] = new Thread(() -> {
                try {
                    long randomTime = (long) (Math.random() * 1000);
                    Thread.sleep(randomTime);
                    if (semaphoreExample.parking()) {
                        long parkingTime = (long) (Math.random() * 1200);
                        Thread.sleep(parkingTime);
                        semaphoreExample.leaving();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            parker[i].start();
        }

        for (int i = 0; i < tryToParkCnt; i++) {
            parker[i].join();
        }

    }

    public boolean parking() {
        if (placeSemaphore.tryAcquire()) {
            System.out.println(Thread.currentThread().getName() + ":停车成功");
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + ":没有空位");
            return false;
        }
    }

    public void leaving() {
        placeSemaphore.release();
        System.out.println(Thread.currentThread().getName() + ":离开");
    }
}
