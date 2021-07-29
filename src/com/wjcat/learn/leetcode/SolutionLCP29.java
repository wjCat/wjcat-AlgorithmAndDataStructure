package com.wjcat.learn.leetcode;

public class SolutionLCP29 {

    public int orchestraLayout(int num, int xPos, int yPos) {
        long downLen = num - xPos - 1, rightLen = num - yPos - 1;
        long start = Math.min(xPos, Math.min(downLen, Math.min(yPos, rightLen)));
        long end = num - start - 1;
        long startIndex = ((long) num * (long) num - (end - start + 1) * (end - start + 1)) % 9 + 1;
        long res = 1;
        if (xPos == start) {
            res = (yPos - start + startIndex) % 9;
        } else if (xPos == end) {
            res = ((end - start) * 2 % 9 + startIndex + end - yPos) % 9;
        } else if (yPos == start) {
            res = ((end - start) * 3 % 9 + startIndex + end - xPos) % 9;
        } else if (yPos == end) {
            res = ((end - start) % 9 + startIndex + xPos - start) % 9;
        }
        return res == 0 ? 9 : (int) res;
    }

    public static void main(String[] args) {
        SolutionLCP29 solutionLCP29 = new SolutionLCP29();
        System.out.println(solutionLCP29.orchestraLayout(
                449572,
                209397,
                306801));
    }

}
