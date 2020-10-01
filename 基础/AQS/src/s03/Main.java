package s03;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程高并发常见问题
 * 线程操作当前中内存中的值，实际m+2，却只执行m+1
 */
public class Main {

    public static int m = 0;


    public static Lock lock = new ReentrantLock();  //JDK1.5之后添加的，互斥锁，底层实现是AQS

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    lock.lock();    //加锁
                    for (int j = 0; j < 100; j++) {
                        m++;
                    }
                } finally {
                    lock.unlock();  //解锁
                }
            });
        }
        for (Thread t : threads) {
            t.start();  //开始线程
        }

        for (Thread t : threads) {
            t.join();   //加入当前线程
        }
        System.out.println(m);
    }
}
