package com.wjcat.learn.leetcode;

import java.util.Arrays;

public class Solution16 {

    public static int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        if (length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < length; i++) {
            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                while (l < r && nums[i] + nums[l] + nums[r] <= target) {
                    res = Math.abs(target - (nums[i] + nums[l] + nums[r])) < Math.abs(target - res) ? nums[i] + nums[l] + nums[r] : res;
                    l++;
                }
                while (l < r && nums[i] + nums[l] + nums[r] > target) {
                    res = Math.abs(target - (nums[i] + nums[l] + nums[r])) < Math.abs(target - res) ? nums[i] + nums[l] + nums[r] : res;
                    r--;
                }
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    }

}
