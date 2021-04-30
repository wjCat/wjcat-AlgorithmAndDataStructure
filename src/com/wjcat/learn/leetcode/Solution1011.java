package com.wjcat.learn.leetcode;

import java.util.Arrays;

public class Solution1011 {

    public int shipWithinDays(int[] weights, int D) {
        // 如果直接运输weights.length次，最小运载重量就是weights中最重的，是该题的最小解答值
        int min = Arrays.stream(weights).max().orElse(0);
        // 如果直接运输1次，最小运载重量就是weights的总和，也是该题的最大解答值
        int max = Arrays.stream(weights).sum();
        // 使用二分进行轮询，按照题目给出的D次，轮询出最小的解答值
        while (min < max) {
            // 使用最多次和最少次的总和除2，得出中间值进行运算
            int mid = (min + max) / 2, cur = 0, need = 1;
            for (int weight : weights) {
                // 如果超出了该次的运载重量，则多加一次运输
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                // 统计该次运输的总重量
                cur += weight;
            }
            // 判断次数是否跟题目给的匹配
            // 如果小，则可以把最大值缩小到中间值，因为[min, mid]中间才是题目的次数
            if (need <= D) {
                max = mid;
            }
            // 否则，应该要把最小值增大，再去做轮询，因为[mid+1, max]中间才是题目的次数
            else {
                min = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution1011 solution1011 = new Solution1011();
        System.out.println(solution1011.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }

}
