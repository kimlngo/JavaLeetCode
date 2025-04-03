package com.kimlngo.leetcode.data;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class TreeUtil {

    public static void traverseAndPrintBFS(TreeNode root) {
        if (root == null) System.out.println("Null root");

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<TreeNode> list = new ArrayList<>();

        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.remove();
            list.add(cur);

            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }

        System.out.println(list.stream()
                               .map(node -> String.valueOf(node.val))
                               .collect(Collectors.joining(" -> ")));
    }

    public static TreeNode createTreeNode(int val) {
        return new TreeNode(val);
    }
}
