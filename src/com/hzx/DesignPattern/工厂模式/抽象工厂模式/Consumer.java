package com.hzx.DesignPattern.工厂模式.抽象工厂模式;

public class Consumer {

    public static void main(String[] args) {

        Factory_Brand_A factory_brand_a = new Factory_Brand_A();
        IProduct_Phone phone1 = factory_brand_a.getPhone();
        IProduct_Router router1 = factory_brand_a.getRouter();

        Factory_Brand_B factory_brand_b = new Factory_Brand_B();
        IProduct_Phone phone2 = factory_brand_b.getPhone();
        IProduct_Router router2 = factory_brand_b.getRouter();

        System.out.println("======品牌A======");
        phone1.phone_call();
        phone1.phone_msg();
        phone1.phone_call();
        router1.router_wlan();
        router1.router_wlan();
        router1.router_msg();

        System.out.println("======品牌B======");
        phone2.phone_call();
        phone2.phone_msg();
        phone2.phone_call();
        router2.router_wlan();
        router2.router_wlan();
        router2.router_msg();



    }



}
