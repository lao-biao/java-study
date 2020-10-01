package com.grammar;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class Interfaces {
    public static void main(String[] args) {
//        try (FileInputStream fis = new FileInputStream(new BufferedInputStream())) {
//
//        }

    }

    public interface Animal {
        void move();
    }

    public interface NewAnimal {
        default void move() {
            System.out.println("I am moving.");
        }
    }

    public interface StaticAnimal {
        static void move() {
            System.out.println("static animal move()");
        }
    }

    public interface StaticLandAnimal extends StaticAnimal {
        //不能继承StaticAnimal的move()方法
    }

    public static class TestStatic implements StaticLandAnimal {
        public static void main(String[] args) {
            StaticAnimal.move();
            //StaticLandAnimal.move();    //编译器报错
            //new TestStatic().move();    //编译器报错
        }
    }

}
