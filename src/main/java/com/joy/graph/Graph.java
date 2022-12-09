package com.joy.graph;

import java.util.LinkedList;
import java.util.Queue;

import com.google.errorprone.annotations.Var;

/**
 * 无向图
 *
 * @author Joy
 * @date 2022-12-09
 */
public class Graph {

    public static void main(String[] args) {
        Graph graph = new Graph(20);
        graph.addEdge(1,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(5,7);
        graph.addEdge(7,9);
        graph.addEdge(9,2);
        graph.addEdge(2,6);
        graph.addEdge(6,8);
        graph.addEdge(8,10);
        graph.addEdge(3,10);
        graph.bfs(1,9);
    }

    // 顶点个数
    private int v;

    // 邻接表
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t){
        if (s == t) {
            return;
        }
        // 记录顶点是否访问过，如果访问过就跳到下一个顶点
        boolean[] visited = new boolean[v];
        // 下一个进行广度优先的节点队列，就是和s相连的下几个顶点，以每个顶点作为起点进行bfs
        Queue<Integer> nextVertexQueue = new LinkedList<>();
        nextVertexQueue.add(s);
        // 记录访问的节点路径，下标是节点，值是该节点的前一个节点
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        while (nextVertexQueue.size() != 0) {
            // 取出下一个节点，遍历和它相连的所有节点
            Integer v = nextVertexQueue.poll();
            for (int i = 0; i < adj[v].size(); i++) {
                Integer ve = adj[v].get(i);
                if(!visited[ve]){
                    prev[ve] = v;
                    // 该节点就是目标节点
                    if(ve == t){
                        print(prev, s, t);
                        return;
                    }
                    visited[ve] = true;
                    // 加入队列，下次再进行一次bfs
                    nextVertexQueue.add(ve);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t){
        if(prev[t] != -1 && s != t){
            // 递归打印从s到t，pre[t]的值就是前一个节点的下标
            print(prev, s, prev[t]);
        }
        System.out.println(t + "");
    }
}
