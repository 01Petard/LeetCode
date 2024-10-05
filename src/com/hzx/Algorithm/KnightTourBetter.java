package com.hzx.Algorithm;

import java.util.ArrayList;
import java.util.List;


/**
 * 骑士周游问题（改进）
 */
public class KnightTourBetter {
    private static final int SIZE = 8;
    private static final int[][] MOVES = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };
    private static final int ALL_SQUARES = (1 << (SIZE * SIZE)) - 1; // 所有方格都被访问过的掩码
    private static final List<List<Integer>> solutions = new ArrayList<>(); // 存储所有解决方案

    public static void main(String[] args) {
        int start = 0; // 初始位置为棋盘的第一个方格（0号位置）
        System.out.println("Start solving...");
        solve(start, 1 << start, new ArrayList<>()); // 从初始位置开始求解  
        System.out.println("Total solutions found: " + solutions.size());
        // 打印所有解决方案（如果需要）  
        for (List<Integer> solution : solutions) {
            System.out.println(solution);
        }
    }

    private static void solve(int current, int visited, List<Integer> path) {
        if (visited == ALL_SQUARES && path.size() == SIZE * SIZE) {
            // 如果所有方格都被访问过，并且路径长度正确，则找到一个解  
            solutions.add(new ArrayList<>(path));
            System.out.println("Found a solution:" + path);
            return;
        }

        for (int[] move : MOVES) {
            int nextX = current / SIZE + move[0];
            int nextY = current % SIZE + move[1];
            int next = nextX * SIZE + nextY;

            if (next >= 0 && next < SIZE * SIZE && ((visited >> next) & 1) == 0) {
                // 如果下一个位置在棋盘范围内且未被访问过  
                path.add(next); // 将下一个位置添加到路径中  
                solve(next, visited | (1 << next), path); // 递归尝试下一个位置  
                path.remove(path.size() - 1); // 回溯，移除最后一个位置  
            }
        }
    }
}