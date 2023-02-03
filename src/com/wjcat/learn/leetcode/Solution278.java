package com.wjcat.learn.leetcode;

import java.util.Arrays;

/**
 * @author yupeijiang
 * @date 2020/8/7 0007
 */
public class Solution278 {

    public static void main(String[] args) {
        Solution278 solution278 = new Solution278();
        System.out.println(solution278.firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        int l = 0, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int i) {
        return i <= 4;
    }

}
