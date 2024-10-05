package com.hzx.DesignPattern.建造者模式.demo1;

public class Worker extends Builder{

    private Product product;

    public Worker() {
        //this.product = product;
        product = new Product();
    }

    @Override
    void buildA() {
        product.setBuildA("A");
        System.out.println("A");
    }

    @Override
    void buildB() {
        product.setBuildB("B");
        System.out.println("B");
    }

    @Override
    void buildC() {
        product.setBuildC("C");
        System.out.println("C");
    }

    @Override
    void buildD() {
        product.setBuildD("D");
        System.out.println("D");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
