package com.wjcat.learn.leetcode;

import java.util.Arrays;

public class Solution1658 {

    public static void main(String[] args) {
        Solution1658 solution1658 = new Solution1658();
        System.out.println(solution1658.minOperations2(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.println(solution1658.minOperations2(new int[]{5, 6, 7, 8, 9}, 4));
        System.out.println(solution1658.minOperations2(new int[]{3, 2, 20, 1, 1, 3}, 10));
    }

    public int minOperations(int[] nums, int x) {
        int remain = Arrays.stream(nums).sum() - x;
        int res = -1;

        int l = 0;
        int r = 0;
        int scopeSum = 0;
        while (l < nums.length) {
            while (r < nums.length && remain >= scopeSum + nums[r]) {
                scopeSum += nums[r];
                r++;
            }
            if (scopeSum == remain) {
                res = Math.max(res, r - l);
            }
            scopeSum -= nums[l];
            l++;
        }

        return res == -1 ? -1 : nums.length - res;
    }

    public int minOperations2(int[] nums, int x) {
        int remain = Arrays.stream(nums).sum() - x;
        int res = -1;

        int l = 0;
        int r = 0;
        while (l < nums.length) {
            while (r < nums.length && remain > 0) {
                remain -= nums[r];
                r++;
            }
            if (0 == remain) {
                res = Math.max(res, r - l);
            }
            remain += nums[l];
            l++;
        }

        return res == -1 ? -1 : nums.length - res;
    }

}
