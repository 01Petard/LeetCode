package com.hzx.DesignPattern.桥接模式;

public abstract class Computer {

    protected Brand brand;

    public  Computer(){}

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public void info(){
        brand.info();
    }
}
class Desktop extends Computer{

    public Desktop() {
    }

    public Desktop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("台式机");
    }
}
class Laptop extends Computer{

    public Laptop() {
    }

    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("笔记本");
    }
}