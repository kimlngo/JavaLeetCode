package com.kimlngo.leetcode.algomap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum_Improve(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum_Improve(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum_Improve(new int[]{3, 3}, 6)));

    }

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }

        return new int[]{-1, -1};
    }

    private static int[] twoSum_Improve(int[] nums, int target) {
        Set<Integer> numSet = new HashSet<>();
        for(int n : nums) {
            numSet.add(n);
        }

        int complement = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];

            if(numSet.contains(complement)) {
                for(int j = 0; j < nums.length; j++) {
                    if(nums[j] == complement && i != j)
                        return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
