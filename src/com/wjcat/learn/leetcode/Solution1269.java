package com.wjcat.learn.leetcode;

public class Solution1269 {

    public int numWays(int steps, int arrLen) {
        int[] temp = new int[Math.min(arrLen, steps / 2 + 1)];
        for (int i = 0; i < steps; i++) {
            int[] temp2 = new int[Math.min(arrLen, steps / 2 + 1)];
            for (int j = 0; j < Math.min(j, i / 2 + 1); j++) {
            }
            temp = temp2;
        }
        return temp[0];
    }

}
