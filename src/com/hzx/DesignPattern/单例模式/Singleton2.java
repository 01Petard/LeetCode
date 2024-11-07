package com.hzx.DesignPattern.单例模式;

/**
 * 懒汉
 */
public class Singleton2 {
    private static volatile Singleton2 instance = null;

    // 私有构造方法，确保外界不能直接实例化。
    private Singleton2() {
    }

    // 通过公有的静态方法获取对象实例
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}