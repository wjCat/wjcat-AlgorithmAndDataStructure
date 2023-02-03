package com.wjcat.learn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 1、给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 *      给定 nums = [2, 7, 11, 15], target = 9
 *      因为 nums[0] + nums[1] = 2 + 7 = 9
 *      所以返回 [0, 1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by yupeijiang on 2019/6/24.
 */
public class Solution1 {

    public static int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i<nums.length;i++) {
//            for (int j = 0; j<nums.length;j++){
//                if ((nums[i] + nums[j]) == target && i != j)
//                    return new int[]{i, j};
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");

//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++)
//            map.put(nums[i], i);
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement) && map.get(complement) != i)
//                return new int[]{i, map.get(complement)};
//        }
//        throw new IllegalArgumentException("No two sum solution");

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        int[] a = new int[]{0, 0, 0};
        for (int i = 0; i < a.length; i++) {
            System.out.println(--a[i] == -1);
        }
        System.out.println(Arrays.toString(a));
    }

}
