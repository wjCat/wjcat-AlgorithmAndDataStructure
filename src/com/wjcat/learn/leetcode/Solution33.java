package com.wjcat.learn.leetcode;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class Solution33 {

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        System.out.println(solution33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(solution33.search(new int[]{1}, 0));
        System.out.println(solution33.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
        System.out.println(solution33.search(new int[]{5, 1, 2, 3, 4}, 1));
        System.out.println(solution33.search(new int[]{8, 9, 2, 3, 4}, 9));
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (target != nums[l] && target != nums[r]) {
                if (target == nums[mid]) {
                    return mid;
                } else if (target > nums[l] && target > nums[mid]) {
                    if (nums[mid] > nums[l]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else if (target > nums[l] && target < nums[mid]) {
                    if (nums[mid] > nums[l]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else if (target < nums[r] && target > nums[mid]) {
                    l = mid + 1;
                } else if (target < nums[r] && target < nums[mid]) {
                    if (nums[mid] > nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else if (target > nums[r]) {
                    return -1;
                }
            } else {
                return target == nums[l] ? l : r;
            }
        }
        return -1;
    }

}
