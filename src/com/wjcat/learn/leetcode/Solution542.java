package com.wjcat.learn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution542 {

    public static void main(String[] args) {
        Solution542 solution542 = new Solution542();
        Arrays.stream(solution542.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}))
                .forEach(sub -> System.out.println(Arrays.toString(sub)));
        Arrays.stream(solution542.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}))
                .forEach(sub -> System.out.println(Arrays.toString(sub)));
        Arrays.stream(solution542.updateMatrix(new int[][]{{0}, {0}, {0}, {0}, {0}}))
                .forEach(sub -> System.out.println(Arrays.toString(sub)));
        Arrays.stream(solution542.updateMatrix(new int[][]{
                        {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                        {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                        {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                        {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                        {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                        {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}}))
                .forEach(sub -> System.out.println(Arrays.toString(sub)));
        Arrays.stream(solution542.updateMatrix(new int[][]{
                        {0, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                        {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                        {0, 0, 1, 1, 1, 0, 1, 1, 1, 1},
                        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                        {0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}
                })).forEach(sub -> System.out.println(Arrays.toString(sub)));

    }

//    public int[][] updateMatrix(int[][] mat) {
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[i].length; j++) {
//
//            }
//        }
//    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < res.length; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    adjust(res, i - 1, j, 1);
                    adjust(res, i, j - 1, 1);
                } else {
                    int iPre = getCur(res, i - 1, j);
                    int jPre = getCur(res, i, j - 1);
                    res[i][j] = iPre == -1 ? jPre : jPre == -1 ? iPre : Math.min(iPre, jPre);
                }
            }
        }
        return res;
    }

    private int getCur(int[][] res, int i, int j) {
        if (i < 0 || j < 0 || res[i][j] == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return res[i][j] + 1;
        }
    }

    private void adjust(int[][] res, int i, int j, int temp) {
        if (i < 0 || j < 0 || j >= res[0].length || res[i][j] <= temp) {
            return;
        }
        res[i][j] = temp;
        adjust(res, i - 1, j, temp + 1);
        adjust(res, i, j - 1, temp + 1);
        adjust(res, i, j + 1, temp + 1);
    }

}
