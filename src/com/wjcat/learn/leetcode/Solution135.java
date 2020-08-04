package com.wjcat.learn.leetcode;

/**
 * @author yupeijiang
 * @date 2020/8/4 0004
 */
public class Solution135 {

    public static void main(String[] args) {
        Solution135 s135 = new Solution135();
        System.out.println(s135.candy(new int[]{1,6,10,8,7,3,2}));
    }

    public int candy(int[] ratings) {
        int ans = 1, pre = 1, high = 0, diff = 0;
        boolean down = false;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                down = false;
                diff = 0;
                high = i;
                ans = ans + ++pre;
                diff = 0;
            } else if (ratings[i] == ratings[i - 1]) {
                down = false;
                diff = 0;
                high = i;
                pre = 1;
                ans = ans + pre;
            } else {
                if (!down) {
                    diff = pre - 1;
                    pre = 1;
                    down = true;
                    if (diff == 0) {
                        ans = ans + 2;
                    } else {
                        ans = ans + 1;
                    }
                } else {
                    if (diff <= 1) {
                        ans = ans + i - high + 1;
                    } else {
                        diff--;
                        ans = ans + i - high;
                    }
                }
            }
        }
        return ans;
    }

}
