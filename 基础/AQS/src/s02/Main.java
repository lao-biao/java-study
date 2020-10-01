package s02;

/**
 * 多线程高并发常见问题
 * 线程操作当前中内存中的值，实际m+2，却只执行m+1
 * <p>
 * 解决：加锁
 */
public class Main {

    public static int m = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                synchronized (Main.class) {     //线程访问时加锁，结束时打开，其他线程再访问时，加锁状态时线程阻塞
                    for (int j = 0; j < 100; j++) {
                        m++;
                    }
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
