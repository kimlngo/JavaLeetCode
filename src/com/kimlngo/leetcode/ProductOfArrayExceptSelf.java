package com.kimlngo.leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int[nums.length];

        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) prefix[i] = 1;
            else {
                product *= nums[i - 1];
                prefix[i] = product;
            }
        }

        product = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i == nums.length - 1) suffix[i] = 1;
            else {
                product *= nums[i + 1];
                suffix[i] = product;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}
