package com.wjcat.learn.leetcode;

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
public class ForthSolution {

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

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{3, 4}));

    }

}