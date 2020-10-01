package com.threads.executor;

import javax.xml.crypto.Data;
import java.util.Date;

public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            long duration = (long) (Math.random() * 1000);
            System.out.printf("Thread %s:doing a task during %d seconds\n", Thread.currentThread().getName(), duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread %s is finished on %s.\n", Thread.currentThread().getName(), new Date());
    }
}
