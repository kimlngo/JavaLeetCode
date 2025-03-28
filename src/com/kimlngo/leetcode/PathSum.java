package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        var negTwo = new TreeNode(-2);
        var one = new TreeNode(1);
        var three = new TreeNode(3);
        var negOne = new TreeNode(-1);

        var negThree = new TreeNode(-3);
        var negTwoTwo = new TreeNode(-2);

        root.left = negTwo;
        root.right = negThree;

        negTwo.left = one;
        negTwo.right = three;
        one.left = negOne;
        negThree.left = negTwoTwo;

        System.out.println(pathSum(root, 3));

    }

    private static boolean pathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Holder holder = new Holder();
        traverse(root, holder, targetSum);
        return holder.getRouteFound();
    }

    private static void traverse(TreeNode node, Holder holder, int targetSum) {
        if (node.left == null && node.right == null) {
            if (holder.getVal() + node.val == targetSum) {
                holder.foundRoot();
            }

            return;
        }
        holder.setVal(holder.getVal() + node.val);
        if (node.left != null) traverse(node.left, holder, targetSum);
        if (node.right != null) traverse(node.right, holder, targetSum);
        holder.setVal(holder.getVal() - node.val);
    }
}

class Holder {
    private int sum;
    private boolean routeFound;

    public Holder() {
        this.sum = 0;
        this.routeFound = false;
    }

    public void setVal(int val) {
        this.sum = val;
    }

    public int getVal() {
        return this.sum;
    }

    public void foundRoot() {
        this.routeFound = true;
    }

    public boolean getRouteFound() {
        return this.routeFound;
    }
}