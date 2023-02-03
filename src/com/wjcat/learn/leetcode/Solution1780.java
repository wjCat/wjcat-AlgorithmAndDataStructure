package com.wjcat.learn.leetcode;

public class Solution1780 {

    public static void main(String[] args) {
        Solution1780 solution1780 = new Solution1780();
        System.out.println(solution1780.checkPowersOfThree(12));
        System.out.println(solution1780.checkPowersOfThree(91));
        System.out.println(solution1780.checkPowersOfThree(21));
    }

    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

}
