package com.wjcat.learn.leetcode;

import java.util.*;

/**
 * @Description 3、给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * Created by yupeijiang on 2019/6/25.
 */
public class ThirdSolution {


    // =============================================👇 @TODO 自写暴力法 👇=============================================//

//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 1)
//            return 1;
//        int sLength = s.length();
//        int result = 0;
//        for (int i = 0; i < sLength; i++) {
//            for (int j = i + 1; j < sLength; j++) {
//                if (s.substring(i, j).indexOf(s.charAt(j)) != -1) {
//                    result = Math.max(result, j - i);
//                    break;
//                } else if (j == (sLength - 1)) {
//                    result = Math.max(result, sLength - i);
//                }
//            }
//        }
//        System.out.println(result);
//        return result;
//    }

    // =============================================👆 @TODO 自写暴力法 👆=============================================//

    // =============================================👇 @TODO 题解暴力法 👇=============================================//
//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        int ans = 0;
//        for (int i = 0; i < n; i++)
//            for (int j = i + 1; j <= n; j++)
//                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
//        return ans;
//    }
//
//    public boolean allUnique(String s, int start, int end) {
//        Set<Character> set = new HashSet<>();
//        for (int i = start; i < end; i++) {
//            Character ch = s.charAt(i);
//            if (set.contains(ch)) return false;
//            set.add(ch);
//        }
//        return true;
//    }

    // =============================================👆 @TODO 题解暴力法 👆=============================================//

    // =============================================👇 @TODO 题解滑动窗口法 👇=============================================//

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    // =============================================👆 @TODO 题解滑动窗口法 👆=============================================//


    public static void main(String[] args) {
        ThirdSolution thirdSolution = new ThirdSolution();
        System.out.println(thirdSolution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(thirdSolution.lengthOfLongestSubstring("bbbbbbbb"));
        System.out.println(thirdSolution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(thirdSolution.lengthOfLongestSubstring("au"));
        System.out.println(thirdSolution.lengthOfLongestSubstring("aab"));
    }

}
