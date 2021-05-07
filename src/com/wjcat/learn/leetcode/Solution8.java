package com.wjcat.learn.leetcode;

import java.util.Stack;

public class Solution8 {

    public int myAtoi(String s) {
        int flow = 0;
        boolean flag = true;
        boolean hasFlag = false;
        StringBuilder sb = new StringBuilder();
        a :for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                flow = 1;
            }
            if (flow == 1) {
                flag = !(s.charAt(i) == '-');
                hasFlag = s.charAt(i) == '-' || s.charAt(i) == '+';
                flow = 2;
            }
            if (flow == 2) {
                for (int j = hasFlag ? i + 1 : i; j < s.length(); j++) {
                    if (Character.isDigit(s.charAt(j))) {
                        if (s.charAt(j) == '0') {
                            i++;
                        } else {
                            flow = 3;
                            break;
                        }
                    } else {
                        return 0;
                    }
                }
            }
            if (flow == 3) {
                for (int j = hasFlag ? i + 1 : i; j < s.length(); j++) {
                    if (Character.isDigit(s.charAt(j))) sb.append(s.charAt(j));
                    else break a;
                }
                break;
            }
        }
        if (sb.length() == 0) {
            return 0;
        } else if (sb.length() > 10) {
            return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            long res = Long.parseLong(sb.toString());
            res = flag ? res : -res;
            if (res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int) res;
            }
        }
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        System.out.println(solution8.myAtoi("words and 987"));
    }

}
