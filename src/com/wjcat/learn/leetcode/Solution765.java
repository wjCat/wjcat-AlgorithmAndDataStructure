package com.wjcat.learn.leetcode;

/**
 * @author yupeijiang
 * @date 2020/8/3 0003
 */
public class Solution765 {

    public int minSwapsCouples(int[] row) {
        int ans = 0;
        for (int i = 0; i < row.length; i += 2) {
            int next = row[i] ^ 1;
            if (next == row[i + 1]) {
                continue;
            }
            ans++;
            for (int j = i + 2; j < row.length; j++) {
                if (next == row[j]) {
                    row[j] = row[i + 1];
                    row[i + 1] = next;
                    break;
                }
            }
        }
        return ans;
    }

}
