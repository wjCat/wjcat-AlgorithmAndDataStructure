package com.wjcat.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {

    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        solution39.combinationSum(new int[]{2, 3, 6, 7}, 7).forEach(e -> {
            System.out.print("[");
            e.forEach(i -> System.out.print(i + ","));
            System.out.print("],");
        });
        System.out.println();
        solution39.combinationSum(new int[]{2, 3, 5}, 8).forEach(e -> {
            System.out.print("[");
            e.forEach(i -> System.out.print(i + ","));
            System.out.print("],");
        });
        System.out.println();
        solution39.combinationSum(new int[]{2}, 1).forEach(e -> {
            System.out.print("[");
            e.forEach(i -> System.out.print(i + ","));
            System.out.print("],");
        });
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            int finalI = i;
            if (target == candidates[finalI]) {
                res.add(new ArrayList<Integer>(){{add(candidates[finalI]);}});
                continue;
            }
            List<List<Integer>> temp = doCombination(candidates, target - candidates[i], i);
            temp.forEach(e -> e.add(0, candidates[finalI]));
            res.addAll(temp);
        }
        return res;
    }

    private List<List<Integer>> doCombination(int[] candidates, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (Arrays.stream(candidates).allMatch(e -> target < e)) {
            return res;
        }
        for (int i = start; i < candidates.length; i++) {
            int current = candidates[i];
            if (current == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(current);
                res.add(temp);
            } else {
                List<List<Integer>> after = doCombination(candidates, target - current, i);
                if (!after.isEmpty()) {
                    after.forEach(e -> e.add(0, current));
                    res.addAll(after);
                }
            }
        }
        return res;
    }

}
