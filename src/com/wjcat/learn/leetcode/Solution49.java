package com.wjcat.learn.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())).values());
    }

    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        List<List<String>> lists = solution49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println();
    }

}
