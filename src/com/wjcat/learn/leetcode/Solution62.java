package com.wjcat.learn.leetcode;

/**
 * @author yupeijiang
 * @date 2020/7/17 0017
 */
public class Solution62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(5, 4));
    }

    public static int uniquePaths(int m, int n) {
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    temp[i][j] = 1;
                } else {
                    temp[i][j] = temp[i][j - 1] + temp[i - 1][j];
                }
            }
        }
        return temp[m - 1][n - 1];
    }

}
