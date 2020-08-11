package com.wjcat.learn.leetcode;

import java.util.*;

/**
 * @author yupeijiang
 * @date 2020/8/6 0006
 */
public class Solution210 {

    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            }
        }
        int pos = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            result[pos++] = cur;
            for (Integer next : edges.get(cur)) {
                if (--indeg[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return pos == numCourses ? result : new int[0];
    }

    List<List<Integer>> edges;
    int[] status;
    int[] result;
    int pos;
    int[] indeg;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        status = new int[numCourses];
        indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        result = new int[numCourses];
        pos = 0;
        int[] temp = Arrays.copyOf(indeg, indeg.length);
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                dfs(i);
            }
        }
        return pos == numCourses ? result : new int[0];
    }

    public void dfs(int cur) {
        result[pos++] = cur;
        status[cur] = 1;
        List<Integer> nextList = edges.get(cur);
        for (int next : nextList) {
            if (status[next] == 1) {
                pos--;
            } else if (status[next] == 0) {
                if (--indeg[next] == 0) {
                    dfs(next);
                }
            }
        }
        status[cur] = 2;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution210().findOrder(2, new int[][]{{1, 0}})));
    }

}
