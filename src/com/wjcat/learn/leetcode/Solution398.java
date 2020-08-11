package com.wjcat.learn.leetcode;

import java.util.Random;

/**
 * @author yupeijiang
 * @date 2020/8/7 0007
 */
public class Solution398 {

    int[] nums;

    public Solution398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        Random random = new Random();
        int resultIndex = 0;
        int hitNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                hitNum++;
                if (hitNum <= 1) {
                    resultIndex = i;
                } else {
                    int randomNumber = random.nextInt(hitNum);
                    if (randomNumber < 1) {
                        resultIndex = i;
                    }
                }
            }
        }
        return resultIndex;
    }

}
