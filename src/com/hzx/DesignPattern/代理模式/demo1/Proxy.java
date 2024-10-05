package com.hzx.DesignPattern.代理模式.demo1;

public class Proxy implements Rent {

    private Host host;

    public Proxy(){}

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        hetong();
        fare();
    }

    private void seeHouse(){
        System.out.println("中介签合同！");
    }

    private void hetong(){
        System.out.println("签租赁合同！");
    }

    private void fare(){
        System.out.println("收中介费");
    }

}
