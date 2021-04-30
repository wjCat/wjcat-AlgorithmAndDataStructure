package com.wjcat.learn.leetcode;

public class Solution70 {

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] temp = new int[n + 1];
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            temp[i] = temp[i - 1] + temp [i - 2];
        }
        return temp[n];
    }

    public int climbStairs1(int n) {
        if (n < 3) {
            return n;
        }
        int pre = 1, pre1 = 2;
        for (int i = 3; i < n + 1; i++) {
            int temp = pre;
            pre = pre1;
            pre1 = temp + pre1;
        }
        return pre1;
    }

    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        System.out.println(solution70.climbStairs(6));
    }

}
