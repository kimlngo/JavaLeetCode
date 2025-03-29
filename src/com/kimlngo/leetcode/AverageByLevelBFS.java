package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageByLevelBFS {
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

        System.out.println(averageOfLevels(root));
    }

    private static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Double> result = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            double sum = 0;

            for (int i = 0; i < length; i++) {
                var node = queue.remove();
                sum += node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(sum / length);
        }
        return result;
    }
}
