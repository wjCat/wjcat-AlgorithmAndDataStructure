package com.wjcat.learn.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author yupeijiang
 * @date 2020/7/21 0021
 */
public class Solution977 {

    public static void main(String[] args) {
        Solution977 solution977 = new Solution977();
        System.out.println(Arrays.toString(solution977.sortedSquares1(new int[]{-4, -1, 0, 3, 10})));
    }

    public int[] sortedSquares(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num * num);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    public int[] sortedSquares1(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0, j = nums.length - 1, pos = nums.length - 1; i <= j;) {
            int iPow = nums[i] * nums[i];
            int jPow = nums[j] * nums[j];
            if (iPow < jPow) {
                ans[pos--] = jPow;
                j--;
            } else {
                ans[pos--] = iPow;
                i++;
            }
        }
        return ans;
    }

}
