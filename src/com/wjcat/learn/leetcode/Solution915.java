package com.wjcat.learn.leetcode;

public class Solution915 {

    public static void main(String[] args) {
        System.out.println(partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
        System.out.println(partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}));
        System.out.println(partitionDisjoint(new int[]{24, 11, 49, 80, 63, 8, 61, 22, 73, 85}));
    }

    public static int partitionDisjoint(int[] nums) {
        int left = 0;
        int right = 1;
        int max = 0;
        int tempMax = 0;
        while (right < nums.length - 1) {
            if (nums[right] < nums[max]) {
                left = right;
                max = tempMax;
            } else {
                tempMax = nums[tempMax] > nums[right] ? tempMax : right;
            }
            right++;
        }
        return left + 1;
    }

}
