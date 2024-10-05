package com.hzx.DesignPattern.建造者模式.demo2;

public abstract class Builder {

    abstract Builder buildA(String msg);
    abstract Builder buildB(String msg);
    abstract Builder buildC(String msg);
    abstract Builder buildD(String msg);
    abstract Product getProduct();

}
