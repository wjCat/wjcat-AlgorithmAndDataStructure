package com.wjcat.learn.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Solution704 {

    public static void main(String[] args) {
        Solution704 solution739 = new Solution704();
        System.out.println(solution739.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(solution739.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

}
