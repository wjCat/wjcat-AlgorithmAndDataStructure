package com.wjcat.learn.leetcode;

public class Solution1822 {

    public int arraySign(int[] nums) {
        int res = 1;
        for (int i :
                nums) {
            if (i == 0) {
                return 0;
            } else if (i < 0) {
                res = -res;
            }
        }
        return res;
    }
}
