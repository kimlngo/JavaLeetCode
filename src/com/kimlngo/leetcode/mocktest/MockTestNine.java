package com.kimlngo.leetcode.mocktest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MockTestNine {

    public static void main(String[] args) {
        MockTestNine solution = new MockTestNine();

        System.out.println("### Q1 ###");
        System.out.println(solution.hammingDistance(1, 4)); //2
        System.out.println(solution.hammingDistance(1, 3)); //1

        System.out.println("### Q2 ###");
        System.out.println(solution.rotateString("abcde", "cdeab")); //true
        System.out.println(solution.rotateString("abcde", "abced")); //false

        System.out.println("### Q3 ###");
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));   //[3]
        System.out.println(solution.majorityElement(new int[]{1}));         //[1]
        System.out.println(solution.majorityElement(new int[]{1, 2}));      //[1, 2]
    }

    /**
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     * Given two integers x and y, return the Hamming distance between them.
     * <p>
     * Example 1:
     * Input: x = 1, y = 4
     * Output: 2
     * Explanation:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     * ↑   ↑
     * The above arrows point to positions where the corresponding bits are different.
     * <p>
     * Example 2:
     * Input: x = 3, y = 1
     * Output: 1
     *
     * @param x
     * @param y
     * @return hamming distance
     */
    public int hammingDistance(int x, int y) {
        String xBin = Integer.toBinaryString(x);
        String yBin = Integer.toBinaryString(y);

        int xLen = xBin.length();
        int yLen = yBin.length();

        //prefix the shorter string with "0" before processing
        if (xLen < yLen) {
            xBin = prefixWithZero(xBin, xLen, yLen);
        } else if (xLen > yLen) {
            yBin = prefixWithZero(yBin, yLen, xLen);
        }

        int count = 0;

        for (int i = xBin.length() - 1; i >= 0; i--) {
            if (xBin.charAt(i) != yBin.charAt(i))
                count++;
        }

        return count;
    }

    private String prefixWithZero(String s, int shorter, int longer) {
        return "0".repeat(longer - shorter) + s;
    }

    /**
     * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
     * <p>
     * A shift on s consists of moving the leftmost character of s to the rightmost position.
     * <p>
     * For example, if s = "abcde", then it will be "bcdea" after one shift.
     * <p>
     * Example:
     * Input: s = "abcde", goal = "cdeab"
     * Output: true
     * <p>
     * Input: s = "abcde", goal = "abced"
     * Output: false
     *
     * @param s
     * @param goal
     * @return
     */
    private boolean rotateString(String s, String goal) {
        if (s.equals(goal))
            return true;

        String shiftStr = s;
        for (int i = 0; i < s.length(); i++) {
            shiftStr = shift(shiftStr);
            if (shiftStr.equals(goal))
                return true;
        }

        return false;
    }

    private String shift(String s) {
        return s.substring(1) + s.charAt(0);
    }

    /**
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,2,3]
     * Output: [3]
     * Example 2:
     * <p>
     * Input: nums = [1]
     * Output: [1]
     * Example 3:
     * <p>
     * Input: nums = [1,2]
     * Output: [1,2]
     *
     * @param nums
     * @return List of Integer
     */
    public List<Integer> majorityElement(int[] nums) {
        long threshold = (long) Math.floor((double) nums.length / 3);

        //1) create frequency counter Map<Integer, Long>
        Map<Integer, Long> freqCounter = Arrays.stream(nums)
                                               .boxed()
                                               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //2) filter those with frequency > threshold and return the list of keys
        return freqCounter.entrySet()
                          .stream()
                          .filter(entry -> entry.getValue() > threshold)
                          .map(Map.Entry::getKey)
                          .toList();
    }
}
