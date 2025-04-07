package com.kimlngo.leetcode;

public class SearchInsertionPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 4));
    }

    public static int searchInsert(int[] nums, int target) {
        //corner case
        if (target > nums[nums.length - 1])
            return nums.length;
        else if (target == nums[nums.length - 1])
            return nums.length - 1;
        else if (target <= nums[0])
            return 0;

        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = end - start / 2;

            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(nums[start] > target) return start;
        else return start + 1;
    }
}
