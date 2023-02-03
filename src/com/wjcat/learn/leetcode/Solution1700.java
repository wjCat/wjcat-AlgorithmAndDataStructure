package com.wjcat.learn.leetcode;

import java.util.Arrays;

public class Solution1700 {

    public static void main(String[] args) {
        Solution1700 solution1700 = new Solution1700();
        System.out.println(solution1700.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println(solution1700.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
        System.out.println(solution1700.countStudents(new int[]{1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0}, new int[]{0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0}));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int a = (int) Arrays.stream(students).filter(e -> e == 0).count();
        int b = (int) Arrays.stream(students).filter(e -> e == 1).count();
        for (int i = 0; i < sandwiches.length && (a > 0 || b > 0); i++) {
            if (sandwiches[i] == 0 && a > 0) {
                a--;
            } else if (sandwiches[i] == 1 && b > 0) {
                b--;
            } else {
                break;
            }
        }
        return a + b;
    }

}
