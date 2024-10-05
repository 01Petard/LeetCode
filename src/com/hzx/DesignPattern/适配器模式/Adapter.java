package com.hzx.DesignPattern.适配器模式;

public class Adapter implements NetToUSB {

    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        adaptee.request();
    }
}
