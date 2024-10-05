package com.hzx.DesignPattern.建造者模式.demo2;

public class Test {
    public static void main(String[] args) {
        Worker worker = new Worker();

        Product product = worker
                .buildA("A")
                .buildB("B")
                .getProduct();//链式编程


        System.out.println(product);

    }
}
