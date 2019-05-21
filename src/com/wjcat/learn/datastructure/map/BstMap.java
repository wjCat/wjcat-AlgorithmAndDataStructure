package com.wjcat.learn.datastructure.map;

/**
 * @Description 二分搜索树映射
 * Created by 厕所里拉屎的猫 on 2019/5/21.
 */
public class BstMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node right, left;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {
        this.root = this.add(this.root, key, value);
    }

    private Node add(Node node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (node.key.compareTo(key) > 0)
            node.left = this.add(node.left, key, value);
        else if (node.key.compareTo(key) < 0)
            node.right = this.add(node.right, key, value);
        else
            node.value = value;
        return node;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        else
            return this.minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node resutlNode = node.right;
            node.right = null;
            this.size--;
            return resutlNode;

        } else {
            node.left = this.removeMin(node.left);
            return node;
        }
    }

    @Override
    public V remove(K key) {
        Node node = this.getNode(root, key);
        this.root = this.remove(root, key);
        return node == null ? null : node.value;
    }

    private Node remove(Node node, K key) {

        if (node == null)
            return null;

        if (node.key.compareTo(key) > 0) {
            node.left = this.remove(node.left, key);
            return node;
        } else if (node.key.compareTo(key) < 0) {
            node.right = this.remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                Node newNode = this.minimum(node.right);
                newNode.right = this.removeMin(node.right);
                newNode.left = node.left;
                node.left = node.right = null;
                size--;
                return newNode;
            }
        }
    }

    private Node getNode(Node node, K key) {
        if (node == null)
            return null;

        if (node.key.compareTo(key) > 0)
            return this.getNode(node.left, key);
        else if (node.key.compareTo(key) < 0)
            return this.getNode(node.right, key);
        else
            return node;
    }

    @Override
    public boolean contains(K key) {
        return this.getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = this.getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        this.add(key, newValue);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

}
