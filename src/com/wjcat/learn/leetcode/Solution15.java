package com.wjcat.learn.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        int index = 0;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums[0] >= 0 || nums[nums.length - 1] <= 0) {
            return res;
        }
        while (index < nums.length && nums[index] < 0) {
            int tempTarget = -nums[index];
            Map<Integer, Integer> tempMap = new HashMap<>(nums.length - index);
            for (int k = index + 1; k < nums.length; k++) {
                if (tempMap.containsKey(nums[k])) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[index]);
                    l.add(nums[k]);
                    l.add(tempMap.get(nums[k]));
                    l = l.stream().sorted().collect(Collectors.toList());
                    if (!res.contains(l)) {
                        res.add(l);
                    }
                }
                tempMap.put(tempTarget - nums[k], nums[k]);
            }
            index++;
        }
        if (index < nums.length && nums[index] == 0 && index + 2 < nums.length && nums[index + 2] == 0) {
            List<Integer> l = new ArrayList<>();
            l.add(0);
            l.add(0);
            l.add(0);
            res.add(l);
        }
        return res;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        Map<Integer, List<Integer>> resMap = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                if (!resMap.containsKey(nums[i] + nums[j])) {
                    List<Integer> subList = new ArrayList<>();
                    subList.add(i);
                    subList.add(j);
                    resMap.put(nums[i] + nums[j], subList);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (resMap.containsKey(-nums[i])) {
                List<Integer> subList = resMap.get(-nums[i]);
                if (subList.get(1) <= i) {
                    List<Integer> subRes = new ArrayList<>();
                    subRes.add(nums[subList.get(0)]);
                    subRes.add(nums[subList.get(1)]);
                    subRes.add(nums[i]);
                    res.add(subRes);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        threeSum2(new int[]{-1, 0, 1, 2, -1, -4}).forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - start);
    }

}
