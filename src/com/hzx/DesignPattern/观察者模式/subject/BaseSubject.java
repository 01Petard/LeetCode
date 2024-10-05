package com.hzx.DesignPattern.观察者模式.subject;

import com.hzx.DesignPattern.观察者模式.observer.BaseObserver;

public interface BaseSubject {
    void registerObserver(BaseObserver o);

    void removeObserver(BaseObserver o);

    void notifyObservers(String weatherInfo);
}
