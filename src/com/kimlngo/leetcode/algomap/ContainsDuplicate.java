package com.kimlngo.leetcode.algomap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate_solution2(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate_solution2(new int[]{1, 2, 3, 4}));
    }

    private static boolean containsDuplicate_solution1(int[] nums) {
        Map<Integer, Long> freqCounter = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return freqCounter.values()
                .stream()
                .anyMatch(v -> v >= 2);
    }

    private static boolean containsDuplicate_solution2(int[] nums) {
        Map<Integer, Integer> mapCount = new HashMap<>();

        for (int i : nums) {
            mapCount.putIfAbsent(i, 0);
            mapCount.put(i, mapCount.get(i) + 1);

            if (mapCount.get(i) >= 2)
                return true;
        }

        return false;
    }


}
