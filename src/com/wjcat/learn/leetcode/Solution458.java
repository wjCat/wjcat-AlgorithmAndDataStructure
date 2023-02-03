package com.wjcat.learn.leetcode;

import java.util.Arrays;

public class Solution458 {

    public static void main(String[] args) {
        Solution458 dd = new Solution458();
        for (int i = 1; i < 1000000; i++) {
            for (int j = 1; j < 15; j++) {
                int current = dd.poorPigs(i, 1, j);
                int next = dd.poorPigs(i + 1, 1, j);
                if (current != next) {
                    System.out.print("(" + i + "," + j + "," + current + ")-");
                }
            }
            System.out.println();
        }
    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int[][] combinations = new int[buckets + 1][buckets + 1];
        try {
            if (buckets == 1) {
                return 0;
            }
            combinations[0][0] = 1;
            int iterations = minutesToTest / minutesToDie;
            int[][] f = new int[buckets][iterations + 1];
            for (int i = 0; i < buckets; i++) {
                f[i][0] = 1;
            }
            for (int j = 0; j <= iterations; j++) {
                f[0][j] = 1;
            }
            for (int i = 1; i < buckets; i++) {
                combinations[i][0] = 1;
                combinations[i][i] = 1;
                for (int j = 1; j < i; j++) {
                    combinations[i][j] = combinations[i - 1][j - 1] + combinations[i - 1][j];
                }
                for (int j = 1; j <= iterations; j++) {
                    for (int k = 0; k <= i; k++) {
                        f[i][j] += f[k][j - 1] * combinations[i][i - k];
                    }
                }
                if (f[i][iterations] >= buckets) {
                    return i;
                }
            }
            return 0;
        } finally {
            combinations = null;
            System.gc();
        }

    }

}
