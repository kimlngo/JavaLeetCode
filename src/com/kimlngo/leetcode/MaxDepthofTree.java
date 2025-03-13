package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.*;

public class MaxDepthofTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode nine = new TreeNode(9);

        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        root.left = nine;
        root.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;

        System.out.println("Max Depth by DFS = " + maxDepthByDFS(root));
        System.out.println("Max Depth by BFS = " + maxDepthByBFS(root));
    }

    private static int maxDepthByDFS(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(maxDepthByDFS(root.left), maxDepthByDFS(root.right));
    }

    private static int maxDepthByBFS(TreeNode root) {
        if(root == null) return 0;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while(!queue.isEmpty()) {
            depth++;
            int qLength = queue.size();

            for (int i = 0; i < qLength; i++) {
                TreeNode node = queue.removeFirst();

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }

        return depth;
    }
}
