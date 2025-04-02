package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        var root = new TreeNode(3);
        var nine = new TreeNode(9);
        var twenty = new TreeNode(20);
        var fifteen = new TreeNode(15);
        var seven = new TreeNode(7);

        root.left = nine;
        root.right = twenty;

        twenty.left = fifteen;
        twenty.right = seven;

        System.out.println(levelOrder(root));
        System.out.println(levelOrder(new TreeNode(1)));
        System.out.println(levelOrder(null));
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int length;

        while (!queue.isEmpty()) {
            length = queue.size();

            List<Integer> levels = new ArrayList<>();
            for(int i = 0; i < length; i++) {
                TreeNode tmp = queue.remove();
                levels.add(tmp.val);

                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
            }

            result.add(levels);
        }

        return result;
    }
}
