package com.threads.datastructure;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 周
 * @title MapTest
 * @description
 * @date 2020/5/23 23:19
 */
public class MapTest {

    public static void main(String[] args) throws InterruptedException {
        // 线程不安全
        Map<Integer, String> unsafeHashMap = new HashMap<>();
        // 线程安全
        Map<Integer, String> safeSyncMap = Collections.synchronizedMap(new HashMap<Integer, String>());
        // 线程安全
        ConcurrentHashMap<Integer, String> safeCHashMap = new ConcurrentHashMap<>();

        MapThread t1 = new MapThread(unsafeHashMap);
        MapThread t2 = new MapThread(safeSyncMap);
        MapThread t3 = new MapThread(safeCHashMap);

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

        System.out.println("MapThread1.map.size()-->" + t1.map.size());
        System.out.println("MapThread2.map.size()-->" + t2.map.size());
        System.out.println("MapThread3.map.size()-->" + t3.map.size());

        //输出List中的值
        System.out.println("unsafeList-->");
        Iterator iterator = t1.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iterator.next();
            System.out.print(entry.getKey() + ":" + entry.getValue() + "  ");
        }
        System.out.println();
        System.out.println("safeSyncList-->");
        iterator = t2.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iterator.next();
            System.out.print(entry.getKey() + ":" + entry.getValue() + "  ");
        }
        System.out.println();
        System.out.println("safeCOWList-->");
        iterator = t3.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iterator.next();
            System.out.print(entry.getKey() + ":" + entry.getValue() + "  ");
        }
    }
}

/**
 * @author 周
 * @title ListThread
 * @description 线程名称记录在map中保存
 * @date 2020/5/23 22:38
 */
class MapThread implements Runnable {

    public Map<Integer, String> map;

    public MapThread(Map<Integer, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 100) {   //每个线程记录100条
            // 把当前线程名称加入到map中
            map.put(i++, Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
