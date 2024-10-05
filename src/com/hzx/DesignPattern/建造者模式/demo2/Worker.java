package com.hzx.DesignPattern.建造者模式.demo2;

public class Worker extends Builder {

    private Product product;

    public Worker() {
        //this.product = product;
        product = new Product();
    }

    @Override
    Builder buildA(String msg) {
        product.setBuildA("A");
        System.out.println("A");
        return this;
    }

    @Override
    Builder buildB(String msg) {
        product.setBuildB("B");
        System.out.println("B");
        return this;
    }

    @Override
    Builder buildC(String msg) {
        product.setBuildC("C");
        System.out.println("C");
        return this;
    }

    @Override
    Builder buildD(String msg) {
        product.setBuildD("D");
        System.out.println("D");
        return this;
    }

    @Override
    Product getProduct() {
        return product;
    }
}
