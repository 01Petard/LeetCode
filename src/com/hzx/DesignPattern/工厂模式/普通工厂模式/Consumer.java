package com.hzx.DesignPattern.工厂模式.普通工厂模式;

public class Consumer {

    public static void main(String[] args) {

        Factory_Ford factoryFord = new Factory_Ford();
        Factory_Tesla factoryTesla = new Factory_Tesla();

        Car car1 = factoryFord.getCar();
        Car car2 = factoryTesla.getCar();

        car1.name();
        car2.name();


    }
}
