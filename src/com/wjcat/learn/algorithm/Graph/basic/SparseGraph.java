package com.wjcat.learn.algorithm.Graph.basic;

import java.util.Vector;

/**
 * @decription 稀疏图 -- 邻接表
 * Created by 厕所里拉屎的猫 on 2019/6/19.
 */
public class SparseGraph implements Graph {

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
     * @Field nodeNumber 邻接表
     */
    private Vector<Integer>[] graph;

    public SparseGraph(int nodeNumber, boolean directed) {
        this.nodeNumber = nodeNumber;
        this.edgeNumber = 0;
        this.directed = directed;
        this.graph = new Vector[nodeNumber];
        for (int i = 0; i < nodeNumber; i++)
            this.graph[i] = new Vector<>();
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

        assert node1 >= 0 && node1 < this.nodeNumber;
        assert node2 >= 0 && node2 < this.nodeNumber;

        this.graph[node1].add(node2);
        if (node1 != node2 && !this.directed)
            this.graph[node2].add(node1);

        this.edgeNumber++;

    }

    @Override
    public boolean hasEdge(int node1, int node2) {

        assert node1 >= 0 && node1 < this.nodeNumber;
        assert node2 >= 0 && node2 < this.nodeNumber;

        for (int i = 0; i < this.graph[node1].size(); i++)
            if (this.graph[node1].elementAt(i) == node2)
                return true;
        return false;
    }

    @Override
    public void show() {

        for (int i = 0; i < graph.length; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].elementAt(j) + "\t");
            }
            System.out.println();
        }

    }

    @Override
    public Iterable<Integer> adj(int v) {
        if (v >= 0 && v < this.nodeNumber)
            throw new IllegalArgumentException("参数错误");
        return graph[v];
    }
}
