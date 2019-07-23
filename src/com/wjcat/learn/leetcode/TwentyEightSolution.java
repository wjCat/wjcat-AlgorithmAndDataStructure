package com.wjcat.learn.leetcode;

/**
 * @Description 28.实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by yupeijiang on 2019/7/11.
 */
@Deprecated
public class TwentyEightSolution {

    public static int strStr(String haystack, String needle) {

//        if (haystack == null || needle == null || haystack.length() < 1) {
//            return -1;
//        }
//
//        //如果needle为空，则返回0
//        if (needle.length() < 1) {
//            return 0;
//        }
//
//        //主字符串haystack的下标
//        int index1 = 0;
//        //模式串needle的下标
//        int index2 = 0;
//        char[] char1 = haystack.toCharArray();
//        char[] char2 = needle.toCharArray();
//        //获得nexts数组
//        int[] nexts = getNexts(char2);
//        while (index1 < char1.length && index2 < char2.length) {
//            if (char1[index1] == char2[index2]) {
//                index1++;
//                index2++;
//            } else if (nexts[index2] == -1) {//如果为第一位都不匹配则直接下一个字符
//                index1++;
//            } else {
//                index2 = nexts[index2];
//            }
//        }
//        return index2 == char2.length ? index1 - index2 : -1;
        return 0;
    }

    //获得next数组
    public static int[] getNexts(char[] str2) {
//        if (str2.length == 1) {
//            return new int[]{-1};
//        }
//        int[] nexts = new int[str2.length];
//        nexts[0] = -1;
//        nexts[1] = 0;
//        //指向当前元素最长前缀的指
//        int cn = 0;
//        //遍历字符串时的下标
//        int index = 2;
//        while (index < str2.length) {
//            if (str2[index - 1] == str2[cn]) {
//                nexts[index++] = ++cn;
//            } else if (cn > 0) {
//                cn = nexts[cn];
//            } else {
//                nexts[index++] = 0;
//            }
//        }
//        return nexts;
        return null;
    }

    public static void main(String[] args) {
        strStr("BBC ABCDAB ABCDABCDABDE", "ABCDABD");
    }

}
