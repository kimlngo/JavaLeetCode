package com.kimlngo.leetcode.algomap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(squareOfSortedArray(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(squareOfSortedArray(new int[]{-10000, -9999, -7, -5, 0, 0, 10000})));
    }

    private static int[] squareOfSortedArray(int[] nums) {
        if (nums.length == 1) return new int[]{(int) Math.pow(nums[0], 2)};

        List<Integer> intList = new ArrayList<>();

        List<Integer> squares = Arrays.stream(nums)
                                      .map(n -> n * n)
                                      .boxed()
                                      .toList();
        System.out.println("squares: " + squares);

        int left = 0, right = squares.size() - 1;

        while (left < right) {
            if (squares.get(right) > squares.get(left)) {
                intList.add(squares.get(right));
                right--;
            } else if (squares.get(left) > squares.get(right)) {
                intList.add(squares.get(left));
                left++;
            } else {
                //equal case
                intList.add(squares.get(left));
                intList.add(squares.get(right));
                right--;
                left++;
            }
        }
        if(intList.size() < squares.size())
            intList.add(squares.get(left));

        Collections.reverse(intList);
        System.out.println(intList);

        return intList.stream()
                      .mapToInt(Integer::valueOf)
                      .toArray();
    }
}
