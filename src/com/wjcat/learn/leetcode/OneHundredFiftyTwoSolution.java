package com.wjcat.learn.leetcode;

/**
 * @author yupeijiang
 * @date 2020/7/17 0017
 */
public class OneHundredFiftyTwoSolution {

    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int[][] temp = new int[nums.length][2];
        temp[0][0] = nums[0];
        temp[0][1] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int i1 = nums[i] * temp[i - 1][1];
            int i2 = nums[i] * temp[i - 1][0];
            temp[i][0] = Math.min(i1, Math.min(nums[i], i2));
            temp[i][1] = Math.max(i1, Math.max(nums[i], i2));
            max = Math.max(max, temp[i][1]);
        }
        return max;
    }

}
