package com.wjcat.learn.leetcode;

public class Solution64 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] temp = new int[grid.length][grid[0].length];
        temp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            temp[i][0] = temp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            temp[0][j] = temp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                temp[i][j] = Math.min(grid[i][j] + temp[i][j - 1], grid[i][j] + temp[i - 1][j]);
            }
        }
        return temp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        Solution64 solution64 = new Solution64();
        System.out.println(solution64.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }

}
