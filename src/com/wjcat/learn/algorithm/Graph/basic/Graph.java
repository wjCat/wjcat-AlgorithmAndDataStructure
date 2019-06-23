package com.wjcat.learn.algorithm.Graph.basic;

/**
 * @decription 图接口
 * Created by 厕所里拉屎的猫 on 2019/6/19.
 */
public interface Graph {

    /**
     * 获取图中的点数
     *
     * @return 点的个数
     */
    int V();

    /**
     * 获取图中的边数
     *
     * @return 边的个数
     */
    int E();

    /**
     * 添加边
     * @param node1 点1
     * @param node2 点2
     */
    void addEdge(int node1, int node2);

    /**
     * 查询输入的两点是否有边
     *
     * @param node1 点1
     * @param node2 点2
     * @return
     */
    boolean hasEdge(int node1, int node2);

    /**
     * 输出图
     */
    void show();

    /**
     * 图的迭代器，返回点v的所有边
     * @param v 节点
     * @return 迭代器
     */
    Iterable<Integer> adj(int v);

}
