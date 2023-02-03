package com.wjcat.learn.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author yupeijiang
 * @date 2020/7/21 0021
 */
public class Solution189 {

    public static void main(String[] args) {
        Solution189 solution189 = new Solution189();
        int[] param = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution189.rotate(param, 3);
        System.out.println(Arrays.toString(param));
        param = new int[]{-1, -100, 3, 99};
        solution189.rotate(param, 2);
        System.out.println(Arrays.toString(param));
        param = new int[]{1, 2};
        solution189.rotate(param, 3);
        System.out.println(Arrays.toString(param));
        param = new int[]{1, 2, 3, 4, 5, 6};
        solution189.rotate(param, 2);
        System.out.println(Arrays.toString(param));
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            swap(nums, l++, r--);
        }
        l = k;
        r = nums.length - 1;
        while (l < r) {
            swap(nums, l++, r--);
        }
        l = 0;
        r = k - 1;
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    public void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}
