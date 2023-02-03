package com.wjcat.learn.leetcode;

import java.util.Arrays;

public class Solution566 {

    public static void main(String[] args) {
        Solution566 solution566 = new Solution566();
        System.out.println(Arrays.deepToString(solution566.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
        System.out.println(Arrays.deepToString(solution566.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4)));
        System.out.println(Arrays.deepToString(solution566.matrixReshape(new int[][]{{1, 2}}, 1, 1)));
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = mat[x / n][x % n];
        }
        return ans;
    }

    public int[][] matrixReshape1(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        int rIndex = 0;
        int cIndex = 0;
        for (int[] sub : mat) {
            for (int e : sub) {
                if (cIndex == c) {
                    rIndex++;
                    cIndex = 0;
                }
                res[rIndex][cIndex++] = e;
            }
        }
        return res;
    }

}
