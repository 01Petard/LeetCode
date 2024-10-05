package com.hzx.DesignPattern.工厂模式.简单工厂模式;

public class Factory_Car {

    //方法一
    public static Car getCar(String name) {
        if (name.equals("福特")) {
            return new Car_Ford();
        } else if (name.equals("特斯拉")) {
            return new Car_Tesla();
        } else {
            return null;
        }
    }

    //方法二
    public static Car getCar_Fute() {
        return new Car_Ford();
    }

    public static Car getCar_Tesla() {
        return new Car_Tesla();
    }

}
class Car_Ford implements Car {
    @Override
    public void name() {
        System.out.println("福特");
    }
}
class Car_Tesla implements Car {
    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}

