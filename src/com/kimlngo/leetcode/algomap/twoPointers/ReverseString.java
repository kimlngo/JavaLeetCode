package com.kimlngo.leetcode.algomap.twoPointers;

import java.util.Arrays;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * <p>
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] input = {'h', 'a'};
        reverseString(input);
        System.out.println(Arrays.toString(input));

    }

    private static void reverseString(char[] s) {
        int length = s.length;
        if (length == 1) return;

        char tmp;
        int left = 0, right;

        while (left < length / 2) {
            right = length - 1 - left;
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left++;
        }
    }
}
