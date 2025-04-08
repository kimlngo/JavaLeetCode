package com.kimlngo.leetcode.mocktest;

import java.util.Arrays;

public class MockTestTwo {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(-120));

        System.out.println(reverse(-2147483648));
        System.out.println("Question 2");
        System.out.println(arrayPartitionMaxSum(new int[]{1, 4, 3, 2}));
        System.out.println(arrayPartitionMaxSum(new int[]{6, 2, 6, 5, 1, 2}));
    }

    public static int reverse(int x) {
        int result = 0;
        int tmp = x;

        while (tmp != 0) {
            result = result * 10 + tmp % 10;
            tmp /= 10;
        }

        if ((x >= 0 && result >= 0) || (x <= 0 && result <= 0)) return result;
        else return 0;
    }

    private static int arrayPartitionMaxSum(int[] nums) {
        int[] sortedArr = Arrays.stream(nums)
                                .sorted()
                                .toArray();
        int maxSum = 0;
        for (int i = 0; i < sortedArr.length - 1; i += 2) {
            maxSum += Math.min(sortedArr[i], sortedArr[i + 1]);
        }
        return maxSum;
    }
}
