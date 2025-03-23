package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SameTree {
    public static void main(String[] args) {
        TreeNode p1, p2;
//        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
//        TreeNode p2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
//        System.out.println(isSameTree(p1, p2));

        p1 = new TreeNode(1, new TreeNode(2), null);
        p2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(isSameTree(p1, p2));

//        p1 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
//        p2 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
//        System.out.println(isSameTree(p1, p2));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        return traverseBFS(p).equals(traverseBFS(q));
    }

    private static String traverseBFS(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        TreeNode tmp;

        while (!queue.isEmpty()) {
            tmp = queue.removeFirst();
            if(tmp == null) sb.append("null|");
            else {
                sb.append(tmp.val + "|");
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
        }

        String string = sb.substring(0, sb.length() - 1)
                          .toString();
        System.out.println(string);
        return string;
    }

}
