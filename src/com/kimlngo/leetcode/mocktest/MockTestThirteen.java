package com.kimlngo.leetcode.mocktest;

import java.util.*;
import java.util.stream.Collectors;

public class MockTestThirteen {
    public static void main(String[] args) {
        System.out.println(rotatedDigits(100));
    }

    /**
     * An integer x is a good if after rotating each digit individually by 180 degrees, we get a valid number that is different from x. Each digit must be rotated - we cannot choose to leave it alone.
     * <p>
     * A number is valid if each digit remains a digit after rotation. For example:
     * <p>
     * 0, 1, and 8 rotate to themselves,
     * 2 and 5 rotate to each other (in this case they are rotated in a different direction, in other words, 2 or 5 gets mirrored),
     * 6 and 9 rotate to each other, and
     * the rest of the numbers do not rotate to any other number and become invalid.
     * <p>
     * Given an integer n, return the number of good integers in the range [1, n].
     * <p>
     * Example 1:
     * <p>
     * Input: n = 10
     * Output: 4
     * Explanation: There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
     * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
     * <p>
     * Example 2:
     * <p>
     * Input: n = 1
     * Output: 0
     * <p>
     * Example 3:
     * <p>
     * Input: n = 2
     * Output: 1
     *
     * @param n
     * @return
     */
    private static int rotatedDigits(int n) {
        List<Integer> goodInts = new ArrayList<>();

        //1) create a Map<Integer, Integer> of rotating number from 0 - 9
        final Map<Integer, Integer> rotationMap = createRotationMap();
        final List<Integer> invalidDigit = Arrays.asList(3, 4, 7);

        //2) write a function to rotate all digit of a number and return the result
        for (int i = 1; i <= n; i++) {
            var destrList = destructureInt(i);

            //if number contains any digit that is in-rotatable (3, 4, 7) -> move on to the next number
            if (destrList.stream()
                         .anyMatch(invalidDigit::contains)) {
                continue;
            }

            int rotated = rotateNumber(destrList, rotationMap);
            if (rotated != i)
                goodInts.add(i);
        }
        System.out.println(goodInts);
        return goodInts.size();
    }

    private static Map<Integer, Integer> createRotationMap() {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        return map;
    }

    private static List<Integer> destructureInt(int n) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        int m = n;
        while (m != 0) {
            stack.push(m % 10);
            m /= 10;
        }

        while (!stack.isEmpty())
            list.add(stack.pop());

        return list;
    }

    private static int rotateNumber(List<Integer> destructureList, Map<Integer, Integer> map) {
        String intStr = destructureList.stream()
                                       .map(map::get)
                                       .map(String::valueOf)
                                       .collect(Collectors.joining());

        return Integer.parseInt(intStr);
    }
}
