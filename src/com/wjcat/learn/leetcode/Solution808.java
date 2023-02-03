package com.wjcat.learn.leetcode;

public class Solution808 {

    public static void main(String[] args) {
        Solution808 solution808 = new Solution808();
        System.out.println(solution808.soupServings(50));
        System.out.println(solution808.soupServings(100));
    }

    int[][] operations = new int[][]{{100, 0}, {75, 25}, {50, 50}, {25, 75}};

    public double soupServings(int n) {
        double[] backup = new double[]{0, 0};
        for (int i = 0; i < 4; i++) {
            doServing(operations[i], n, n, backup);
        }
        return backup[1] / (backup[0] + backup[1]);
    }

    public void doServing(int[] operation, int an, int bn, double[] backup) {
        if (an <= 0 && bn <= 0) {
            backup[0] = backup[0] + 0.125;
            return;
        }
        if (an <= 0) {
            backup[1] = backup[1] + 0.25;
            return;
        }
        if (bn <= 0) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            doServing(operations[i], an - operation[0], bn - operation[1], backup);
        }
    }

}
