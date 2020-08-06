package com.wjcat.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yupeijiang
 * @date 2020/8/4 0004
 */
public class Solution321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        if(nums1.length + nums2.length < k) {
            return ans;
        }
        for(int s = Math.max(k - nums2.length, 0); s <= Math.min(nums1.length , k); s++){
            int[] merge = merge(largestSubsequence(nums1, s), largestSubsequence(nums2, k - s));
            if(isBigger(merge, ans)) {
                ans = merge;
            }
        }
        return ans;
    }

    /**
     * 获取长度为k的最大子序列
     */
    public List<Integer> getKLargestNumber(int[] nums, int k){
        int n = nums.length;
        int popCnt = n - k;
        List<Integer> res = new ArrayList<>();
        if(k == 0) {
            return res;
        }
        for(int i = 0; i < n; i++){
            while(!res.isEmpty() && res.get(res.size() - 1) < nums[i] && popCnt > 0){
                res.remove(res.size() - 1);
                popCnt--;
            }
            if(res.size() < k) {
                res.add(nums[i]);
            } else {
                popCnt--;  //注意， 这里容易漏了， 如果没有添加到数组， pop--
            }
        }
        return res;
    }

    /**
     * 合并两个有序子序列， 成为一个最大值
     * @param l1
     * @param l2
     * @return
     */
    public int[] merge(List<Integer> l1, List<Integer> l2){
        int[] res = new int[l1.size() + l2.size()];
        int l = 0, r = 0, idx = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = l; i < l1.size(); i++) {
            sb1.append(l1.get(i));
        }
        for(int i = r; i < l2.size(); i++) {
            sb2.append(l2.get(i));
        }
        String a = sb1.toString();
        String b = sb2.toString();
        while (l < l1.size() || r < l2.size()){
            if(l >= l1.size()) {
                res[idx++] = l2.get(r++);
            } else if(r >= l2.size()) {
                res[idx++] = l1.get(l++);
            } else if(a.substring(l, l1.size()).compareTo(b.substring(r, l2.size())) >= 0){
                res[idx++] = l1.get(l++);
            }else{
                res[idx++] = l2.get(r++);
            }
        }
        return res;
    }

    /**
     * 前面的数是否大于后面的数
     * @param list
     * @param ans
     * @return
     */
    public boolean isBigger(int[] list, int[] ans){
        if(ans.length == 0) {
            return true;
        }
        for(int i = 0; i < list.length; i++){
            if(list[i] > ans[i]) {
                return true;
            } else if(list[i] < ans[i]) {
                return false;
            }
        }
        return false;
    }

    private int start;

//    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        int[] result = new int[k];
//        for (int i = Math.max(k - 1, nums1.length - 1); i < nums1.length + nums2.length; i++) {
//            int[] merge = merge(largestSubsequence(nums1, k - (i - (nums1.length - 1))), largestSubsequence(nums2, i - (nums1.length - 1)));
//            if (isBigger(merge, result)) {
//                result = merge;
//            }
//        }
//        return result;
//    }
//
    public int[] largestSubsequence(int[] num, int k) {
        if (k <= 0) {
            return new int[0];
        }
        int[] result = new int[k];
        start = 0;
        for (int i = 0; i < k; i++) {
            result[i] = largestNumber(num, num.length - (k - i));
        }
        return result;
    }

    private int largestNumber(int[] num, int end) {
        int largest = -1;
        int pos = 0;
        for (int i = start; i <= end; i++) {
            if (num[i] > largest) {
                largest = num[i];
                pos = i;
            }
        }
        start = pos + 1;
        return largest;
    }

    private int[] merge(int[] num1, int[] num2) {
        List<Integer> l1 = Arrays.stream(num1).boxed().collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(num2).boxed().collect(Collectors.toList());
        int[] res = new int[l1.size() + l2.size()];
        int l = 0, r = 0, idx = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = l; i < l1.size(); i++) sb1.append(l1.get(i));
        for (int i = r; i < l2.size(); i++) sb2.append(l2.get(i));
        String a = sb1.toString();
        String b = sb2.toString();
        while (l < l1.size() || r < l2.size()) {
            if (l >= l1.size()) res[idx++] = l2.get(r++);
            else if (r >= l2.size()) res[idx++] = l1.get(l++);
            else if (a.substring(l, l1.size()).compareTo(b.substring(r, l2.size())) >= 0) {
                res[idx++] = l1.get(l++);
            } else {
                res[idx++] = l2.get(r++);
            }
        }
        return res;
    }
//
//    public boolean isBigger(int[] list, int[] ans) {
//        if (list.length != 100 || ans.length != 100) {
//            System.out.println();
//        }
//        if (ans.length == 0) {
//            return true;
//        }
//        for (int i = 0; i < list.length; i++) {
//            if (list[i] > ans[i]) {
//                return true;
//            } else if (list[i] < ans[i]) {
//                return false;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Solution321 s321 = new Solution321();
        System.out.println(Arrays.toString(s321.maxNumber(
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                100)));
    }

}
