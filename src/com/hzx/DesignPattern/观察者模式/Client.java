package com.hzx.DesignPattern.观察者模式;

import com.hzx.DesignPattern.观察者模式.observer.BaseObserver;
import com.hzx.DesignPattern.观察者模式.observer.CurrentConditionsDisplay;
import com.hzx.DesignPattern.观察者模式.observer.ForecastDisplay;
import com.hzx.DesignPattern.观察者模式.subject.WeatherStation;


// 客户端代码
public class Client {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        BaseObserver currentConditionsDisplay = new CurrentConditionsDisplay();
        BaseObserver forecastDisplay = new ForecastDisplay();

        // 注册观察者
        weatherStation.registerObserver(currentConditionsDisplay);
        weatherStation.registerObserver(forecastDisplay);

        weatherStation.setWeatherInfo("Sunny");
        weatherStation.setWeatherInfo("Rainy");

        // 移除观察者
        weatherStation.removeObserver(forecastDisplay);

        weatherStation.setWeatherInfo("Cloudy");
    }
}
