package com.wjcat.learn.leetcode;

import java.util.Arrays;

public class Solution1510 {

    public static void main(String[] args) {
        Solution1510 solution1510 = new Solution1510();
        System.out.println(solution1510.winnerSquareGame(1));
        System.out.println(solution1510.winnerSquareGame(2));
        System.out.println(solution1510.winnerSquareGame(4));
        System.out.println(solution1510.winnerSquareGame(7));
        System.out.println(solution1510.winnerSquareGame(1000));
    }

    public boolean winnerSquareGame(int n) {
        boolean[] f = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int k = 1; k * k <= i; ++k) {
                if (!f[i - k * k]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }

}
