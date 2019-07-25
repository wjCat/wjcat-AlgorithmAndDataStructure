package com.wjcat.learn.leetcode;

/**
 * @Description 67、给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by yupeijiang on 2019/7/24.
 */
public class SixtySevenSolution {

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int temp = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int p = i < 0 ? 0 : Integer.parseInt(String.valueOf(a.charAt(i)));
            int q = j < 0 ? 0 : Integer.parseInt(String.valueOf(b.charAt(j)));
            result.insert(0, ((q + p + temp) % 2));
            temp = (q + p + temp) / 2;
            i--;
            j--;
        }
        if (temp > 0)
            return temp + result.toString();
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "11"));
    }

}
