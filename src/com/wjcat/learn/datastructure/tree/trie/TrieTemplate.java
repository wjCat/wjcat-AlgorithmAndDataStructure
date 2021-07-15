package com.wjcat.learn.datastructure.tree.trie;

import java.util.TreeMap;

/**
 * @Description 字典树
 * Created by yupeijiang on 2019/7/3.
 */
public class TrieTemplate {

    private class Node {

        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.next = new TreeMap<>();
            this.isWord = isWord;
        }

        public Node() {
            this(false);
        }

    }

    private Node root;
    private int size;

    public TrieTemplate() {
        this.root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {

    }

    // 查询单词word是否在Trie中
    public boolean contains(String word) {
        return false;
    }

    public String searchLongestPrefix(){
        return "";
    }


}
