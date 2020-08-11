package com.wjcat.learn.leetcode;

/**
 * @author yupeijiang
 * @date 2020/8/6 0006
 */
public class Solution329 {

    int[][] temp;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        temp = new int[matrix.length][matrix[0].length];
        int longest = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                longest = Math.max(longest, getLongest(matrix, i, j));
            }
        }
        return longest;
    }

    private int getLongest(int[][] matrix, int i, int j) {
        if (temp[i][j] != 0) {
            return temp[i][j];
        }
        int longest = 1;
        if (i >= 1 && matrix[i][j] < matrix[i - 1][j]) {
            int longer = 1;
            longer += getLongest(matrix, i - 1, j);
            longest = Math.max(longer, longest);
        }
        if (j >= 1 && matrix[i][j] < matrix[i][j - 1]) {
            int longer = 1;
            longer += getLongest(matrix, i, j - 1);
            longest = Math.max(longer, longest);
        }
        if (i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j]) {
            int longer = 1;
            longer += getLongest(matrix, i + 1, j);
            longest = Math.max(longer, longest);
        }
        if (j < matrix[i].length - 1 && matrix[i][j] < matrix[i][j + 1]) {
            int longer = 1;
            longer += getLongest(matrix, i, j + 1);
            longest = Math.max(longer, longest);
        }
        temp[i][j] = longest;
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(new Solution329().longestIncreasingPath(
                new int[][]
                        {
                                {3, 4, 5},
                                {3, 2, 6},
                                {2, 2, 1}
                        }));
    }

}
