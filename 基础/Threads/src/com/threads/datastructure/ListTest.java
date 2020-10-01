package com.threads.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 周
 * @title ListTest
 * @description 测试List在高并发下的性能
 * @date 2020/5/23 22:33
 */
public class ListTest {
    public static void main(String[] args) throws InterruptedException {
        // 线程不安全
        List<String> unsafeList = new ArrayList<>();
        // 线程安全
        List<String> safeSyncList = Collections.synchronizedList(new ArrayList<>());
        // 线程安全
        CopyOnWriteArrayList<String> safeCOWList = new CopyOnWriteArrayList<>();

        ListThread t1 = new ListThread(unsafeList);
        ListThread t2 = new ListThread(safeSyncList);
        ListThread t3 = new ListThread(safeCOWList);

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
        // 等待子线程执行结束
        Thread.sleep(2000);

        System.out.println("ListThread1.list.size()-->" + t1.list.size());
        System.out.println("ListThread2.list.size()-->" + t2.list.size());
        System.out.println("ListThread3.list.size()-->" + t3.list.size());

        //输出List中的值
        System.out.println("unsafeList-->");
        for (String s : t1.list) {
            System.out.print(s == null ? "null  " : s + "  ");
        }
        System.out.println();
        System.out.println("safeSyncList-->");
        for (String s : t2.list) {
            System.out.print(s == null ? "null  " : s + "  ");
        }
        System.out.println();
        System.out.println("safeCOWList-->");
        for (String s : t3.list) {
            System.out.print(s == null ? "null  " : s + "  ");
        }
    }
}

/**
 * @author 周
 * @title ListThread
 * @description 线程名称记录在List列表中保存
 * @date 2020/5/23 22:38
 */
class ListThread implements Runnable {

    public List<String> list;

    public ListThread(List<String> list) {
        this.list = list;
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
            // 把当前线程名称加入到list中
            list.add(Thread.currentThread().getName());
            i++;
        }
    }
}
