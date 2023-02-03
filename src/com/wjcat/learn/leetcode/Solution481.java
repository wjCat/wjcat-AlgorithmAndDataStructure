package com.wjcat.learn.leetcode;

public class Solution481 {

    public static void main(String[] args) {
        Solution481 solution481 = new Solution481();
//        System.out.println(solution481.magicalString(6));
//        System.out.println(solution481.magicalString(1));
        System.out.println(solution481.magicalString(4));
    }

    public int magicalString(int n) {
        if (n < 3) {
            return 1;
        }
        int[] temp = new int[n];
        temp[0] = 1;
        temp[1] = 2;
        temp[2] = 2;
        int left = 1;
        int right = 2;
        int res = 1;
        int count;
        int before = 2;
        while (right + 1 < n) {
            count = temp[++left];
            int current = before ^ 3;
            while (count > 0 && right + 1 < n) {
                temp[++right] = current;
                count--;
                if (current == 1) {
                    res++;
                }
            }
            before = current;
        }
        return res;
    }

}
