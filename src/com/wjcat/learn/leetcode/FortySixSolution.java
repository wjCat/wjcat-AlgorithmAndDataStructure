package com.wjcat.learn.leetcode;

import java.util.*;

public class FortySixSolution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, new LinkedList<>());
        return result;
    }

    public void permute(int[] nums, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int num : nums) {
            if (!temp.contains(num)) {
                temp.add(num);
                permute(nums, temp);
                temp.remove((Integer) num);
            }
        }
    }

    public static void main(String[] args) {
        FortySixSolution fortySixSolution = new FortySixSolution();
        System.out.println(fortySixSolution.permute(new int[]{1, 2, 3}));
    }

}
