package com.hzx.DesignPattern.建造者模式.demo1;

public class Director {

    public Product build(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();

        return builder.getProduct();
    }

}
