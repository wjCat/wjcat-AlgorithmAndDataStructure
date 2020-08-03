package com.wjcat.learn.leetcode;

/**
 * @author yupeijiang
 * @date 2020/7/17 0017
 */
public class Solution91 {

    public static void main(String[] args) {
        String a = "34123412341";
        for (int i = 0; i < a.length(); i++) {
            System.out.println(a.charAt(i));
        }
//        System.out.println(numDecodings("226"));
    }

    public static int numDecodings(String s) {
        int[] temp = new int[s.length()];
        if (s.charAt(0) != '0') {
            temp[0] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            int n = 0;
            if (s.charAt(i) != '0') {
                n = temp[i - 1];
            }
            if (s.charAt(i - 1) != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                if (i == 1) {
                    n += 1;
                } else {
                    n += temp[i - 2];
                }
            }
            temp[i] = n;
        }
        return temp[s.length() - 1];
    }

}
