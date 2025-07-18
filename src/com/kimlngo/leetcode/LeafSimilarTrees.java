package com.kimlngo.leetcode;


import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.kimlngo.leetcode.Util.constructTree;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        List<Integer> tree1 = Arrays.asList(3, 5, 1, 6, 2, 9, 8, null, null, 7);
        TreeNode root1 = constructTree(tree1);

        List<Integer> tree2 = Arrays.asList(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8);
        TreeNode root2 = constructTree(tree2);

        System.out.println("Are leaf similar? - " + isTreeSimilar(root1, root2));

    }

    private static boolean isTreeSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> leaf1 = extractLeafNodes(root1);
        List<TreeNode> leaf2 = extractLeafNodes(root2);

        if (leaf1.size() != leaf2.size()) return false;

        for (int i = 0; i < leaf1.size(); i++) {
            TreeNode n1 = leaf1.get(i);
            TreeNode n2 = leaf2.get(i);
            if (n1.val != n2.val) return false;
        }

        return true;
    }

    private static List<TreeNode> extractLeafNodes(TreeNode root) {
        List<TreeNode> leaf = new ArrayList<>();
        extract(root, leaf);

        return leaf;
    }

    private static void extract(TreeNode node, List<TreeNode> result) {
        if (node == null) return;

        if (node.left == null && node.right == null) result.add(node);
        extract(node.left, result);
        extract(node.right, result);
    }
}
