package com.reflection;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @author 周
 * @title TestTask
 * @description
 * @date 2020/5/31 21:40
 */
public class TestTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, now.get(Calendar.SECOND) + 1);
        Date runDate = now.getTime();
        MyTask task = new MyTask();
        timer.scheduleAtFixedRate(task, runDate, 3000);
    }
}
