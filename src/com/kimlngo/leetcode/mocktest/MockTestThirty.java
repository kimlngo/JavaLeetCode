package com.kimlngo.leetcode.mocktest;

import com.kimlngo.leetcode.Util;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MockTestThirty {
    public static void main(String[] args) {
        SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();

        System.out.println(Arrays.toString(squaresOfSortedArray.sortedSquares(Util.readInput1DArray("[-4,-1,0,3,10]"))));
        System.out.println(Arrays.toString(squaresOfSortedArray.sortedSquares(Util.readInput1DArray("[-7,-3,2,3,11]"))));

        CustomSortString customSortString = new CustomSortString();
        System.out.println(customSortString.customSortString("cba", "abcd")); //cbad
        System.out.println(customSortString.customSortString("bcafg", "abcd")); //bcad
    }

}

/**
 * You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
 *
 * Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
 *
 * Return any permutation of s that satisfies this property.
 *
 * Example 1:
 * Input: order = "cba", s = "abcd"
 * Output: "cbad"
 *
 * Explanation: "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
 *
 *  Example 2:
 * Input: order = "bcafg", s = "abcd"
 * Output: "bcad"
 *
 * Explanation: The characters "b", "c", and "a" from order dictate the order for the characters in s. The character "d" in s does not appear in order, so its position is flexible.
 * Following the order of appearance in order, "b", "c", and "a" from s should be arranged as "b", "c", "a". "d" can be placed at any position since it's not in order. The output "bcad" correctly follows this rule. Other arrangements like "dbca" or "bcda" would also be valid, as long as "b", "c", "a" maintain their order.
 */
class CustomSortString {
    public String customSortString(String order, String s) {
        //1) create freq counter map of s
        Map<Character, Long> map = s.chars()
                                    .mapToObj(a -> (char) a)
                                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //2) iterate through each char from order and construct the corresponding string
        StringBuilder sb = new StringBuilder();

        for(char c : order.toCharArray()) {
            if(map.get(c) != null) {
                sb.append(constructString(c, map.get(c)));
            }
        }

        //resolve the un-order chars in s
        StringBuilder unOrder = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(!order.contains(String.valueOf(c))) {
                unOrder.append(c);
            }
        }

        return sb.toString() + unOrder.toString();

    }

    private String constructString(Character c, long times) {
        return c.toString().repeat((int) times);
    }
}

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        //array only contains non-neg numbers
        if (nums[0] >= 0) {
            for (int i = 0; i < length; i++) {
                result[i] = nums[i] * nums[i];
            }
            return result;
        }

        //array contains all neg numbers
        if (nums[length - 1] <= 0) {
            for (int i = 0; i < length; i++) {
                result[i] = nums[length - 1 - i] * nums[length - 1 - i];
            }
            return result;
        }

        //array contains two part: neg and pos
        //1) find out the middle-point value (the point where val is >= 0)
        //then create two pointers: left & right,
        //assign the value of left & right based on their nums value

        int mid = 0;
        while (nums[mid] < 0) mid++;

        int right = mid, left = mid - 1;
        int idx = 0;

        while (left >= 0 && right < length) {
            if (abs(nums[right]) <= abs(nums[left])) {
                result[idx++] = nums[right];
                right++;
            } else if (abs(nums[left]) < abs(nums[right])) {
                result[idx++] = nums[left];
                left--;
            }
        }

        if (left < 0) {
            for (int i = right; i < length; i++) {
                result[idx++] = nums[i];
            }
        } else {
            //right >= length
            for (int i = left; i >= 0; i--) {
                result[idx++] = nums[i];
            }
        }

        int[] square = new int[length];
        for (int i = 0; i < length; i++) {
            square[i] = result[i] * result[i];
        }

        return square;
    }

    private int abs(int num) {
        return Math.abs(num);
    }
}
