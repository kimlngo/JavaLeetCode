package com.kimlngo.leetcode.algomap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutiveSequence(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutiveSequence(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutiveSequence(new int[]{1, 0, 1, 2}));
    }

    private static int longestConsecutiveSequence(int[] nums) {
        if(nums.length == 0) return 0;
        //1) sorted the array
        List<Integer> sortedArray = Arrays.stream(nums)
                                          .distinct()
                                          .sorted()
                                          .boxed()
                                          .toList();
        System.out.println(sortedArray);

        //2) cut the array into chunk of consecutive sub-array
        List<List<Integer>> subArrays = new ArrayList<>();

        List<Integer> inner = new ArrayList<>();
        for (int i = 0; i < sortedArray.size() - 1; i++) {
            inner.add(sortedArray.get(i));

            if (sortedArray.get(i + 1) - sortedArray.get(i) != 1) {
                subArrays.add(inner);
                inner = new ArrayList<>();
            }
        }

        inner.add(sortedArray.getLast());
        subArrays.add(inner);

        System.out.println(subArrays);

        //3) get the max longest consecutive sub-array length
        return subArrays.stream()
                        .mapToInt(List::size)
                        .max()
                        .orElse(-1);
    }
}
