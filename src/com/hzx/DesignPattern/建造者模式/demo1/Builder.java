package com.hzx.DesignPattern.建造者模式.demo1;

public abstract class Builder {

    abstract void buildA();
    abstract void buildB();
    abstract void buildC();
    abstract void buildD();


    abstract Product getProduct();

}
