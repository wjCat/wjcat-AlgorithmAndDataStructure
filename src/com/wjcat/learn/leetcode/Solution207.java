package com.wjcat.learn.leetcode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

/**
 * @author yupeijiang
 * @date 2020/8/6 0006
 */
public class Solution207 {

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            for (Integer next : edges.get(queue.poll())) {
                if (--indeg[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return visited == numCourses;
    }

    List<List<Integer>> edges;
    int[] status;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        edges = new ArrayList<>();
        status = new int[numCourses];
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        boolean result = false;
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                status[i] = 1;
                if (!dfs(edges.get(i))) {
                    return false;
                }
                status[i] = 2;
                result = true;
            }
        }
        return result ? Arrays.stream(status).noneMatch(i -> i == 0) : result;
    }

    public boolean dfs(List<Integer> nextList) {
        if (nextList.size() == 0) {
            return true;
        }
        for (Integer next : nextList) {
            if (status[next] == 1) {
                return false;
            } else if (status[next] == 0) {
                status[next] = 1;
                if (!dfs(edges.get(next))) {
                    return false;
                }
            }
            status[next] = 2;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution207().canFinish(2, new int[][]{{0, 1}}));
    }

}
