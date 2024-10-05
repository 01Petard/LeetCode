package com.hzx.DesignPattern.代理模式.demo1;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();

        Proxy proxy = new Proxy(host);

        proxy.rent();

    }
}
