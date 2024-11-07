package com.hzx.ZZZ笔试;

import java.util.HashMap;

public class 乐檬 {


    public static boolean getXO(String str) {

//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (char c : str.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//
//
//        return map.get('x') == map.get('o');


        int xCount = 0;
        int oCount = 0;

        for (char c : str.toCharArray()) {
            
            if(c == 'x') {
                xCount++;
            } else if(c == 'o') {
                oCount++;
            }
        }

        return xCount == oCount;


    }

    public static void main(String[] args) {
        System.out.println(getXO("ooxx")); // true
        System.out.println(getXO("xooox")); // false
        System.out.println(getXO("xoxx")); // false
        System.out.println(getXO("ooXxm")); // true
        System.out.println(getXO("zzoo")); // false
    }
}

