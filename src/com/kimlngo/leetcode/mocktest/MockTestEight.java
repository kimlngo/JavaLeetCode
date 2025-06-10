package com.kimlngo.leetcode.mocktest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MockTestEight {
    public static void main(String[] args) {
        MockTestEight solution = new MockTestEight();

        System.out.println("### Question 1 ###");
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));

        System.out.println("### Question 2 ###");
        solution.printArray(solution.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1));
        solution.printArray(solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2));
    }

    /**
     * @param s
     * @return longest palindrome
     * <p>
     * Given a string s, return the longest palindromic substring in s.
     * example:
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * <p>
     * Input: s = "cbbd"
     * Output: "bb"
     */

    private String longestPalindrome(String s) {
        int len = s.length();

        for (int longest = len; longest >= 1; longest--) {
            for (int i = 0; i <= len - longest; i++) {
                String sub = s.substring(i, i + longest);
                if (isPalindrome(sub))
                    return sub;
            }
        }
        return "";
    }

    private boolean isPalindrome(String s) {
        int len = s.length();

        if (len == 1)
            return true;

        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param points
     * @param k
     * @return k nearest points from Origin (0, 0)
     * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
     * return the k closest points to the origin (0, 0).
     * <p>
     * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
     * <p>
     * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
     * <p>
     * Example 1:
     * Input: points = [[1,3],[-2,2]], k = 1
     * Output: [[-2,2]]
     * Explanation:
     * The distance between (1, 3) and the origin is sqrt(10).
     * The distance between (-2, 2) and the origin is sqrt(8).
     * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
     * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
     * <p>
     * Example 2:
     * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
     * Output: [[3,3],[-2,4]]
     * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
     */
    private int[][] kClosest(int[][] points, int k) {
        List<Point8> allPoints = convertToPoints(points);

        return allPoints.stream()
                        .sorted(Comparator.comparingDouble(Point8::getDist))
                        .limit(k)
                        .map(this::convertPointToArray)
                        .toArray(int[][]::new);
    }

    private List<Point8> convertToPoints(int[][] points) {
        List<Point8> result = new ArrayList<>();

        for (int[] p : points) {
            result.add(new Point8(p[0], p[1]));
        }

        return result;
    }

    private int[] convertPointToArray(Point8 p) {
        return new int[]{p.getX(), p.getY()};
    }

    private void printArray(int[][] arr) {
        System.out.println("[" + Arrays.stream(arr)
                                       .map(point -> String.format("[%d, %d]", point[0], point[1]))
                                       .collect(Collectors.joining(", ")) + "]");

    }
}

class Point8 {
    private final int x;
    private final int y;
    private final double dist;

    public Point8(int x, int y) {
        this.x = x;
        this.y = y;
        this.dist = Math.sqrt(x * x + y * y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDist() {
        return dist;
    }
}
