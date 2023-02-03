package com.wjcat.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {

    public static void main(String[] args) {
        Solution118 solution118 = new Solution118();
        System.out.println(solution118.generate(11));
        System.out.println(solution118.generate(1));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

}
