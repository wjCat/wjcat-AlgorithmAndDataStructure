package com.wjcat.learn.algorithm.Graph.basic;

import java.util.Vector;

/**
 * @decription 稠密图 -- 邻接矩阵
 * Created by 厕所里拉屎的猫 on 2019/6/19.
 */
public class DenseGraph implements Graph {

    /**
     * @Field nodeNumber 节点数
     */
    private int nodeNumber;

    /**
     * @Field nodeNumber 边数
     */
    private int edgeNumber;

    /**
     * @Field nodeNumber 是否为有向图
     */
    private boolean directed;

    /**
     * @Field nodeNumber 二维数组
     */
    private boolean[][] graph;

    public DenseGraph(int nodeNumber, boolean directed) {
        this.nodeNumber = nodeNumber;
        this.edgeNumber = 0;
        this.directed = directed;
        this.graph = new boolean[nodeNumber][nodeNumber];
    }


    @Override
    public int V() {
        return this.nodeNumber;
    }

    @Override
    public int E() {
        return this.edgeNumber;
    }

    @Override
    public void addEdge(int node1, int node2) {

        if (hasEdge(node1, node2))
            return;

        this.graph[node1][node2] = true;
        if (!this.directed)
            this.graph[node2][node1] = true;

        this.edgeNumber++;

    }

    @Override
    public boolean hasEdge(int node1, int node2) {

        if (node1 < 0 && node1 >= this.nodeNumber)
            throw new IllegalArgumentException(String.format("参数无效"));
        if (node2 < 0 && node2 >= this.nodeNumber)
            throw new IllegalArgumentException(String.format("参数无效"));
        return this.graph[node1][node1];

    }

    @Override
    public void show() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++)
                System.out.print(graph[i][j]+"\t");
            System.out.println();

        }
    }

    @Override
    public Iterable<Integer> adj(int v) {
        if (v >= 0 && v < this.nodeNumber)
            throw new IllegalArgumentException("参数错误");
        Vector<Integer> adjV = new Vector<Integer>();
        for(int i = 0 ; i < nodeNumber ; i ++ )
            if( graph[v][i] )
                adjV.add(i);
        return adjV;
    }
}
