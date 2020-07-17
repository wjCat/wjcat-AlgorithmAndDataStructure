package com.wjcat.learn.leetcode;

/**
 * @author yupeijiang
 * @date 2020/7/17 0017
 */
public class SixtyThreeSolution {

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] temp = obstacleGrid;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    temp[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        temp[i][j] = 1;
                    } else if (i == 0) {
                        temp[i][j] = temp[i][j - 1];
                    } else if (j == 0) {
                        temp[i][j] = temp[i - 1][j];
                    } else {
                        temp[i][j] = temp[i][j - 1] + temp[i - 1][j];
                    }
                }
            }
        }
        return temp[m - 1][n - 1];
    }

}
