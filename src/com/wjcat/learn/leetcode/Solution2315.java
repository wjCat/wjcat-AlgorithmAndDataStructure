package com.wjcat.learn.leetcode;

public class Solution2315 {

    public static void main(String[] args) {
        Solution2315 solution557 = new Solution2315();
        System.out.println(solution557.countAsterisks("l|*e*et|c**o|*de|"));
        System.out.println(solution557.countAsterisks("iamprogrammer"));
        System.out.println(solution557.countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
    }

    public int countAsterisks(String s) {
        int res = 0;
        boolean temp = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                temp = !temp;
                continue;
            }
            if (temp) {
                continue;
            }
            if (s.charAt(i) == '*') {
                res++;
            }
        }
        return res;
    }

}