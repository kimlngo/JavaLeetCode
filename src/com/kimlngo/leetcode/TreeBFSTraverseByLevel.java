package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class TreeBFSTraverseByLevel {
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

        System.out.println(traverseBFS(root));
    }

    private static String traverseBFS(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<String> resultList = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            int qLength = queue.size();

            for(int i = 0; i < qLength; i++) {
                TreeNode node = queue.remove();
                resultList.add(String.valueOf(node.val));
                if(i != qLength - 1) resultList.add(" ");

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            resultList.add("|");
        }

        return resultList.stream().collect(Collectors.joining());
    }
}
