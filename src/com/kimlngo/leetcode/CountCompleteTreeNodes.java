package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        var root = new TreeNode(1);
        var two = new TreeNode(2);
        var three = new TreeNode(3);

        var four = new TreeNode(4);
        var five = new TreeNode(5);
        var six = new TreeNode(6);

        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = six;

        System.out.println(countTreeNodes(root));
        System.out.println(nodeCountByDFS(root));

        root = new TreeNode(8);
        System.out.println(countTreeNodes(root));
        System.out.println(nodeCountByDFS(root));
    }

    private static int countTreeNodes(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> nodeList = new ArrayList<>();

        traverseBFS(root, nodeList);

        return nodeList.size();
    }

    private static void traverseBFS(TreeNode node, List<TreeNode> nodeList) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);

        int queueSize;

        while(!queue.isEmpty()) {
            queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                TreeNode tmp = queue.remove();
                nodeList.add(tmp);

                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
            }
        }
    }

    private static int nodeCountByDFS(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> list = new ArrayList<>();
        traverseDFS(root, list);
        return list.size();
    }

    private static void traverseDFS(TreeNode node, List<TreeNode> list) {
        list.add(node);
        if(node.left != null) traverseDFS(node.left, list);
        if(node.right != null) traverseDFS(node.right, list);
    }
}
