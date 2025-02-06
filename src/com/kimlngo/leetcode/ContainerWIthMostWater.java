package com.kimlngo.leetcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContainerWIthMostWater {
    public static void main(String[] args) throws IOException {
        int[] input = readFile();
        long start = System.currentTimeMillis();
        System.out.println(maxArea_TwoPointers(input));
        System.out.println("Execution Time = " + (System.currentTimeMillis() - start));

    }

    public static int[] readFile()
            throws IOException {
        String file = "src/com/kimlngo/leetcode/water.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        reader.close();

        String[] splits = currentLine.split(",");
        int[] result = new int[splits.length];

        int min = Integer.parseInt(splits[0]);
        int max = min;
        for (int i = 0; i < splits.length; i++) {
            int cur = Integer.parseInt(splits[i]);
            if (cur < min) min = cur;
            if (cur > max) max = cur;

            result[i] = cur;
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        return result;
    }

    private static int maxArea_InEfficient(int[] height) {
        int len = height.length;
        int maxArea = -1;
        int calcArea;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                calcArea = Math.abs(i - j) * Math.min(height[i], height[j]);
                if (calcArea > maxArea) {
                    maxArea = calcArea;
                    System.out.println(String.format("i = %d, height[i] = %d, j = %d, height[j] = %d, area = %d", i, j, height[i], height[j], calcArea));
                }
            }
        }

        return maxArea;
    }

    private static int maxArea_TwoPointers(int[] heights) {
        int len = heights.length;

        int left = 0, right = len - 1;
        int maxArea = -1;
        int calcArea;
        while (left < right) {
            calcArea = (right - left) * Math.min(heights[left], heights[right]);
            if(calcArea > maxArea) maxArea = calcArea;

            if(heights[left] <= heights[right]) left++;
            else right--;
        }

        return maxArea;
    }
}
