package com.kimlngo.leetcode.mocktest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockTestOne {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(5));
        System.out.println(isPowerOfTwo(9));
        System.out.println(isPowerOfTwo(33));

        System.out.println(isPowerOfTwo(-1));
        System.out.println(isPowerOfTwo(0));

        System.out.println("=======================");

        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));

    }

    private static boolean isPowerOfTwo(int n) {
        int x = 0;

        while (Math.pow(2, x) <= n) {
            if (Math.pow(2, x) == n) return true;

            x++;
        }
        return false;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 1; i <= nums.length; i++)
            map.put(i, false);


        for (int i : nums)
            if (!map.get(i))
                map.put(i, true);

        return map.entrySet()
                  .stream()
                  .filter(entry -> entry.getValue() == false)
                  .map(Map.Entry::getKey)
                  .toList();
    }
}
