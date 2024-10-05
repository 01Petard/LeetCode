package com.hzx.DesignPattern.工厂模式.普通工厂模式;

public class Factory_Tesla implements Facroty_Car {
    @Override
    public Car getCar() {
        return new Car_Tesla();
    }
}
class Car_Tesla implements Car {
    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}
