package com.wjcat.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution841 {

    public static void main(String[] args) {
        Solution841 solution841 = new Solution841();
        int[][] paramArray = new int[][]{{1},{2},{3},{}};
        List<List<Integer>> param = Arrays.stream(paramArray).map(e -> Arrays.stream(e).boxed().collect(Collectors.toList())).collect(Collectors.toList());
        System.out.println(solution841.canVisitAllRooms(param));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] temp = new boolean[rooms.size()];
        temp[0] = true;
        for (Integer targetRoom : rooms.get(0)) {
            doVisit(targetRoom, rooms, temp);
        }
        for (boolean b : temp) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public void doVisit(int current, List<List<Integer>> rooms, boolean[] temp) {
        if (temp[current]) {
            return;
        }

        temp[current] = true;

        for (Integer targetRoom : rooms.get(current)) {
            doVisit(targetRoom, rooms, temp);
        }
    }

}
