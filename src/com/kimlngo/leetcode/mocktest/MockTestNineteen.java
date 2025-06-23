package com.kimlngo.leetcode.mocktest;

import com.kimlngo.leetcode.Util;
import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.kimlngo.leetcode.Util.constructTree;

public class MockTestNineteen {
    private static final int[] INVERTED_DIGIT = new int[]{1, 0};

    public static void main(String[] args) {
        MockTestNineteen sol = new MockTestNineteen();

        Util.print2DArray(sol.flipAndInvertImage(Util.readInput2DArray("[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]")));

        List<Integer> tree1 = Arrays.asList(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4);
        TreeNode root1 = constructTree(tree1);

        List<Integer> tree2 = Arrays.asList(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8);
        TreeNode root2 = constructTree(tree2);

        System.out.println("Are leaf similar? - " + sol.leafSimilar(root1, root2));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //1) extract all the leaf nodes of two trees
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();

        extractAllLeafNodes(root1, leaf1);
        extractAllLeafNodes(root2, leaf2);

        //2) compare and return if two lists are the same
        return isTwoListSame(leaf1, leaf2);
    }

    private boolean isTwoListSame(List<Integer> l1, List<Integer> l2) {
        if (l1.size() != l2.size()) return false;

        int size = l1.size();
        for (int i = 0; i < size; i++) {
            if (!l1.get(i)
                   .equals(l2.get(i)))
                return false;
        }
        return true;
    }

    private void extractAllLeafNodes(TreeNode node, List<Integer> leaves) {
        if (node.left == null && node.right == null) {
            //found a leaf node, add to the leaves
            leaves.add(node.val);
            return;
        }

        if (node.left != null) extractAllLeafNodes(node.left, leaves);
        if (node.right != null) extractAllLeafNodes(node.right, leaves);
    }

    private int[][] flipAndInvertImage(int[][] image) {
        flipArr(image);
        invertArr(image);

        return image;
    }

    private void flipArr(int[][] input) {
        for (int[] arr : input) {
            reverseArr(arr);
        }
    }

    private void invertArr(int[][] input) {
        int n = input.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                input[row][col] = INVERTED_DIGIT[input[row][col]];
            }
        }
    }

    private void reverseArr(int[] input) {
        if (input.length == 1) return;

        int left = 0, right = input.length - 1, tmp;

        while (left < right) {
            tmp = input[left];
            input[left] = input[right];
            input[right] = tmp;

            left++;
            right--;
        }
    }
}
