package com.wjcat.learn.leetcode;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution1662 {

    public static void main(String[] args) {
        Solution1662 solution1662 = new Solution1662();
        System.out.println(solution1662.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        System.out.println(solution1662.arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"a", "bc"}));
        System.out.println(solution1662.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return Objects.equals(String.join("", word1), String.join("", word2));
    }

}
