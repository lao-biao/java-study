package com.spring5.reactor;

import java.util.Observable;

/**
 * @author 周
 * @title ObservableDemo
 * @date 2020/6/26 11:46
 * @description
 */
public class ObservableDemo extends Observable {
    public static void main(String[] args) {
        ObservableDemo observable = new ObservableDemo();
        observable.addObserver((o, arg) -> {
            System.out.println("发生变化");
        });
        observable.addObserver((o, arg) -> {
            System.out.println("准备改变");
        });
        // 数据发生变化
        observable.setChanged();
        // 通知观察者
        observable.notifyObservers();
    }
}
