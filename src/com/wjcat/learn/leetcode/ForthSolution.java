package com.wjcat.learn.leetcode;

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
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{3,4}));

    }

}