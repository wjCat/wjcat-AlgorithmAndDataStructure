package com.wjcat.learn.datastructure.tree.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 二分搜索树
 * Created by 厕所里拉屎的猫 on 2019/5/20.
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        E element;
        Node left, right;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 获取元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 判断是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 添加元素
     *
     * @param element 元素对象
     */
    public void add(E element) {
//        if (this.root == null)
//            this.root = new Node(element);
//        else
//            this.add(this.root, element);
//        size++;
        root = add(root, element);

    }

    /**
     * （私有）递归添加元素
     *
     * @param node    根节点（相对）
     * @param element 元素对象
     * @return 树（子树）
     */
    private Node add(Node node, E element) {
//        if (node.element.compareTo(element) == 0)
//            return;
//        else if (node.element.compareTo(element) > 0)
//            if (node.right == null)
//                node.right = new Node(element);
//            else
//                add(node.right, element);
//        else    // if (node.element.compareTo(element) < 0)
//            if (node.left == null)
//                node.left = new Node(element);
//            else
//                add(node.left, element);
        if (node == null) {
            this.size++;
            return new Node(element);
        }

        if (node.element.compareTo(element) > 0)
            node.left = add(node.left, element);
        else if (node.element.compareTo(element) < 0)
            node.right = add(node.right, element);

        return node;

    }

    /**
     * 判断是否存在元素对象
     *
     * @param element 元素对象
     * @return boolean
     */
    public boolean contains(E element) {
        return contains(root, element);
    }

    /**
     * （私有）递归判断是否存在元素对象
     *
     * @param node    根节点（相对）
     * @param element 元素对象
     * @return boolean
     */
    private boolean contains(Node node, E element) {
        if (node == null)
            return false;
        if (node.element.compareTo(element) == 0)
            return true;
        else if (node.element.compareTo(element) > 0)
            return contains(node.left, element);
        else
            return contains(node.right, element);
    }

    /**
     * 前序遍历（练习）
     */
    public void preOrder() {
        this.preOrder(this.root);
    }

    /**
     * （私有）递归前序遍历（练习）
     *
     * @param node 根节点（相对）
     */
    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print("【" + node.element + "】");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历（练习）
     */
    public void inOrder() {
        this.inOrder(this.root);
    }

    /**
     * （私有）递归中序遍历（练习）
     *
     * @param node 根节点（相对）
     */
    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print("【" + node.element + "】");
        inOrder(node.right);
    }

    /**
     * 后序遍历（练习）
     */
    public void postOrder() {
        this.postOrder(this.root);
    }

    /**
     * （私有）递归后序遍历（练习）
     *
     * @param node 根节点（相对）
     */
    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print("【" + node.element + "】");
    }

    /**
     * 层序遍历（练习）
     */
    public void levelOrder() {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print("【" + node.element + "】");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    /**
     * 查找最小元素
     *
     * @return 最小元素对象
     */
    public E minimum() {
        if (this.size == 0)
            throw new IllegalArgumentException("BST is empty");

        return this.minimum(this.root).element;
    }

    /**
     * （私有）递归获取根节点为node的树的最小元素
     *
     * @param node 根节点（相对）
     * @return 最小元素对象
     */
    private Node minimum(Node node) {

        if (node.left == null)
            return node;

        return minimum(node.left);
    }

    /**
     * 查找最大元素
     *
     * @return 最大元素对象
     */
    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).element;
    }

    /**
     * （私有）递归获取根节点为node的树的最大元素
     *
     * @param node 根节点（相对）
     * @return 最大元素对象
     */
    private Node maximum(Node node) {

        if (node.right == null)
            return node;

        return maximum(node.right);
    }

    /**
     * 删除最小元素
     *
     * @return 元素对象
     */
    public E removeMin() {
        E element = this.minimum();
        root = this.removeMin(root);
        return element;
    }

    /**
     * （私有）递归删除最小元素
     *
     * @param node 根节点（相对）
     * @return 元素对象
     */
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除最大元素
     *
     * @return 元素对象
     */
    public E removeMax() {
        E element = this.maximum();
        root = this.removeMax(root);
        return element;
    }

    /**
     * （私有）递归删除最大元素
     *
     * @param node 根节点（相对）
     * @return 元素对象
     */
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除元素element
     * @param element 元素对象
     */
    public void remove(E element) {
        remove(this.root, element);
    }

    /**
     * （私有）递归删除元素对象
     * @param node 根节点（相对）
     * @param element 元素对象
     * @return 根节点（相对）
     */
    private Node remove(Node node, E element) {
        if (node == null)
            return null;
        if (node.element.compareTo(element) > 0) {
            node.left = this.remove(node.left, element);
            return node;
        } else if (node.element.compareTo(element) < 0) {
            node.right = this.remove(node.right, element);
            return node;
        } else {
            if (node.left == null) {
                Node resultNode = node.right;
                node.right = null;
                this.size--;
                return resultNode;
            } else if (node.right == null) {
                Node resultNode = node.left;
                node.left = null;
                this.size--;
                return resultNode;
            } else {
                Node resultNode = this.minimum(node.right);
                resultNode.right = this.removeMin(node.right);
                resultNode.left = node.left;
                node.left = node.right = null;
                return resultNode;
            }
        }
    }

}
