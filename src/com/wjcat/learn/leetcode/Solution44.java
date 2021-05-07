package com.wjcat.learn.leetcode;

public class Solution44 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            boolean temp = false;
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                temp = temp || dp[i][j];
            }
            if (!temp) {
                break;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        System.out.println(solution44.isMatch("asdjfsdfiouwerlnmcvzxbnovjhasdfiasfoiqwerfbzcvzxcvzx", "*?sdjfsd?io"));
    }

}
