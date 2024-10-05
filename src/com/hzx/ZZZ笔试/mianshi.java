package com.hzx.ZZZ笔试;

class Test {

    public String name = "abc";
}

public class mianshi {

    private String name = "abc";

    public static void main(String[] args) {
        Test test = new Test();
        Test testB = new Test();
        String result = test.equals(testB) + ",";
        result += test.name.equals(testB.name) + ",";
        result += test.name == testB.name;

        System.out.println(result);
    }


}
