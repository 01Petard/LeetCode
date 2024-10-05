package com.hzx.DesignPattern.工厂模式.简单工厂模式;

public class Consumer {

    public static void main(String[] args) {

        Factory_Car carFactory = new Factory_Car();

        Car car1 = carFactory.getCar("福特");
        Car car2 = carFactory.getCar("特斯拉");

        car1.name();
        car2.name();

    }
}
