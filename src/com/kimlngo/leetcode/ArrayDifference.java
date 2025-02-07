package com.kimlngo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayDifference {
    public static void main(String[] args) {
        System.out.println(findDifferenceInTwoArray(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
        System.out.println(findDifferenceInTwoArray(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}));
    }

    private static List<List<Integer>> findDifferenceInTwoArray(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = convertArrToSet(nums1);
        Set<Integer> num2Set = convertArrToSet(nums2);

        List<Integer> result1 = num1Set.stream()
                                       .filter(num -> !num2Set.contains(num))
                                       .toList();

        List<Integer> result2 = num2Set.stream()
                                       .filter(num -> !num1Set.contains(num))
                                       .toList();

        return List.of(result1, result2);
    }

    private static Set<Integer> convertArrToSet(int[] nums) {
        return new HashSet<>(Arrays.stream(nums)
                                   .boxed()
                                   .toList());
    }
}
