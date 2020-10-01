package com.training.day02;

import java.util.Scanner;


/**
 * @author 周
 * @title MyCalendar
 * @date 2020/7/14 13:40
 * @description 简易日历
 * 1900年1月1日为星期一
 * 功能：
 * <ul>
 *  <li>计算从1900年1月1日到指定日期的天数<li/>
 *  <li>输出指定日期的星期<li/>
 *  <li>输出指定日期当前月的日历<li/>
 * </ul>
 */
public class MyCalendar {

    public final static int originYear = 1900;
    public final static int originMonth = 1;
    public final static int originDay = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取输入得日期
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        scanner.close();
        // 计算距1900年1月1日的总天数
        int days = calculateDays(year, month, day);
        System.out.println(days);   // 输出天数
        int week = 1 + days % 7;
        System.out.println("星期" + week); // 输出星期
        System.out.println("-----------------------------");
        // 输出当前月的日历
        listCalendar(year, month, day, week);
    }

    private static void listCalendar(int year, int month, int day, int week) {
        System.out.println("一\t二\t三\t四\t五\t六\t日");
        // 判断当前月的天数
        int currentDays = getMonthDays(year, month);
        // 推断当月1号的星期
        int firstDayWeek = (day + week + 1) % 7;
        for (int j = 0; j < firstDayWeek - 1; j++) {
            System.out.print("  \t");
        }
        for (int i = 1; i <= currentDays; i++) {
            System.out.print(i + (i >= 10 ? " \t" : "  \t"));
            firstDayWeek++;
            // 换行
            if (0 == (firstDayWeek - 1) % 7)
                System.out.println();
        }
    }

    private static int calculateDays(int year, int month, int day) {
        if (year < originYear) return -1;   // 当输入年份小于1900时，无效
        if (month < originMonth || month > 12) return -1;   // 当月份不在1-12之间时，无效
        if (day < originDay || day > 31) return -1;   // 当输入日期不在1-31之间时，无效
        int totalDays = 0;
        int currentYear = originYear; // 从1900开始计算
        while (currentYear < year) {
            // 判断闰年
            if (0 == currentYear % 4) {
                // 能被100整除的年份
                if (0 == currentYear % 100) {
                    totalDays += 0 == currentYear % 400 ? 366 : 365;
                    currentYear++;
                    continue;
                }
                totalDays += 366;
                currentYear++;
                continue;
            }
            totalDays += 365;   // 平年
            currentYear++;      // 计算下一年
        }
        // 计算当前年的月份
        int currentMonth = originMonth;
        while (currentMonth < month) {
            totalDays += getMonthDays(currentYear, currentMonth);
            currentMonth++;
        }
        // 计算当前月的日期
        totalDays += day - originDay;
        return totalDays;
    }

    private static int getMonthDays(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                boolean isLeapYear = isLeapYear(year);
                return isLeapYear ? 29 : 28;
            default:
                return -1;
        }
    }

    private static boolean isLeapYear(int year) {
        boolean leapYear = false;
        // 判断是否是闰年
        if (0 == year % 4) {
            if (0 == year % 100) {
                leapYear = 0 == year % 400;
            } else {
                leapYear = true;
            }
        }
        return leapYear;
    }
}
