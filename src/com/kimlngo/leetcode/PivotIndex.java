package com.kimlngo.leetcode;

import java.util.Arrays;

public class PivotIndex {
    public static void main(String[] args) {
        System.out.println(findPivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(findPivotIndex(new int[]{1, 2, 3}));
        System.out.println(findPivotIndex(new int[]{2, 1, -1}));
    }

    private static int findPivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum;

        int totalSum = 0;
        for (int n : nums)
            totalSum += n;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0) leftSum += nums[i - 1];
            rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) return i;
        }

        return -1;
    }
}
