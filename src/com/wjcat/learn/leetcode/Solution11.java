package com.wjcat.learn.leetcode;

public class Solution11 {

    /**
     * 最普通的方法
     */
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return res;
    }

    /**
     * 遍历每个元素，中间扩散去看每一个高度的最大面积（优化版本1）
     */
    public int maxArea1(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int point = 0;
            while (point < i && height[point] < height[i]) point++;
            res = Math.max(res, (i - point) * height[i]);
            point = height.length - 1;
            while (point > i && height[point] < height[i]) point--;
            res = Math.max(res, (point - i) * height[i]);
        }
        return res;
    }

    /**
     * 双指针，左右开弓，数值小的已达最大，数值大的继续留着（优化版本2）
     */
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    /**
     * 基于优化版本2，更新为三元运算符（优化版本2）
     */
    public int maxArea3(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        while (left < right)
            res = Math.max(res, (right - left) * (height[left] < height[right] ? height[left++] : height[right--]));
        return res;
    }


    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.maxArea(new int[]{1, 2, 1}));
    }

}
