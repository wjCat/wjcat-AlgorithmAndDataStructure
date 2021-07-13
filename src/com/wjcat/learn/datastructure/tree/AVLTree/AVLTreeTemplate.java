package com.wjcat.learn.datastructure.tree.AVLTree;

import java.util.ArrayList;

public class AVLTreeTemplate<K extends Comparable<K>, V> {

    private class Node {
        K key;
        V value;
        Node left, right;
        int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTreeTemplate() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 获取元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return 0;
    }

    /**
     * 判断是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * 判断二叉树是否是一颗二分搜索树
     *
     * @return 是否为二分搜索树
     */
    public boolean isBST() {
        return false;
    }

    /**
     * 将二叉树按照中序遍历，存储到keys中(中序，将以二叉树的key的排序按正序输出)
     *
     * @param node 树节点
     * @param keys key集合
     */
    private void inOrder(Node node, ArrayList<K> keys) {
        return;
    }

    /**
     * 判断是否为平衡二叉树
     *
     * @return 是否为平衡二叉树
     */
    public boolean isBalanced() {
        return false;
    }

    /**
     * 递归判断是否为平衡二叉树
     *
     * @param node 树节点
     * @return 是否平衡
     */
    private boolean isBalanced(Node node) {
        return false;
    }

    // ================================================== 👇平衡二叉树保持平衡的辅助函数👇 ==================================================//

    /**
     * 获得节点node的高度
     *
     * @param node 节点
     * @return 高度
     */
    private int getHeight(Node node) {
        return 0;
    }

    /**
     * 获取节点node的平衡因子
     *
     * @param node 节点
     * @return 平衡因子
     */
    private int getBalanceFactor(Node node) {
        return 0;
    }

    /**
     * 向右旋转
     *
     * @param node 需要旋转的根节点
     * @return 旋转后的根节点
     */
    private Node rightRotate(Node node) {
        // 对节点y进行向右旋转操作，返回旋转后新的根节点x
        //        y                              x
        //       / \                           /   \
        //      x   T4     向右旋转 (y)        z     y
        //     / \       - - - - - - - ->    / \   / \
        //    z   T3                       T1  T2 T3 T4
        //   / \
        // T1   T2
        return null;
    }

    /**
     * 向左旋转
     *
     * @param node 需要旋转的根节点
     * @return 旋转后的根节点
     */
    private Node leftRotate(Node node) {
        // 对节点y进行向左旋转操作，返回旋转后新的根节点x
        //    y                             x
        //  /  \                          /   \
        // T1   x      向左旋转 (y)       y     z
        //     / \   - - - - - - - ->   / \   / \
        //   T2  z                     T1 T2 T3 T4
        //      / \
        //     T3 T4
        return null;
    }

    // ================================================== 👆平衡二叉树保持平衡的辅助函数👆 ==================================================//

    // ================================================== 👇添加元素👇 ==================================================//

    /**
     * 添加元素
     *
     * @param key   元素键
     * @param value 元素值
     */
    public void add(K key, V value) {

    }

    /**
     * （私有）递归添加元素
     *
     * @param node  根节点（相对）
     * @param key   元素键
     * @param value 元素值
     * @return 树（子树）
     */
    private Node add(Node node, K key, V value) {
        return null;
    }

    // ================================================== 👆添加元素👆 ==================================================//

    /**
     * 获取节点
     *
     * @param node 根节点
     * @param key  键
     * @return 节点
     */
    private Node getNode(Node node, K key) {
        return null;
    }

    /**
     * 判断是否存在元素对象
     *
     * @param key 元素键
     * @return boolean
     */
    public boolean contains(K key) {
        return false;
    }

    /**
     * 通过键获取值
     *
     * @param key 键
     * @return 值
     */
    public V get(K key) {
        return null;
    }

    /**
     * 通过已有key键修改值value
     *
     * @param key   键
     * @param value 值
     */
    public void set(K key, V value) {
    }

    /**
     * （私有）递归获取根节点为node的树的最小元素
     *
     * @param node 根节点（相对）
     * @return 最小元素对象
     */
    private Node minimum(Node node) {
        return null;
    }

    /**
     * 删除元素element
     *
     * @param key 元素对象
     */
    public void remove(K key) {
        remove(this.root, key);
    }

    /**
     * （私有）递归删除元素对象
     *
     * @param node 根节点（相对）
     * @param key  元素键
     * @return 根节点（相对）
     */
    private Node remove(Node node, K key) {
        return null;
    }

}
