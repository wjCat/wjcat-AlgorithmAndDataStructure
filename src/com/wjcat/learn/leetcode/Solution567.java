package com.wjcat.learn.leetcode;

import java.util.Arrays;

public class Solution567 {

    public static void main(String[] args) {
        Solution567 solution567 = new Solution567();
//        System.out.println(solution567.checkInclusion("ab", "eidbaooo"));
//        System.out.println(solution567.checkInclusion("ab", "eidboaoo"));
        System.out.println(solution567.checkInclusion("ab", "acacbcba"));
    }

    public boolean checkInclusion(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        int[] charCount = new int[26];
        for (char c : str1) {
            charCount[c - 'a']++;
        }
        int l = 0, r = 0;
        while (l <= len2 - len1) {
            while (r < l + len1 && charCount[str2[r] - 'a'] >= 1) {
                charCount[str2[r] - 'a']--;
                r++;
            }
            if (r == l + len1) {
                return true;
            }
            charCount[str2[l] - 'a']++;
            l++;
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

}
