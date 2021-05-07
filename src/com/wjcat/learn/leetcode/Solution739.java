package com.wjcat.learn.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Solution739 {

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> temp = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!temp.isEmpty() && T[temp.peek()] <= T[i]) {
                res[temp.peek()] = i - temp.peek();
                temp.pop();
            }
            temp.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();
        System.out.println(Arrays.toString(solution739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

}
