package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLeftRightSideView {
    public static void main(String[] args) {
        var root = new TreeNode(1);
        var two = new TreeNode(2);
        var three = new TreeNode(3);
        var four = new TreeNode(4);
        var five = new TreeNode(5);

        root.left = two;
        root.right = three;
        two.right = five;
        three.right = four;

        System.out.println("right side view: " + rightSideView(root)); //[1, 3, 4]
        System.out.println("left side view: " + leftSideView(root)); //[1, 2, 5]

        root.left = two;
        root.right = three;
        two.left = four;
        four.left = five;

        System.out.println("right side view: " + rightSideView(root)); //[1, 3, 4, 5]
        System.out.println("left side view: " + leftSideView(root)); //[1, 2, 4, 5]

        root.right = three;
        root.left = null;
        three.left = null;
        three.right = null;
        System.out.println("right side view: " + rightSideView(root)); //[1, 3]
        System.out.println("left side view: " + leftSideView(root)); //[1, 3]
    }

    private static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        int length;

        while (!queue.isEmpty()) {
            length = queue.size();

            for (int i = 0; i < length; i++) {
                TreeNode tmp = queue.remove();

                if (i == length - 1) result.add(tmp.val);

                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
        }

        return result;
    }

    private static List<Integer> leftSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        int length;

        while (!queue.isEmpty()) {
            length = queue.size();

            for (int i = 0; i < length; i++) {
                TreeNode tmp = queue.remove();

                if (i == 0) result.add(tmp.val);

                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
        }

        return result;
    }
}
