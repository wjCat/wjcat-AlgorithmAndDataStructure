package com.wjcat.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 4、寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] aux = merge(nums1, nums2);
        int i = aux.length % 2;
        int j = aux.length / 2;
        if (i == 0)
            return (aux[j] + aux[j - 1]) / 2.0;
        else
            return aux[j];
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int[] aux = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i >= nums1.length)
                while (j < nums2.length && k < aux.length)
                    aux[k++] = nums2[j++];
            else if (j >= nums2.length)
                while (i < nums1.length && k < aux.length)
                    aux[k++] = nums1[i++];
            else {
                while (j < nums2.length && i < nums1.length && nums1[i] <= nums2[j])
                    aux[k++] = nums1[i++];
                while (j < nums2.length && i < nums1.length && nums1[i] >= nums2[j])
                    aux[k++] = nums2[j++];
            }
        }
        return aux;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if ((length1 + length2) % 2 == 1) {
            return doFind(nums1, nums2, 0, 0, (length1 + length2) / 2 + 1);
        } else {
            return (doFind(nums1, nums2, 0, 0, (length1 + length2) / 2) + doFind(nums1, nums2, 0, 0, (length1 + length2) / 2 + 1)) * 0.5;
        }
    }

    private static double doFind(int[] nums1, int[] nums2, int aIndex, int bIndex, int k) {
        if (aIndex >= nums1.length) {
            return nums2[bIndex + k - 1];
        }
        if (bIndex >= nums2.length) {
            return nums1[aIndex + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[aIndex], nums2[bIndex]);
        }

        int temp = k / 2 - 1;

        if (aIndex + temp >= nums1.length) {
            if (nums1[nums1.length - 1] >= nums2[bIndex + temp]) {
                return doFind(nums1, nums2, aIndex, bIndex + k / 2, k - k / 2);
            } else {
                return nums2[bIndex + (k - 1) - (nums1.length - aIndex)];
            }
        }

        if (bIndex + temp >= nums2.length) {
            if (nums2[nums2.length - 1] >= nums1[aIndex + temp]) {
                return doFind(nums1, nums2, aIndex + k / 2, bIndex, k - k / 2);
            } else {
                return nums1[aIndex + (k - 1) - (nums2.length - bIndex)];
            }
        }

        if (nums1[aIndex + temp] >= nums2[bIndex + temp]) {
            return doFind(nums1, nums2, aIndex, bIndex + k / 2, k - k / 2);
        } else {
            return doFind(nums1, nums2, aIndex + k / 2, bIndex, k - k / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays2(new int[]{10, 11, 12}, new int[]{4, 5, 6}));
    }

}