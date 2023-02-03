package com.wjcat.learn.leetcode;

public class Solution2283 {

    public static void main(String[] args) {
        Solution2283 solution2283 = new Solution2283();
        solution2283.digitCount("1288394");
    }

    public boolean digitCount(String num) {
        for (String b : num.split("")) {
            System.out.println(Integer.valueOf(b));
        }
        return true;
    }

}
