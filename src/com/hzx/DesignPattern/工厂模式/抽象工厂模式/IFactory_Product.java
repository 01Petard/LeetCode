package com.hzx.DesignPattern.工厂模式.抽象工厂模式;

public interface IFactory_Product {

    IProduct_Phone getPhone();

    IProduct_Router getRouter();

}
