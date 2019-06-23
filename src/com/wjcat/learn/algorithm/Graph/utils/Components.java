package com.wjcat.learn.algorithm.Graph.utils;

import com.wjcat.learn.algorithm.Graph.basic.Graph;

/**
 * @decription 求无权图的联通分量
 * Created by 厕所里拉屎的猫 on 2019/6/23.
 */
public class Components {

    Graph graph;                    // 图的引用
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int ccount;         // 记录联通分量个数
    private int[] id;           // 每个节点所对应的联通分量标记


    private void dfs(int v) {

        visited[v] = true;
        id[v] = ccount;

        for (int i : graph.adj(v))
            if (!visited[v])
                dfs(v);

    }

    public Components(Graph graph) {

        this.graph = graph;
        this.visited = new boolean[graph.V()];
        this.id = new int[graph.V()];
        this.ccount = 0;

        for (int i = 0; i < graph.V(); i++)
            id[i] = -1;

        // 求图的联通分量
        for (int i = 0; i < graph.V(); i++)
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
    }

    // 返回图的联通分量个数
    int count(){
        return ccount;
    }

    // 查询点v和点w是否联通
    boolean isConnected( int v , int w ){
        if ((v < 0 && v >= graph.V()) || (w < 0 && w >= graph.V()))
            throw new IllegalArgumentException("参数错误");
        return id[v] == id[w];
    }

}
