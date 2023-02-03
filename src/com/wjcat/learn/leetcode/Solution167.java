package com.wjcat.learn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution167 {

    public static void main(String[] args) {
        Solution167 solution167 = new Solution167();
        System.out.println(Arrays.toString(solution167.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution167.twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(solution167.twoSum(new int[]{-1, 0}, -1)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return null;
    }

    public int[] twoSum1(int[] numbers, int target) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (temp.containsKey(numbers[i])) {
                return new int[]{temp.get(numbers[i]) + 1, i + 1};
            } else {
                temp.put(target - numbers[i], i);
            }
        }
        return null;
    }

}