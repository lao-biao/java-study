package com.threads;

import java.util.concurrent.TimeUnit;

/**
 * 测试死锁
 */
public class DeadLockThread {
    public static Integer one = 1;
    public static Integer two = 2;

    public static void main(String[] args) throws InterruptedException {
        Thread12 thread12 = new Thread12();
        Thread21 thread21 = new Thread21();
        thread12.start();
        thread21.start();
    }
}

class Thread12 extends Thread {

    @Override
    public void run() {
        //先拿1再拿2
        synchronized (DeadLockThread.one) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLockThread.two) {
                System.out.println("Thread 12 is running");
            }
        }
    }
}

class Thread21 extends Thread {

    @Override
    public void run() {
        //先拿2再拿1
        synchronized (DeadLockThread.two) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLockThread.one) {
                System.out.println("Thread 21 is running");
            }
        }
    }
}