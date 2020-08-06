package com.wjcat.learn.leetcode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

/**
 * @author yupeijiang
 * @date 2020/8/6 0006
 */
public class Solution207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

}
