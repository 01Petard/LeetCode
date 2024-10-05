package com.hzx.DesignPattern.代理模式.demo2;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);
        proxy.add();
        proxy.delete();
        proxy.update();
        proxy.query();
    }
}
