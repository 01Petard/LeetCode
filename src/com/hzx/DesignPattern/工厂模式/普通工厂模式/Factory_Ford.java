package com.hzx.DesignPattern.工厂模式.普通工厂模式;

public class Factory_Ford implements Facroty_Car {
    @Override
    public Car getCar(){
        return new Car_Ford();
    }
}
class Car_Ford implements Car {
    @Override
    public void name() {
        System.out.println("福特");
    }
}

