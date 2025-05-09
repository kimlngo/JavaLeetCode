package com.kimlngo.leetcode.algomap.stack;

import java.util.Arrays;

public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 90})));

        System.out.println(Arrays.toString(dailyTemperatures(new int[]{90, 80, 70, 60, 50, 40, 30, 20, 10})));
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length - 1; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    result[i] = j - i;
                    break;
                }
            }
        }

        result[temperatures.length - 1] = 0;
        return result;
    }
}
