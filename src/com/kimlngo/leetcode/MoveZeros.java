package com.kimlngo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeros {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeros(new int[]{0, 1, 0, 3, 12})));
        System.out.println(Arrays.toString(moveZeros(new int[]{0, 1, 0})));

        System.out.println(Arrays.toString(moveZerosTwo(new int[]{0, 1, 0, 3, 12})));
        System.out.println(Arrays.toString(moveZerosTwo(new int[]{0, 1, 0})));
    }

    private static int[] moveZeros(int[] nums) {
        int zeroCount = 0;
        int len = nums.length;
        for (int i = 0; i < len - zeroCount; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[len - 1] = 0;
                zeroCount++;
                i--;
            }
        }
        return nums;
    }

    private static int[] moveZerosTwo(int[] nums) {
        long zeroCount = Arrays.stream(nums)
                               .filter(n -> n == 0)
                               .count();

        List<Integer> list = new ArrayList<>(Arrays.stream(nums)
                                                   .filter(n -> n != 0)
                                                   .boxed()
                                                   .toList());

        for (int i = 0; i < zeroCount; i++)
            list.add(0);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
