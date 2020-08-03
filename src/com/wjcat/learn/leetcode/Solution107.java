package com.wjcat.learn.leetcode;

import java.util.*;

/**
 * @Description 107、给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by yupeijiang on 2019/8/14.
 */
public class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            List<TreeNode> treeNodeList = new ArrayList<>();
            List<Integer> levelResult = new ArrayList<>();
            while (!treeNodeQueue.isEmpty()) {
                TreeNode node = treeNodeQueue.remove();
                if (node.left != null) treeNodeList.add(node.left);
                if (node.right != null) treeNodeList.add(node.right);
                levelResult.add(node.val);
            }
            treeNodeQueue.addAll(treeNodeList);
            result.add(levelResult);
        }
        Collections.reverse(result);
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
