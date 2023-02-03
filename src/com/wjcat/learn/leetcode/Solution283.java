package com.wjcat.learn.leetcode;

import java.util.Arrays;

public class Solution283 {

    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        int[] param = new int[]{0, 1, 0, 3, 12};
        solution283.moveZeroes(param);
        System.out.println(Arrays.toString(param));
        param = new int[]{0};
        solution283.moveZeroes(param);
        System.out.println(Arrays.toString(param));
    }

    public void moveZeroes(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                if (r != l) {
                    swap(nums, l, r);
                }
                l++;
            }
            r++;
        }
    }

    public void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}