package com.kimlngo.leetcode.algomap.twoPointers;

import java.util.*;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(squareOfSortedArray_Iterative(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(squareOfSortedArray_Iterative(new int[]{-10000, -9999, -7, -5, 0, 0, 10000})));
    }

    //Runtime = 11ms
    private static int[] squareOfSortedArray(int[] nums) {
        if (nums.length == 1) return new int[]{(int) Math.pow(nums[0], 2)};

        List<Integer> intList = new ArrayList<>();

        List<Integer> squares = Arrays.stream(nums)
                                      .map(n -> n * n)
                                      .boxed()
                                      .toList();

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
        if (intList.size() < squares.size())
            intList.add(squares.get(left));

        Collections.reverse(intList);

        return intList.stream()
                      .mapToInt(Integer::valueOf)
                      .toArray();
    }

    //run time = 3ms
    private static int[] squareOfSortedArray_Iterative(int[] nums) {
        if (nums.length == 1) return new int[]{(int) Math.pow(nums[0], 2)};

        List<Integer> intList = new ArrayList<>();

        List<Integer> squares = new ArrayList<>();
        for (int n : nums)
            squares.add(n * n);

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
        if (intList.size() < squares.size())
            intList.add(squares.get(left));

        System.out.println(intList);
        int[] result = new int[intList.size()];

        for (int i = intList.size() - 1; i >= 0; i--) {
            result[intList.size() - 1 - i] = intList.get(i);
        }

        return result;
    }
}
