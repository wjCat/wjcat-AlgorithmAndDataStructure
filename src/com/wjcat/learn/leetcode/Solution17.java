package com.wjcat.learn.leetcode;

import java.util.*;
import java.util.logging.Handler;
import java.util.stream.Collectors;

public class Solution17 {

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.letterCombinations("23"));
    }

    Map<Character, List<String>> allElement = new HashMap<Character, List<String>>(9){{
        put('2', Arrays.asList("a", "b", "c"));
        put('3', Arrays.asList("d", "e", "f"));
        put('4', Arrays.asList("g", "h", "i"));
        put('5', Arrays.asList("j", "k", "l"));
        put('6', Arrays.asList("m", "n", "o"));
        put('7', Arrays.asList("p", "q", "r", "s"));
        put('8', Arrays.asList("t", "u", "v"));
        put('9', Arrays.asList("w", "x", "y", "z"));
    }};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        doCombinations(digits, 0, res, new ArrayDeque<>());
        return res;
    }

    private void doCombinations(String digits, int index, List<String> res, Deque<String> temp) {
        if (index >= digits.length()) {
            res.add(String.join("", temp));
            return;
        }

        for (String a : allElement.get(digits.charAt(index))) {
            temp.offer(a);
            doCombinations(digits, index + 1, res, temp);
            temp.removeLast();
        }
    }

}
