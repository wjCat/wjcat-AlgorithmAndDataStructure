package com.wjcat.learn.leetcode;

/**
 * @Description 7、给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 *      输入: 123
 *      输出: 321
 * 示例 2:
 *      输入: -123
 *      输出: -321
 * 示例 3:
 *      输入: 120
 *      输出: 21
 * Created by yupeijiang on 2019/7/1.
 */
public class SeventhSolution {

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        reverse(123);
    }

}
