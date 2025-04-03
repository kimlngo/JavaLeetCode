package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceBST {
    public static void main(String[] args) {
        var root = new TreeNode(4);
        var two = new TreeNode(2);
        var six = new TreeNode(6);
        var one = new TreeNode(1);
        var three = new TreeNode(3);

        root.left = two;
        root.right = six;

        two.left = one;
        two.right = three;

        System.out.println(getMinimumDifference(root));

        root = new TreeNode(1);
        var zero = new TreeNode(0);
        var fourEight = new TreeNode(48);
        var twelve = new TreeNode(12);
        var fourNine = new TreeNode(49);

        root.left = zero;
        root.right = fourEight;
        fourEight.left = twelve;
        fourEight.right = fourNine;

        System.out.println(getMinimumDifference(root));
    }

    private static int getMinimumDifference(TreeNode root) {
        List<Integer> flattenList = new ArrayList<>();
        traverseInOrder(root, flattenList);

        System.out.println(flattenList);

        int min = Integer.MAX_VALUE, dist;
        for(int i = 0; i < flattenList.size() - 1; i++) {
            dist = Math.abs(flattenList.get(i).intValue() - flattenList.get(i + 1).intValue());
            if(dist < min) min = dist;
        }

        return min;
    }

    private static void traverseInOrder(TreeNode node, List<Integer> flattenList) {
        if(node.left != null) traverseInOrder(node.left, flattenList);

        flattenList.add(node.val);

        if(node.right!= null) traverseInOrder(node.right, flattenList);

    }
}
