package com.wjcat.learn.leetcode;

import java.util.Arrays;

/**
 * @Description 88、给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by yupeijiang on 2019/7/26.
 */
public class Solution88 {

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution88.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        if (nums1.length == 0) return;
//        if (nums2.length == 0) return;
//        int i = 0, j = 0, k = 0;
//        int[] result = new int[nums1.length];
//        while (i < m && j < n) {
//            while (i < m && j < n && nums1[i] < nums2[j])
//                result[k++] = nums1[i++];
//            while (i < m && j < n && nums1[i] >= nums2[j])
//                result[k++] = nums2[j++];
//        }
//        if (i >= m && j < n)
//            while (j < n)
//                result[k++] = nums2[j++];
//        if (i < m && j >= n)
//            while (i < m)
//                result[k++] = nums1[i++];
//        nums1 = result;
//        System.out.println(Arrays.toString(result));
//    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }

}
