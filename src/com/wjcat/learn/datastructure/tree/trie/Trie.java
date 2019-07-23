package com.wjcat.learn.datastructure.tree.trie;

import java.util.TreeMap;

/**
 * @Description 字典树
 * Created by yupeijiang on 2019/7/3.
 */
public class Trie {

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

    public Trie() {
        this.root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.next.containsKey(c))
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    // 查询单词word是否在Trie中
    public boolean contains(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.next.containsKey(c))
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }

    public String searchLongestPrefix(){
        StringBuffer sb = new StringBuffer();
        Node cur = this.root;
        while (cur.next.keySet().size() == 1){
            Character a = new Character(' ');
            for (Character c : cur.next.keySet())
                a = c;
            sb.append(a);
            if (cur.next.get(a).isWord)
                return sb.toString();
            cur = cur.next.get(a);
        }
        return sb.toString();
    }


}
