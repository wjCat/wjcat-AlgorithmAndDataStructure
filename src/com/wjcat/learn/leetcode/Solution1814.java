package com.wjcat.learn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Solution1814 {

    public static void main(String[] args) {
        Solution1814 solution1814 = new Solution1814();
        System.out.println(solution1814.countNicePairs(new int[]{42, 11, 1, 97}));
        System.out.println(solution1814.countNicePairs(new int[]{13, 10, 35, 24, 76}));
    }

    public int countNicePairs(int[] nums) {
        int res = 0;
        Map<Integer, Integer> temp = new HashMap<>();
        for (int cur : nums) {
            int rev = rev(cur);
            Integer num = temp.getOrDefault(cur - rev, 0);
            res = (res + num) % 1000000007;
            temp.put(cur - rev, num + 1);
        }
        return res;
    }

    private int rev(int i) {
        int res = 0;
        while (i != 0) {
            res = res * 10 + i % 10;
            i = i / 10;
        }
        return res;
    }

    public int countNicePairs1(int[] nums) {
        Map<Integer, Long> temp = new HashMap<>();
        Arrays.stream(nums).forEach(cur -> temp.merge(cur - rev(cur), 1L, Long::sum));
        return (int)(temp.values().stream().mapToLong(v -> v * (v - 1) / 2).sum() % 1000000007);
    }


}
