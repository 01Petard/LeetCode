package com.hzx.Algorithm.图;

import java.util.LinkedList;
import java.util.List;

import static com.hzx.Algorithm.图.图搜索算法.adjList;


public class BFS {

    /**
     * 广度优先搜索
     * @param n   节点个数
     * @param val 开始遍历的节点值
     */
    public static void BFS(int n, int val) {
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        // // 将当前节点标记为已访问
        visited[val] = true;
        queue.add(val);

        while (!queue.isEmpty()) {
            val = queue.poll();
            System.out.print(val + " ");
            // 获取当前节点的所有邻居节点
            List<Integer> neighbors = adjList.get(val);
            for (Integer neigh : neighbors) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    queue.add(neigh);
                }
            }
        }
    }
}

