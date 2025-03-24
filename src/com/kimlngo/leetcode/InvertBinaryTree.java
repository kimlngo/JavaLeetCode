package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;
import com.kimlngo.leetcode.data.TreeUtil;

public class InvertBinaryTree {
    public static void main(String[] args) {
        var root = new TreeNode(4);
        var two = new TreeNode(2);
        var seven = new TreeNode(7);
        var one = new TreeNode(1);
        var three = new TreeNode(3);
        var six = new TreeNode(6);
        var nine = new TreeNode(9);

        root.left = two;
        root.right = seven;
        two.left = one;
        two.right = three;
        seven.left = six;
        seven.right = nine;

        TreeUtil.traverseAndPrintBFS(root);
        invertBinaryTree(root);
        TreeUtil.traverseAndPrintBFS(root);
    }

    private static TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) return root;

        invert(root);
        return root;
    }

    private static void invert(TreeNode node) {
        if (node.left == null && node.right == null) {
            //leaf node, do nothing
            return;
        }

        if (node.left != null) invert(node.left);
        if (node.right != null) invert(node.right);

        //invert
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
