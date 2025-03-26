package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        TreeNode l3 = new TreeNode(4);

        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);

        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = l3;

        r1.left = r3;
        r1.right = r2;

        System.out.println(isSymmetricTree(root));

        l1.left = null;
        l1.right = new TreeNode(3);

        r1.left = null;
        r1.right = new TreeNode(3);

        System.out.println(isSymmetricTree(root));
    }

    private static boolean isSymmetricTree(TreeNode root) {
        return checkSymmetry(root.left, root.right);
    }

    private static boolean checkSymmetry(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) return true;

        if(n1 == null || n2 == null) return false;

        return n1.val == n2.val && checkSymmetry(n1.left, n2.right) && checkSymmetry(n1.right, n2.left);
    }
}
