package com.kimlngo.leetcode;

public class MaxAverageSlidingWindow {
    public static void main(String[] args) {

        System.out.println(findMaxAverageSlidingWindow(new int[]{1, 12, -5, -6, 50, 3}, 4));
//        System.out.println(findMaxAverageSlidingWindow(new int[]{3, 3, 4, 3, 0}, 3));
    }

    private static double findMaxAverageSlidingWindow(int[] nums, int k) {
        int sum = 0;
        double maxAverage, ave;

        for (int i = 0; i < k; i++)
            sum += nums[i];

        maxAverage = (double) sum / k;

        for (int j = 1; j <= nums.length - k; j++) {
            sum = sum - nums[j - 1] + nums[j + k - 1];
            ave = (double) sum / k;

            if (maxAverage < ave) maxAverage = ave;
        }


        return maxAverage;
    }
}
