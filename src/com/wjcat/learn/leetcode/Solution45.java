package com.wjcat.learn.leetcode;

/**
 * @author yupeijiang
 * @date 2020/8/4 0004
 */
public class Solution45 {

    public static void main(String[] args) {
        Solution45 s45 = new Solution45();
        System.out.println(s45.jump(new int[]{1}));
    }

    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public int jumpMine(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; ) {
            int max = 0;
            int next = 0;
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j >= nums.length - 1) {
                    return ans + 1;
                }
                if (max < j + nums[j]) {
                    max = j + nums[j];
                    next = j;
                }
            }
            if (i == next) {
                return 0;
            }
            ans++;
            i = next;
        }
        return ans;
    }

}
