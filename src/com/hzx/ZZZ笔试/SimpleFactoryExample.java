package com.hzx.ZZZ笔试;

public class SimpleFactoryExample {

    // 定义产品接口
    interface Product {
        void show();
    }

    // 具体产品A
    static class ConcreteProductA implements Product {
        @Override
        public void show() {
            System.out.println("展示产品A");
        }
    }

    // 具体产品B
    static class ConcreteProductB implements Product {
        @Override
        public void show() {
            System.out.println("展示产品B");
        }
    }

    // 简单工厂方法
    static class SimpleFactory {
        public static Product createProduct(String type) {
            if ("A".equalsIgnoreCase(type)) {
                return new ConcreteProductA();
            } else if ("B".equalsIgnoreCase(type)) {
                return new ConcreteProductB();
            } else {
                throw new IllegalArgumentException("不支持的产品类型");
            }
        }
    }

    public static void main(String[] args) {
        // 使用简单工厂创建产品对象
        Product productA = SimpleFactory.createProduct("A");
        productA.show();  // 输出: 展示产品A

        Product productB = SimpleFactory.createProduct("B");
        productB.show();  // 输出: 展示产品B
    }
}
