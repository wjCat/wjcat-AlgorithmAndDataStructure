package com.wjcat.learn.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Description 9、回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 *      输入: 121
 *      输出: true
 * 示例 2:
 *      输入: -121
 *      输出: false
 *      解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *      输入: 10
 *      输出: false
 *      解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by yupeijiang on 2019/7/1.
 */
public class Solution9 {

    public boolean isPalindrome(int x) {

//        if (x < 0)
//            return false;
//
//        int div = 1;
//
//        while (x / div >= 10) div *= 10;
//
//        while (x > 0){
//            int left = x / div;
//            int right = x % 10;
//            if (left != right) return false;
//            x = x % div / 10;
//            div /= 100;
//        }
//        return true;

        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = 10 * revertedNumber + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber/10;

    }

}
