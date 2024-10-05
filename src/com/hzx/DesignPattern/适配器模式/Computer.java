package com.hzx.DesignPattern.适配器模式;

public class Computer {

    public void net(NetToUSB adapter){
        adapter.handleRequest();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);

        computer.net(adapter);
    }
}
