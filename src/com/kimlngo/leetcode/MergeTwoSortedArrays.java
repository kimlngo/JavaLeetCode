package com.kimlngo.leetcode;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1, 0, nums2, 1);

        System.out.println(Arrays.toString(nums1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        if(m == 0) {
            for(int i = 0; i < n; i++)
                nums1[i] = nums2[i];
            return;
        }

        int insertCount = 0;

        int i = 0, j = 0;

        while (i < m + insertCount && j < n) {
            if (nums1[i] < nums2[j])
                i++;
            else {
                shiftRightArray(nums1, m + insertCount, i);
                nums1[i] = nums2[j];
                insertCount++;
                i++;
                j++;
            }
        }

        if(j < n) {
            //copy remaining nums2 over
            for(int k = j; k < n; k++) {
                nums1[m + insertCount + k - j] = nums2[k];
            }
        }
    }

    private static void shiftRightArray(int[] nums, int m, int stopIdx) {
        for (int i = m - 1; i >= stopIdx; i--) {
            nums[i + 1] = nums[i];
        }
    }
}
