package com.threads.datastructure;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author 周
 * @title SetTest
 * @description Set可保证元素不重复，TreeSet依靠TreeMap进行实例化，TreeMap的put方法中利用了比较器排序，根据底层的树形结构，键值大的放右边，小的放左边。键值相等时，设置为新的键值，所以键相同，值覆盖。
 * Set中当插入null键时会抛出空指针异常
 * @date 2020/5/23 22:57
 */
public class SetTest {

    public static void main(String[] args) throws InterruptedException {
        // 线程不安全
        Set<String> unsafeSet = new HashSet<>();
        // 线程安全
        Set<String> safeSyncSet = Collections.synchronizedSet(new HashSet<>());
        // 线程安全
        CopyOnWriteArraySet<String> safeCOWSet = new CopyOnWriteArraySet<>();

        SetThread t1 = new SetThread(unsafeSet);
        SetThread t2 = new SetThread(safeSyncSet);
        SetThread t3 = new SetThread(safeCOWSet);

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(t1, String.valueOf(i));
            t.start();
        }
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(t2, String.valueOf(i));
            t.start();
        }
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(t3, String.valueOf(i));
            t.start();
        }

        // 等待子线程执行完
        Thread.sleep(2000);

        System.out.println("SetThread1.set.size()-->" + t1.set.size());
        System.out.println("SetThread2.set.size()-->" + t2.set.size());
        System.out.println("SetThread3.set.size()-->" + t3.set.size());

        // 输出Set中的值
        System.out.println("unsafeSet");
        for (String element : t1.set) {
            //System.out.print(element == null ? "null  " : element + "  ");
            System.out.print(element + "  ");
        }
        System.out.println();
        System.out.println("safeSyncSet");
        for (String element : t2.set) {
            //System.out.print(element == null ? "null  " : element + "  ");
            System.out.print(element + "  ");        }
        System.out.println();
        System.out.println("safeCOWSet");
        for (String element : t3.set) {
            //System.out.print(element == null ? "null  " : element + "  ");
            System.out.print(element + "  ");        }
        System.out.println();
    }
}

class SetThread implements Runnable {

    public Set<String> set;

    public SetThread(Set<String> set) {
        this.set = set;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //把当前线程名称加入到Set中
            set.add(Thread.currentThread().getName() + i);
            i++;
        }
    }
}
