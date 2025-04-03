package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {

    public static void main(String[] args) {
        var root = new TreeNode(3);
        var one = new TreeNode(1);
        var two = new TreeNode(2);
        var four = new TreeNode(4);

        root.left = one;
        root.right = four;
        one.right = two;

        System.out.println(kthSmallestElement(root, 1));
    }

    private static int kthSmallestElement(TreeNode root, int k) {
        List<Integer> flatten = new ArrayList<>();
        traverseInOrder(root, flatten);

        return flatten.get(k - 1).intValue();

    }

    private static void traverseInOrder(TreeNode node, List<Integer> flatten) {
        if(node.left != null) traverseInOrder(node.left, flatten);

        flatten.add(node.val);

        if(node.right != null) traverseInOrder(node.right, flatten);
    }
}
