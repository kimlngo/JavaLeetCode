package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

public class ConvertedSortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {1, 3};

        var root = constructBST(nums);
        System.out.println(root);
    }

    public static TreeNode constructBST(int[] nums) {
        int length = nums.length;

        if (length == 0) return null;
        else if (length == 1) return new TreeNode(nums[0]);

        TreeNode root;

        if (length == 2) {
            root = new TreeNode(nums[1]);
            root.left = new TreeNode(nums[0]);
        } else if (length == 3) {
            root = new TreeNode(nums[1]);
            root.left = new TreeNode(nums[0]);
            root.right = new TreeNode(nums[2]);
        } else {
            int mid = length / 2;
            root = new TreeNode(nums[mid]);
            root.left = constructBST(copyArray(nums, 0, mid));
            root.right = constructBST(copyArray(nums, mid + 1, length));
        }

        return root;
    }

    //startIdx inclusive, endIdx not inclusive
    private static int[] copyArray(int[] input, int startIdx, int endIdx) {
        int[] result = new int[endIdx - startIdx];

        for (int i = 0; i < endIdx - startIdx; i++)
            result[i] = input[startIdx + i];

        return result;
    }
}
