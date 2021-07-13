package com.wjcat.learn.datastructure.tree.AVLTree;

/**
 * 平衡二叉树AVL
 * Created by 厕所里拉屎的猫 on 2019/5/22.
 * review in 2021/07/13
 */
public class AVLTree<K extends Comparable<K>, V> {

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

    public AVLTree() {
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

    // ================================================== 👇平衡二叉树保持平衡的辅助函数👇 ==================================================//

    /**
     * 获得节点node的高度
     *
     * @param node 节点
     * @return 高度
     */
    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    /**
     * 获取节点node的平衡因子
     *
     * @param node 节点
     * @return 平衡因子
     */
    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return this.getHeight(node.left) - this.getHeight(node.right);
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
        Node root = node.left;
        node.left = root.right;
        root.right = node;

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        return root;
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
        Node root = node.right;
        node.right = root.left;
        root.left = node;

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        return root;
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
        root = add(root, key, value);
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
        if (node == null) {
            this.size++;
            return new Node(key, value);
        }

        if (node.key.compareTo(key) > 0)
            node.left = add(node.left, key, value);
        else if (node.key.compareTo(key) < 0)
            node.right = add(node.right, key, value);
        else
            node.value = value;

        // ==================== 👇回溯中进行平衡调整👇 ====================//
        // 更新height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        if (this.getBalanceFactor(node) > 1)
            if (this.getBalanceFactor(node.left) >= 0) // LL
                node = this.rightRotate(node);
            else {// LR
                node.left = this.leftRotate(node.left);
                node = this.rightRotate(node);
            }
        else if (this.getBalanceFactor(node) < -1)
            if (this.getBalanceFactor(node.right) <= 0) // RR
                node = this.leftRotate(node);
            else { // RL
                node.right = this.rightRotate(node.right);
                node = this.leftRotate(node);
            }
        // ==================== 👆回溯中进行平衡调整👆 ====================//

        return node;
    }

    // ================================================== 👆添加元素👆 ==================================================//

    /**
     * 获取节点
     * @param node 根节点
     * @param key 键
     * @return 节点
     */
    private Node getNode(Node node, K key){
        if (node == null)
            return null;
        if (node.key.compareTo(key) == 0)
            return node;
        else if (node.key.compareTo(key) > 0)
            return this.getNode(node.left, key);
        else
            return this.getNode(node.right, key);
    }

    /**
     * 判断是否存在元素对象
     *
     * @param key 元素键
     * @return boolean
     */
    public boolean contains(K key) {
        return this.getNode(this.root, key) != null;
    }

    /**
     * 通过键获取值
     * @param key 键
     * @return 值
     */
    public V get(K key){
        Node node = this.getNode(this.root, key);
        return node == null ? null : node.value;
    }

    /**
     * 通过已有key键修改值value
     * @param key 键
     * @param value 值
     */
    public void set(K key, V value) {
        Node node = this.getNode(this.root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        node.value = value;
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
        if (node == null)
            return null;
        Node returnNode;
        if (node.key.compareTo(key) > 0) {
            node.left = this.remove(node.left, key);
            returnNode =  node;
        } else if (node.key.compareTo(key) < 0) {
            node.right = this.remove(node.right, key);
            returnNode =  node;
        } else {
            if (node.left == null) {
                Node resultNode = node.right;
                node.right = null;
                this.size--;
                returnNode =  resultNode;
            } else if (node.right == null) {
                Node resultNode = node.left;
                node.left = null;
                this.size--;
                returnNode = resultNode;
            } else {
                Node resultNode = this.minimum(node.right);
//                resultNode.right = this.removeMin(node.right);
                resultNode.left = node.left;
                node.left = node.right = null;
                returnNode =  resultNode;
            }
        }

        if (returnNode == null)
            return null;

        // ==================== 👇回溯中进行平衡调整👇 ====================//
        // 更新height
        returnNode.height = 1 + Math.max(getHeight(returnNode.left), getHeight(returnNode.right));

        // 计算平衡因子
        int balanceFactor = this.getBalanceFactor(returnNode);

        if (balanceFactor > 1 && getBalanceFactor(returnNode.left) >= 0) // LL
            return rightRotate(returnNode);
        if (balanceFactor < -1 && getBalanceFactor(returnNode.right) <= 0) // RR
            return leftRotate(returnNode);
        if (balanceFactor > 1 && getBalanceFactor(returnNode.left) < 0) { // LR
            returnNode.left = leftRotate(returnNode.left);
            return rightRotate(returnNode);
        }
        if (balanceFactor < -1 && getBalanceFactor(returnNode.right) > 0) { // RL
            returnNode.right = rightRotate(returnNode.right);
            return leftRotate(returnNode);
        }

        // ==================== 👆回溯中进行平衡调整👆 ====================//

        return returnNode;

    }

}
