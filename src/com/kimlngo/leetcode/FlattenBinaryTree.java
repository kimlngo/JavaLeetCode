package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree {
    public static void main(String[] args) {
        var root = new TreeNode(1);
        var two = new TreeNode(2);
        var three = new TreeNode(3);
        var four = new TreeNode(4);
        var five = new TreeNode(5);
        var six = new TreeNode(6);

        root.left = two;
        root.right = five;
        two.left = three;
        two.right = four;
        five.right = six;

        flatten(root);
    }

    private static void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;

        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);

        TreeNode cur, next = null;
        for (int i = 0; i < list.size() - 1; i++) {
            cur = list.get(i);
            next = list.get(i + 1);

            cur.left = null;
            cur.right = next;
        }
        if (next != null)
            next.right = null;
    }

    private static void traverse(TreeNode node, List<TreeNode> list) {
        list.add(node);
        if (node.left != null) traverse(node.left, list);
        if (node.right != null) traverse(node.right, list);
    }
}
