package com.wjcat.learn.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yupeijiang
 * @date 2020/7/21 0021
 */
public class Solution131 {

    List<List<String>> result;
    int len;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        len = s.length();
        Stack<String> stack = new Stack<>();
        backtracking(s, 0, stack);
        return result;
    }

    private void backtracking(String s, int start, Stack<String> stack) {
        if (start == len) {
            result.add(new ArrayList<>(stack));
        } else {
            for (int i = start; i < len; i++) {
                if (checkPalindrome(s, start, i)) {
                    stack.push(s.substring(start, i + 1));
                    backtracking(s, i + 1, stack);
                    stack.pop();
                }
            }
        }
    }

    private boolean checkPalindrome(String str, int left, int right) {
        // 严格小于即可
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
