package com.wjcat.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yupeijiang
 * @date 2020/8/4 0004
 */
public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        return doFind(coins, amount);
    }

    private int doFind(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int rIndex = coins.length - 1;
        boolean exist = false;
        int min = Integer.MAX_VALUE;
        for (int i = rIndex; i >= 0; i--) {
            int temp = doFind(coins, amount - coins[i]);
            if (temp != -1) {
                exist = true;
                min = Math.min(min, temp + 1);
            }
        }
        return exist ? min : -1;
    }

    public static void main(String[] args) {
        Solution322 s322 = new Solution322();
        System.out.println(s322.coinChange(new int[]{186,419,83,408}, 6249));
    }

}