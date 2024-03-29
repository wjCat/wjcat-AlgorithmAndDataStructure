package com.wjcat.learn.leetcode;

import java.util.Arrays;

/**
 * @Description 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by yupeijiang on 2019/7/11.
 */
public class Solution27 {

    public int removeElement(int[] nums, int val) {
        int j = nums.length;
        for (int i = 0; i <= j; ) {
            if (nums[i] == val) {
                nums[i] = nums[j - 1];
                j--;
            } else
                i++;
        }
        return j;
    }

    public int removeElement1(int[] nums, int val) {
        int l = 0;
        int r = 0;
        while (l <= r && r < nums.length) {
            if (nums[r] != val) {
                nums[l++] = nums[r];
            }
            r++;
        }
        System.out.println(l + 1);
        return l + 1;
    }

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        int[] param = new int[]{3, 2, 2, 3};
        solution27.removeElement1(param, 3);
        int[] param2 = new int[]{3, 2, 2, 3};
        solution27.removeElement(param2, 3);
        System.out.println(Arrays.toString(param));
        System.out.println(Arrays.toString(param2));
    }

}
