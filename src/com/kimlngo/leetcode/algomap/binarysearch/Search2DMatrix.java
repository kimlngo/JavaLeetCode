package com.kimlngo.leetcode.algomap.binarysearch;

public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        System.out.println("search for 3: " + searchMatrix(arr, 3));
        System.out.println("search for 13: " + searchMatrix(arr, 13));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            if (arr[0] <= target && target <= arr[arr.length - 1])
                return binarySearch(arr, target);
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int target) {
        if (target < arr[0] || target > arr[arr.length - 1]) return false;

        int left = 0, right = arr.length - 1;
        int mid, midVal;

        while (left <= right) {
            mid = (left + right) / 2;
            midVal = arr[mid];

            if (midVal == target)
                return true;
            else if (midVal < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
