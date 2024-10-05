package com.hzx.Algorithm.图;

import java.util.List;

import static com.hzx.Algorithm.图.图搜索算法.adjList;

public class DFS {
    /**
     * 深度优先搜索
     * @param n   节点个数
     * @param val 开始遍历的节点值
     */
    public static void DFS(int n, int val) {
        boolean[] visited = new boolean[n];
        DFSUtil(val, visited);
    }

    private static void DFSUtil(int v, boolean[] visited) {
        // 将当前节点标记为已访问
        visited[v] = true;
        System.out.print(v + " ");

        List<Integer> neighbors = adjList.get(v);
        // 访问 节点v 的所有子节点及其相邻节点，实现深度遍历
        for (Integer w : neighbors) {
            if (!visited[w])
                DFSUtil(w, visited);
        }
    }
}
