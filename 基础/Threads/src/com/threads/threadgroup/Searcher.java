package com.threads.threadgroup;

import com.threads.threadgroup.Result;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Searcher implements Runnable {
    private Result result;

    public Searcher(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("Thread %s start\n", threadName);
        try {
            doTask();
            result.setName(threadName);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s is interrupted\n", threadName);
            return;
        }
        System.out.printf("Thread %s finished.\n", threadName);
    }

    private void doTask() throws InterruptedException {
        Random random = new Random(new Date().getTime());
        int value = (int) (random.nextDouble() * 100);
        System.out.printf("Thread %s : %d\n", Thread.currentThread().getName(), value);
        TimeUnit.SECONDS.sleep(value);
    }

}
