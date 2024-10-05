package com.hzx.DesignPattern.观察者模式.observer;


public class CurrentConditionsDisplay implements BaseObserver {
    @Override
    public void update(String weatherInfo) {
        System.out.println("Current Conditions Display: " + weatherInfo);
    }
}