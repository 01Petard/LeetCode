package com.hzx.DesignPattern.代理模式.demo1;

public class Host implements  Rent{
    @Override
    public void rent() {
        System.out.println("房东租房子！");
    }
}
