package com.wjcat.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yupeijiang
 * @date 2020/7/20 0020
 */
public class Solution784 {

    public static void main(String[] args) {
        System.out.println('a' + 1);
        System.out.println('z' + 1);
//        System.out.println('b' + 1);
//        System.out.println('c' + 1);
        System.out.println('A' + 1);
//        System.out.println('B' + 1);
//        System.out.println('C' + 1);
//        System.out.println('1' + 1);
//        System.out.println('2' + 1);
//        System.out.println('3' + 1);
//        System.out.println('4' + 1);
        System.out.println('a' - 'A');
        System.out.println('b' - 'B');
        System.out.println('c' - 'C');
        System.out.println('A' >= 66);
        System.out.println('z' <= 122);

    }

//    public List<String> letterCasePermutation(String S) {
//        int len = S.length();
//        List<String> res = new ArrayList<>();
//        if (len == 0) {
//            return res;
//        }
//        char[] charArray = new char[len];
//        dfs(S, 0, len, charArray, res);
//        return res;
//    }
//
//    private void dfs(String S, int start, int len, char[] charArray, List<String> res) {
//        if (start == len) {
//            res.add(new String(charArray));
//            return;
//        }
//        charArray[start] = S.charAt(start);
//        dfs(S, start + 1, len, charArray, res);
//
//        // 如果是字符，就可以派生出一个新分支
//        if (Character.isLetter(S.charAt(start))) {
//            // 这一步直接修改，相当于回溯
//            charArray[start] = (char) (S.charAt(start) ^ (1 << 5));
//            dfs(S, start + 1, len, charArray, res);
//        }
//    }

    public List<String> letterCasePermutation(String S) {
        int len = S.length();
        List<String> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        char[] charArray = new char[len];
        dfs(S, 0, len, charArray, result);
        return result;
    }

    public void dfs(String S, int index, int len, char[] charArray, List<String> res) {
        if (index == len) {
            res.add(new String(charArray));
            return;
        }
        charArray[index] = S.charAt(index);
        dfs(S, index + 1, len, charArray, res);
        if (Character.isLetter(S.charAt(index))) {
            charArray[index] = (char) (S.charAt(index) ^ (1 << 5));
            dfs(S, index + 1, len, charArray, res);
        }
    }

}
