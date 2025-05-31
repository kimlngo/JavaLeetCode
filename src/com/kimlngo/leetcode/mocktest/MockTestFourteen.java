package com.kimlngo.leetcode.mocktest;

import com.kimlngo.leetcode.Util;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MockTestFourteen {
    public static void main(String[] args) throws IOException {
        MockTestFourteen sol = new MockTestFourteen();

        int[] fruits = Util.readFruit();
        System.out.println(sol.totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        if (len == 1) return len;

        Set<Integer> set = new HashSet<>();
        int left = 0, right = 1;
        set.add(fruits[left]);

        int maxFruit = 0;
        while (right < len) {
            set.add(fruits[right]);

            if (set.size() > 2) {
                while (set.size() > 2) {
                    while(fruits[left] == fruits[left + 1])
                        left++;
                    left++;
                    set = getUniqueNums(fruits, left, right);
                }
            }

            if (right - left + 1 > maxFruit)
                maxFruit = right - left + 1;

            right++;
        }
        return maxFruit;
    }

    private Set<Integer> getUniqueNums(int[] arr, int left, int right) {
        Set<Integer> set = new HashSet<>();

        for (int i = left; i <= right; i++) {
            set.add(arr[i]);
        }

        return set;
    }
}
