package com.kimlngo.leetcode.algomap;

import java.util.Arrays;

public class FindClosestNumToZero {
    public static void main(String[] args) {
        System.out.println(findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
        System.out.println(findClosestNumber(new int[]{2, -1, 1}));
        System.out.println(findClosestNumber(new int[]{-5}));
    }

    private static int findClosestNumber(int[] nums) {
        int absMin = Arrays.stream(nums)
                .map(Math::abs)
                .min()
                .getAsInt();

        int[] possibleValues = Arrays.stream(nums)
                .filter(n -> Math.abs(n) == absMin)
                .toArray();

        if (possibleValues.length == 1) return possibleValues[0];
        else {
            return Arrays.stream(possibleValues)
                    .max()
                    .getAsInt();
        }
    }
}
