package com.hzx.Algorithm.图;

import java.util.LinkedList;
import java.util.List;

import static com.hzx.Algorithm.图.BFS.BFS;
import static com.hzx.Algorithm.图.DFS.DFS;


public class 图搜索算法 {

    public static List<List<Integer>> adjList;

    public 图搜索算法(int n) {
        adjList = new LinkedList<>();
        for (int i = 0; i < n; ++i)
            adjList.add(new LinkedList<>());
    }

    // 无向图
    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
        adjList.get(w).add(v);
    }


    public static void main(String[] args) {
        图搜索算法 g = new 图搜索算法(14);  // 修改为足够大的节点数量
        g.addEdge(10, 11);
        g.addEdge(10, 12);
        g.addEdge(11, 12);
        g.addEdge(12, 10);
        g.addEdge(12, 13);
        g.addEdge(13, 13);

        System.out.print("深度优先搜索: ");
        DFS(adjList.size(), 13);

        System.out.print("\n广度优先搜索: ");
        BFS(adjList.size(), 11);
    }
}

