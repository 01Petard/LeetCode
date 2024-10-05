package com.hzx.DesignPattern.观察者模式.subject;

import com.hzx.DesignPattern.观察者模式.observer.BaseObserver;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements BaseSubject {
    private List<BaseObserver> observers = new ArrayList<>();

    String watherInfo;

    /**
     * 查看天气情况
     * @return
     */
    public String getWeatherInfo() {
        return watherInfo;
    }

    /**
     * 调整天气情况
     * @param info
     */
    public void setWeatherInfo(String info) {
        watherInfo = info;
        notifyObservers(info);
    }

    /**
     * 添加观察者
     * @param o
     */
    @Override
    public void registerObserver(BaseObserver o) {
        observers.add(o);
    }

    /**
     * 移除观察者
     * @param o
     */
    @Override
    public void removeObserver(BaseObserver o) {
        observers.remove(o);
    }

    /**
     * 通知观察者
     * @param weatherInfo
     */
    @Override
    public void notifyObservers(String weatherInfo) {
        for (BaseObserver observer : observers) {
            observer.update(weatherInfo);
        }
    }
}
