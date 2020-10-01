package s09;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

/**
 * 多线程高并发常见问题
 * 线程操作当前中内存中的值，实际m+2，却只执行m+1
 */
public class Main {

    public static int m = 0;

    public static Lock lock = new MLock();

    public static CountDownLatch latch = new CountDownLatch(100);

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
                latch.countDown();
            });
        }
        for (Thread t : threads) {
            t.start();  //开始线程
        }

        latch.await();  // 线程等待

        System.out.println(m);
    }
}
