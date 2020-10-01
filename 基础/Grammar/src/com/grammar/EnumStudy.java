package com.grammar;

public class EnumStudy {
    enum Fruit {
        APPLE(10), ORANGE(8);
        private int price;

        Fruit(int price) {
            this.price = price;
        }

        public int getPrice() {
            return this.price;
        }
    }

    public static void main(String[] args) {
        //测试枚举类
        Fruit apple = Fruit.APPLE;
        System.out.println("Apple price is " + apple.getPrice());

    }
}
