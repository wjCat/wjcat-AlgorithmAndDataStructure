package com.wjcat.learn.leetcode;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class ThirtyTwoSolution {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }

    public static int longestValidParentheses(String s) {
        int[] temp = new int[s.length()];
        int top = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    temp[i] = (i >= 2 ? temp[i - 2] : 0) + 2;
                } else if (temp[i - 1] > 0 && i - temp[i - 1] > 0 && s.charAt(i - temp[i - 1] - 1) == '(') {
                    temp[i] = temp[i - 1] + 2 + ((i - temp[i - 1]) >= 2 ? temp[i - temp[i - 1] - 2] : 0);
                }
                top = Math.max(top, temp[i]);
            }
        }
        return top;
    }

}
