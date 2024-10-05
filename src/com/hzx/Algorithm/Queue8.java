package com.hzx.Algorithm;


/**
 * 八皇后算法
 */
public class Queue8 {

    int max = 8;

    int[] array = new int[max]; //下标表示皇后所在的行,值表示皇后所在的列


    int solution = 0; //解的数量
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("总共有" + queue8.solution + "种解法");
    }


    //放置皇后
    private void check(int n) {
        if (n == max) {
            for (int item : array) {
                System.out.print(item + " ");
            }
            System.out.println();
            solution++;
            return;
        }
        //依次放入皇后,并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把第n个皇后放在第1列
            array[n] = i;

            //判断当放置第n个皇后时,是否冲突
            if (judge(n)) { //不冲突,则继续放第n+1个皇后
                check(n + 1);  //冲突,则继续尝试放第n个皇后,直到尝试完所有的列,都没有找到符合条件的,则返回
            }
        }
    }

    //放置第n个皇后,检测是否和之前的冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || //第n个皇后和之前的皇后是否在同一列
                    Math.abs(array[i] - array[n]) == Math.abs(i - n)) {  ////第n个皇后和之前的皇后是否在同一斜线
                return false;
            }
        }
        return true;
    }



}