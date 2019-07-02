package com.wjcat.learn.leetcode;

/**
 * @Description 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * Created by yupeijiang on 2019/6/27.
 */
public class FifthSolution {

//    public static String longestPalindrome(String s) {
//
//        String result = "";
//        String tempResult = "";
//        for (int i = 0; i < s.length(); i++) {
//            String a = test(s, i, i);
//            String b = test(s, i, i + 1);
//            tempResult = a.length() > b.length() ? a : b;
//            result = result.length() > tempResult.length() ? result : tempResult;
//        }
//        return result;
//    }

//    private static String test(String s, int left, int right) {
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            left--;
//            right++;
//        }
//        return s.substring(left + 1, right);
//    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        boolean[][] dp = new boolean[len][len];
        // abcdedcba
        //   j   i
        // 如果 dp[j,i] = true 那么 dp[j+1,i-1] 也一定为 true
        // [j + 1,i - 1] 一定要构成至少两个元素额区间（ 1 个元素的区间，s.charAt(i)==s.charAt(j) 已经判断过了）
        // 即 j + 1 < i - 1，即 i > j + 2 (不能取等号，取到等号，就退化成 1 个元素的情况了)
        // 应该反过来写
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                // 区间应该慢慢放大
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > longestPalindrome) {
                        longestPalindrome = i - j + 1;
                        longestPalindromeStr = s.substring(j, i + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcddcba"));
    }

}
