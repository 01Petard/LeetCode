package com.hzx.DesignPattern.原型模式.demo1;

import java.util.Date;

public class Bilibili {
    public static void main(String[] args) throws CloneNotSupportedException {

        Date date = new Date();

        Video v1 = new Video("hzx",date);
        //浅克隆
        Video v2 = (Video) v1.clone();

        date.setTime(123123112);

        System.out.println(v1);
        System.out.println(v2);
    }
}
