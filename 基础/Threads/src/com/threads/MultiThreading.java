package com.threads;

import java.util.concurrent.TimeUnit;

/**
 * 测试守护线程
 */
public class MultiThreading {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main thread is running.");
        ThreadOne threadOne = new ThreadOne();
        //守护线程
        threadOne.setDaemon(true);
        threadOne.start();
        //主线程休眠2秒
        Thread.sleep(2000);
        System.out.println("Main thread is finished.");
    }
}

class ThreadOne extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread one is running.");
            try {
                //休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


