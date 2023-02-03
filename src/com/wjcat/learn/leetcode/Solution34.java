package com.wjcat.learn.leetcode;

import java.util.Arrays;

public class Solution34 {

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
//        System.out.println(Arrays.toString(solution34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//        System.out.println(Arrays.toString(solution34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
//        System.out.println(Arrays.toString(solution34.searchRange(new int[]{}, 0)));
//        System.out.println(Arrays.toString(solution34.searchRange(new int[]{1, 3}, 1)));
        System.out.println(Arrays.toString(solution34.searchRange(new int[]{1, 2, 3}, 3)));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 0 || nums[left] > target || nums[right] < target) {
            return new int[]{-1, -1};
        }
        int mid = right - (right - left) / 2;
        while (nums[mid] != target) {
            if (nums[left] == target) {
                mid = left;
                break;
            }
            if (nums[mid] == target) {
                break;
            }
            if (nums[right] == target) {
                mid = right;
                break;
            }
            if (right - left == 1) {
                break;
            }
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
            mid = right - (right - left) / 2;
        }
        left = right = mid;
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right < nums.length && nums[right] == target) {
            right++;
        }
        return new int[]{left + 1, right - 1};
    }

}
