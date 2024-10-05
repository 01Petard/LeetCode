package com.hzx.Thread线程相关;

import java.util.concurrent.ConcurrentHashMap;

public class demo_ConcurrentHashMap {

    /**
     * HashTable线程安全，但是效率低
     */
//    static Hashtable<String, String> hm = new Hashtable<>();

    /**
     * ConcurrentHashMap也是线程安全，但是效率比HashTable高
     */
    static ConcurrentHashMap<String, String> hm = new ConcurrentHashMap<>(100);
    
    public static void addData() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                hm.put(String.valueOf(i), String.valueOf(i));
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 25; i < 51; i++) {
                hm.put(String.valueOf(i), String.valueOf(i));
            }
        });
        t1.start();
        t2.start();
    }

    public static void main(String[] args) throws InterruptedException {

        addData();

        //等待t1和t2把数据全部添加完毕
        Thread.sleep(1000);
        for (int i = 0; i < 51; i++) {
            System.out.println(hm.get(i + ""));  //0 1 2 3 .... 50
        }


    }
}
