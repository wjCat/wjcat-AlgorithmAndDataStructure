package com.wjcat.learn.algorithm.Graph;

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
    private Boolean[][] graph;

    public DenseGraph(int nodeNumber, boolean directed) {
        this.nodeNumber = nodeNumber;
        this.edgeNumber = 0;
        this.directed = directed;
        this.graph = new Boolean[nodeNumber][nodeNumber];
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
        if (!this.directed )
            this.graph[node2][node1] = true;

        this.edgeNumber++;

    }

    @Override
    public boolean hasEdge(int node1, int node2) {

        assert node1 >= 0 && node1 < this.nodeNumber;
        assert node2 >= 0 && node2 < this.nodeNumber;
        return this.graph[node1][node1];

    }

    @Override
    public void show() {

    }
}
