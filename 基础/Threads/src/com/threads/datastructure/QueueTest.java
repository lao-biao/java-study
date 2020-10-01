package com.threads.datastructure;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author 周
 * @title QueueTest
 * @description 测试Queue的线程性能
 * @date 2020/5/24 9:26
 */
public class QueueTest {
    public static void main(String[] args) throws InterruptedException {

        // 线程不安全
        Deque<String> unsafeQueue = new ArrayDeque<>();
        // 线程安全
        ConcurrentLinkedDeque<String> safeCLDeque = new ConcurrentLinkedDeque<>();
        // 线程安全
        ArrayBlockingQueue<String> safeABQueue = new ArrayBlockingQueue<String>(100);

        QueueThread t1 = new QueueThread(unsafeQueue);
        QueueThread t2 = new QueueThread(safeCLDeque);
        QueueThread t3 = new QueueThread(safeABQueue);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(t1, String.valueOf(i));
            thread.start();
        }
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(t2, String.valueOf(i));
            thread.start();
        }
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(t3, String.valueOf(i));
            thread.start();
        }

        // 等待子线程执行完
        Thread.sleep(2000);

        System.out.println("QueueThread1.queue.size()-->" + t1.queue.size());
        System.out.println("QueueThread2.queue.size()-->" + t2.queue.size());
        System.out.println("QueueThread3.queue.size()-->" + t3.queue.size());

        // 输出queue中的值
        System.out.println("unsafeQueue:");
        for (String s : t1.queue) {
            System.out.print(s + "  ");
        }
        System.out.println();
        System.out.println("safeCLDeque:");
        for (String s : t2.queue) {
            System.out.print(s + "  ");
        }
        System.out.println();
        System.out.println("safeABQueue:");
        for (String s : t3.queue) {
            System.out.print(s + "  ");
        }
    }

}

class QueueThread implements Runnable {

    public Queue<String> queue;

    public QueueThread(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 0;
        while ((i < 10)) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 把当前线程名称加入到queue中
            queue.add(Thread.currentThread().getName());
            i++;
        }

    }
}