package com.wjcat.learn.leetcode;

public class TenSolution {

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch2("aab", "c*a*b"));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] temp = new boolean[s.length() + 1][p.length() + 1];
        temp[0][0] = true;
        for (int i = 1; i <= s.length(); i++) {
            boolean charVerify = false;
            for (int j = 1; j <= p.length(); j++) {
                if (j < p.length() && '*' == p.charAt(j)) {
                    if ('.' == p.charAt(j - 1)) {
                        charVerify = true;
                        temp[i][j] = true;
                    } else {
                        if (s.charAt(i - 1) == p.charAt(j - 1)) {
                            charVerify = true;
                            temp[i][j] = true;
                        }
                    }
                    j++;
                } else if ('.' == p.charAt(j - 1)) {
                    if (p.charAt(j - 2) == '*' || temp[i - 1][j - 1]) {
                        charVerify = true;
                        temp[i][j] = true;
                    }
                } else {
                    if (((j > 1 && p.charAt(j - 2) == '*') || temp[i - 1][j - 1]) && s.charAt(i - 1) == p.charAt(j - 1)) {
                        charVerify = true;
                        temp[i][j] = true;
                    }
                }
            }
            if (!charVerify) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMatch2(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean isOccupy = !s.isEmpty() && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch2(s, p.substring(2)) ||
                    (isOccupy && isMatch2(s.substring(1), p));
        } else if (isOccupy) {
            return isMatch2(s.substring(1), p.substring(1));
        } else {
            return false;
        }
    }

}
