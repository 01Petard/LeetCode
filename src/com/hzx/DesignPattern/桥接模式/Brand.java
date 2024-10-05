package com.hzx.DesignPattern.桥接模式;

public abstract class Brand {
    String name;
    void info() {
        System.out.println(this.name);
    }

}
class Apple extends Brand {
    private final String name = "苹果";
    @Override
    public void info() {
        System.out.println(this.name);
    }
}
class Lenovo extends Brand{
    private final String name = "联想";
    @Override
    public void info() {
        System.out.println(this.name);
    }
}