package com.wjcat.learn.leetcode;

import com.sun.deploy.util.ArrayUtil;

import java.io.File;
import java.util.*;

public class Solution76 {

    public String minWindow(String s, String t) {
        if (s.length() <= 0 || t.length() <= 0) return "";
        int right = 0, left = 0, min = Integer.MAX_VALUE;
        String res = "";
        HashMap<Character, Integer> temp1 = new HashMap<>();
        HashMap<Character, Integer> temp2 = new HashMap<>();
        for (Character c : t.toCharArray()) {
            temp1.put(c, temp1.getOrDefault(c, 0) + 1);
        }
        while (left < s.length() && t.indexOf(s.charAt(left)) == -1) left++;
        if (left >= s.length()) return "";
        temp2.put(s.charAt(left), temp2.getOrDefault(s.charAt(left), 0) + 1);
        while (left < s.length()) {
            while (left < s.length() && t.indexOf(s.charAt(left)) == -1) left++;
            if (left < s.length()) {
                Character c1 = s.charAt(left);
                right = (right <= left ? left + 1 : right);
                while (right < s.length() && !check(temp1, temp2)) {
                    if (temp1.containsKey(s.charAt(right)))
                        temp2.put(s.charAt(right), temp2.getOrDefault(s.charAt(right), 0) + 1);
                    right++;
                }
                if (check(temp1, temp2) && min > right - left) {
                    min = right - left;
                    res = s.substring(left, right);
                }
                temp2.put(c1, temp2.getOrDefault(c1, 0) - 1);
                left++;
            }
        }
        return res;
    }

    public boolean check(HashMap<Character, Integer> temp1, HashMap<Character, Integer> temp2) {
        for (Map.Entry<Character, Integer> param : temp1.entrySet()) {
            if (temp2.getOrDefault(param.getKey(), 0) < param.getValue()) return false;
        }
        return true;
    }

    public String minWindow1(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) {
            return "";
        }
        if (t.length() == 1) {
            return s.indexOf(t.charAt(0)) == -1 ? "" : t;
        }
        if (s.length() == t.length()) {
            char[] chars = s.toCharArray();
            char[] chars1 = t.toCharArray();
            Arrays.sort(chars);
            Arrays.sort(chars1);
            for (int i = 0; i < s.length(); i++) {
                if (chars[i] != chars1[i]) {
                    return "";
                }
            }
            return s;
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放右边移动出窗口的字符
                    l++;//指针右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

//    public String minWindow2(String s, String t) {
//        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
//            return "";
//        }
//        int[] need = new int[128];
//        for (char c : t.toCharArray()) {
//            need[c]++;
//        }
//        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
//        while (r < s.length()) {
//            char c = s.charAt(r);
//            if (need[c] > 0) {
//                count--;
//            }
//            need[c]--;
//            if (count == 0) {
//
//            }
//        }
//    }

    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        System.out.println(solution76.minWindow1("ADOBECODEBANC", "ABC"));
    }

}
