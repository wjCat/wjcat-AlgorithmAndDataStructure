package com.wjcat.learn.leetcode;

import java.util.Arrays;

public class Solution73 {

    public static void main(String[] args) {
        Solution73 solution73 = new Solution73();
        int[][] param = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        solution73.setZeroes(param);
        System.out.println(Arrays.deepToString(param));
        param = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        solution73.setZeroes(param);
        System.out.println(Arrays.deepToString(param));
    }

    public void setZeroes(int[][] matrix) {
        boolean c = false, r = false;
        for (int[] sub : matrix) {
            if (sub[0] == 0) {
                c = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                r = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (c) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (r) {
            Arrays.fill(matrix[0], 0);
        }
    }

}