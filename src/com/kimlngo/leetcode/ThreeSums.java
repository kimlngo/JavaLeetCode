package com.kimlngo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSums {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0,0,0}));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<Integer> sorted = Arrays.stream(nums)
                                     .sorted()
                                     .boxed()
                                     .collect(Collectors.toList());

        Set<List<Integer>> result = new HashSet<>();
        int i = 0, j, k, sum;

        while (i < sorted.size() - 1 && sorted.get(i) < 1) {
            j = i + 1;
            k = sorted.size() - 1;

            while (j < k) {
                sum = sorted.get(i) + sorted.get(j) + sorted.get(k);
                
                if (sum == 0) {
                    result.add(Arrays.asList(sorted.get(i), sorted.get(j), sorted.get(k)));
                    while (j < sorted.size() - 2 && sorted.get(j) == sorted.get(j + 1)) j++;
                    j++;
                    while (k >= 1 && sorted.get(k) == sorted.get(k - 1)) k--;
                    k--;
                } else if (sum > 0) {
                    while (k >= 0 && sorted.get(k) == sorted.get(k - 1)) k--;
                    k--;
                } else {
                    while (j < sorted.size() - 2 && sorted.get(j) == sorted.get(j + 1)) j++;
                    j++;
                }
            }
            while (i < sorted.size() - 2 && sorted.get(i) == sorted.get(i + 1)) i++;
            i++;
        }

        return result.stream().toList();
    }
}
