package com.wjcat.learn.leetcode;

public class Solution1486 {

    public int xorOperation(int n, int start) {
        int temp = start;
        for (int i = 1; i < n; i++) {
            temp = temp ^ start + 2 * i;
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution1486 solution1486 = new Solution1486();
        System.out.println(solution1486.xorOperation(10, 5));
    }

}
