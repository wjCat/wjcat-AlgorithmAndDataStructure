package com.wjcat.learn.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2319 {

    public static void main(String[] args) {
        Solution2319 solution2319 = new Solution2319();
//        System.out.println(solution2319.checkXMatrix(new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}}));
//        System.out.println(solution2319.checkXMatrix(new int[][]{{5, 7, 0}, {0, 3, 1}, {0, 5, 0}}));
//        System.out.println(solution2319.checkXMatrix(new int[][]{
//                {5, 0, 0, 1},
//                {0, 4, 1, 5},
//                {0, 5, 2, 0},
//                {4, 1, 0, 2}}));
//        System.out.println(solution2319.checkXMatrix(new int[][]{
//                {6, 0, 0, 0, 0, 0, 0, 18},
//                {0, 17, 0, 0, 0, 0, 18, 0},
//                {0, 0, 13, 0, 0, 17, 0, 0},
//                {0, 0, 0, 9, 18, 0, 0, 0},
//                {0, 0, 0, 2, 20, 0, 0, 0},
//                {0, 0, 20, 0, 0, 3, 0, 0},
//                {0, 14, 0, 0, 0, 0, 11, 0},
//                {19, 0, 0, 0, 0, 0, 0, 9}}));
        System.out.println(solution2319.checkXMatrix(new int[][]{
                {2, 0, 0, 1},
                {0, 3, 1, 0},
                {0, 5, 2, 0},
                {4, 0, 0, 2}}));

    }

    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == j || i + j == grid.length - 1) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}