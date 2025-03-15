package com.kimlngo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSums {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();
        int i = 0, j, k, sum, length = nums.length;

        while (i < length - 1 && nums[i] < 1) {
            j = i + 1;
            k = length - 1;

            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < length - 2 && nums[j] == nums[j + 1]) j++;
                    j++;
                    while (k >= 1 && nums[k] == nums[k - 1]) k--;
                    k--;
                } else if (sum > 0) {
                    while (k >= 1 && nums[k] == nums[k - 1]) k--;
                    k--;
                } else {
                    while (j < length - 2 && nums[j] == nums[j + 1]) j++;
                    j++;
                }
            }
            while (i < length - 2 && nums[i] == nums[i + 1]) i++;
            i++;
        }

        return result.stream().toList();
    }
}
