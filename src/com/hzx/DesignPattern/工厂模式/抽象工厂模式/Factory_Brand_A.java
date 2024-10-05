package com.hzx.DesignPattern.工厂模式.抽象工厂模式;

public class Factory_Brand_A implements IFactory_Product {
    @Override
    public IProduct_Phone getPhone() {
        return new Phone_Brand_A();
    }

    @Override
    public IProduct_Router getRouter() {
        return new Router_Brand_A();
    }
}
class Phone_Brand_A implements IProduct_Phone {
    @Override
    public void phone_call() {
        System.out.println("品牌A手机打电话");
    }

    @Override
    public void phone_net() {
        System.out.println("品牌A手机上网");
    }

    @Override
    public void phone_msg() {
        System.out.println("品牌A手机发短信");
    }
}
class Router_Brand_A implements IProduct_Router {
    @Override
    public void router_wlan() {
        System.out.println("品牌A路由器上网");
    }

    @Override
    public void router_spread() {
        System.out.println("品牌A路由器广播");
    }

    @Override
    public void router_msg() {
        System.out.println("品牌A路由器发消息");
    }
}


