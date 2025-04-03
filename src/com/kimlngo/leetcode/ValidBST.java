package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.kimlngo.leetcode.data.TreeUtil.createTreeNode;

public class ValidBST {

    public static void main(String[] args) {
        var root = createTreeNode(2);
        var one = createTreeNode(1);
        var three = createTreeNode(3);

        root.left = one;
        root.right = three;

        System.out.println(isValidBST(root));

        root = createTreeNode(5);
        var four = createTreeNode(4);
        var six = createTreeNode(6);

        root.left = one;
        root.right = four;
        four.left = three;
        four.right = six;

        System.out.println(isValidBST(root));
    }

    private static boolean isValidBST(TreeNode root) {
        List<Integer> flatten = new ArrayList<>();
        traverseInOrder(root, flatten);

        for (int i = 0; i < flatten.size() - 1; i++) {
            if(flatten.get(i).intValue() >= flatten.get(i + 1).intValue()) return false;
        }
        return true;
    }

    private static void traverseInOrder(TreeNode node, List<Integer> flatten) {
        if(node.left != null) traverseInOrder(node.left, flatten);

        flatten.add(node.val);

        if(node.right != null) traverseInOrder(node.right, flatten);
    }
}
