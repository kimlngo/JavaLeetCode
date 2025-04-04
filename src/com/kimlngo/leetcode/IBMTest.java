package com.kimlngo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IBMTest {
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 0, 0));
        input.add(Arrays.asList(0, 1, 1));
        input.add(Arrays.asList(0, 0, 1));

        System.out.println(input);
        System.out.println(rotate90DegreeClockWise(input));
        System.out.println(verticalFlip(rotate90DegreeClockWise(input)));
        System.out.println(horizontalFlip(rotate90DegreeClockWise(input)));
    }


    private static List<List<Integer>> rotate90DegreeClockWise(List<List<Integer>> input) {
        List<List<Integer>> result = new ArrayList<>();
        int n = input.size();

        for (int col = 0; col < n; col++) {
            List<Integer> inner = new ArrayList<>();

            for (int row = n - 1; row >= 0; row--) {
                inner.add(input.get(row)
                               .get(col));
            }

            result.add(inner);
        }
        return result;
    }

    private static List<List<Integer>> verticalFlip(List<List<Integer>> input) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = input.size() - 1; i >= 0; i--) {
            result.add(input.get(i));
        }

        return result;

    }

    private static List<List<Integer>> horizontalFlip(List<List<Integer>> input) {
        List<List<Integer>> result = new ArrayList<>();

        int size = input.size();
        for (int i = 0; i < size; i++) {
            List<Integer> inner = new ArrayList<>();
            for (int j = size - 1; j >= 0; j--) {
                inner.add(input.get(i)
                               .get(j));
            }
            result.add(inner);
        }

        return result;
    }
}
