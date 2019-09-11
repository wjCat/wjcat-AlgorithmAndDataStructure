package com.wjcat.learn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 103、给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by yupeijiang on 2019/8/13.
 */
public class OneHundredThreeSolution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        int depth = 0;
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            List<TreeNode> treeNodeList = new ArrayList<>();
            List<Integer> levelResult = new ArrayList<>();
            while (!treeNodeQueue.isEmpty()) {
                TreeNode node = treeNodeQueue.remove();
                if (node.left != null) treeNodeList.add(node.left);
                if (node.right != null) treeNodeList.add(node.right);
                if (depth % 2 == 0) levelResult.add(0, node.val);
                else levelResult.add(node.val);
            }
            treeNodeQueue.addAll(treeNodeList);
            result.add(levelResult);
            depth++;
        }
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
