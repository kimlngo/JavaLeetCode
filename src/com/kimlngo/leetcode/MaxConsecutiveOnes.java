package com.kimlngo.leetcode;

import java.io.IOException;
import java.util.Arrays;

public class MaxConsecutiveOnes {

    public static void main(String[] args) throws IOException {
//        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
//        System.out.println(longestOnes(nums, 3));
//
//        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
//        System.out.println(longestOnes(nums1, 2));
//
//        int[] nums2 = {0,0,0,1};
//        System.out.println(longestOnes(nums2, 4));

        int[] nums3 = Util.readBinaryArray();
        long start = System.currentTimeMillis();
        int result = longestOnes(nums3, 5760);
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("duration = " + (end - start));

    }

    public static int longestOnes(int[] nums, int k) {
        int maxFlipCount = countZeros(nums);

        if (maxFlipCount <= k) return nums.length;

        int minFlipCount = maxFlipCount;
        for (int window = nums.length - 1; window > 0; window--) {

            int count = 0;
            //initial count
            for (int i = 0; i < window; i++) {
                if (nums[i] == 0) count++;
            }

            for (int i = 1; i <= nums.length - window; i++) {
                if (nums[i - 1] == 0) count--;
                if (nums[i + window - 1] == 0) count++;

                if (count < minFlipCount) minFlipCount = count;
            }


            if (minFlipCount == k) return window;
        }
        return 0;
    }

    private static int countZeros(int[] nums) {
        return (int) Arrays.stream(nums)
                           .filter(n -> n == 0)
                           .count();
    }
}
