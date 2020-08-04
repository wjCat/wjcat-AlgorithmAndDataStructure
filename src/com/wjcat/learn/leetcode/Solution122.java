package com.wjcat.learn.leetcode;

/**
 * @author yupeijiang
 * @date 2020/8/3 0003
 */
public class Solution122 {

    public static void main(String[] args) {
        Solution122 s122 = new Solution122();
        s122.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            profit += Math.max(0, prices[i + 1] - prices[i]);
        }
        return profit;
    }

}
