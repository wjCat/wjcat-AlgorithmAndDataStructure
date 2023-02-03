package com.wjcat.learn.leetcode;

import java.util.*;

public class Solution40 {

    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        System.out.println(solution40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(solution40.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, Deque<Integer> temp, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.offer(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, temp, res);
            temp.removeLast();
        }
    }

}
