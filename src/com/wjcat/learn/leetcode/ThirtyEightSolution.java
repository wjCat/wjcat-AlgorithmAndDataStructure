package com.wjcat.learn.leetcode;

/**
 * @Description 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by yupeijiang on 2019/7/11.
 */
public class ThirtyEightSolution {

    public static String countAndSay(int n) {
        return countAndSay("1", n);
    }

    private static String countAndSay(String s, int count) {
        if (count == 1) return s;
        StringBuilder result = new StringBuilder();
        int j = 0;
        while (j < s.length()) {
            int i = 1;
            while (j < s.length() - 1 && s.charAt(j) == s.charAt(j + 1)) {
                i++;
                j++;
            }
            result.append(Integer.toString(i) + s.charAt(j));
            j++;
        }
        return countAndSay(result.toString(), count - 1);
    }

    private static String countHelper(String str, int n) {
        if (n == 1) return str;
        else {
            //求下一个数
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            //一直读数
            while (i < str.length()) {
                int count = 1;
                //如果一直是同一个数
                while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                    i++;
                }
                //下一个数更新
                stringBuilder.append(Integer.toString(count) + str.charAt(i));
                i++;
            }
            str = stringBuilder.toString();
            return countHelper(str, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
    }

}
