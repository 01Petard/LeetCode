package com.hzx.DesignPattern.单例模式;

public class Singleton {
    private static final Singleton instance = new Singleton();

    // 构造方法私有，确保外界不能直接实例化
    private Singleton() {
    }

    // 通过公有的静态方法获取对象实例
    public static Singleton getInstance() {
        return instance;
    }
}
