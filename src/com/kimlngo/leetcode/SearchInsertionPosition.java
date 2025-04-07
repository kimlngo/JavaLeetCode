package com.kimlngo.leetcode;

public class SearchInsertionPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 1));
        System.out.println(searchInsert(nums, 3));
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 6));
    }

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        //corner case
        if (target > nums[length - 1])
            return length;
        else if (target == nums[length - 1])
            return length - 1;
        else if (target <= nums[0])
            return 0;

        int start = 0, end = length - 1;

        while (start < end - 1) {
            int mid =  (start + end) / 2;

            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(nums[start] > target) return start;
        else return start + 1;
    }
}
