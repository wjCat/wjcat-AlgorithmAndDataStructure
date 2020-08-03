package com.wjcat.learn.leetcode;

/**
 * @author yupeijiang
 * @date 2020/8/3 0003
 */
public class Solution55 {

    public static void main(String[] args) {
        Solution55 fiftyFiveSolution = new Solution55();
        fiftyFiveSolution.canJump(new int[]{2,3,1,1,4});
    }

    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex == i) {
                break;
            } else if (maxIndex > nums.length - 1) {
                return true;
            }
        }
        return maxIndex >= nums.length - 1;
    }

}
