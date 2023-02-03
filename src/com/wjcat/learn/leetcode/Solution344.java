package com.wjcat.learn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution344 {

    public static void main(String[] args) {
        Solution344 solution344 = new Solution344();
        char[] param = new char[]{'h','e','l','l','o'};
        solution344.reverseString(param);
        System.out.println(Arrays.toString(param));
        param = new char[]{'H','a','n','n','a','h'};
        solution344.reverseString(param);
        System.out.println(Arrays.toString(param));
    }

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            swap(s, l, r);
            l++;
            r--;
        }
    }

    public void swap(char[] array, int i, int j) {
        char t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}