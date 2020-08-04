package com.wjcat.learn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author yupeijiang
 * @date 2020/8/4 0004
 */
public class Solution316 {

    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();
        HashSet<Character> seen = new HashSet<>();
        HashMap<Character, Integer> lastOccurrence = new HashMap<>(16);
        for(int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!seen.contains(c)){
                while(!stack.isEmpty() && c < stack.peek() && lastOccurrence.get(stack.peek()) > i){
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) {
            sb.append(c.charValue());
        }
        return sb.toString();
    }

}
