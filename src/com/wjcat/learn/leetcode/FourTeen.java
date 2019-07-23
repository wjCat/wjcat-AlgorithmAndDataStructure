package com.wjcat.learn.leetcode;

import com.wjcat.learn.datastructure.tree.trie.Trie;

/**
 * @Description 14、最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by yupeijiang on 2019/7/3.
 */
public class FourTeen {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        Trie trie = new Trie();
        for (int i = 0; i < strs.length ; i++) {
            if (strs[i].isEmpty())
                return "";
            trie.add(strs[i]);
        }
        return trie.searchLongestPrefix();

    }

    class Node{
        String str;
        Node next;

        public Node(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        String[] a = {"a","aa"};
        System.out.println(longestCommonPrefix(a));
    }

}
