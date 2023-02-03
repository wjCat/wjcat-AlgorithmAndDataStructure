package com.wjcat.learn.leetcode;

import java.util.Arrays;

public class Solution557 {

    public static void main(String[] args) {
        Solution557 solution557 = new Solution557();
        System.out.println(solution557.reverseWords("Let's take LeetCode contest"));
        System.out.println(solution557.reverseWords("God Ding"));
    }

    public String reverseWords(String s) {
        char[] sc = s.toCharArray();
        int length = sc.length;
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && sc[i] != ' ') {
                i++;
            }

            int left = start, right = i - 1;
            while (left < right) {
                swap(sc, left, right);
                left++;
                right--;
            }
            while (i < length && sc[i] == ' ') {
                i++;
            }
        }
        return String.valueOf(sc);
    }

    public static void swap(char[] array, int i, int j) {
        char t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        for (String ss: s.split(" ")) {
            int i = ss.length() - 1;
            while (i >= 0) {
                sb.append(ss.charAt(i--));
            }
            sb.append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

}