package com.wjcat.learn.leetcode;

import java.util.Arrays;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class Solution31 {

    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        final int[] param = {6, 2, 8, 7, 5, 4, 3, 1};
        solution31.nextPermutation(param);
        System.out.println(Arrays.toString(param));
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
