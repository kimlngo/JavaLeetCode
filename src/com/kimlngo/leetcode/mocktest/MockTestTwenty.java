package com.kimlngo.leetcode.mocktest;

import com.kimlngo.leetcode.Util;

import java.util.Arrays;
import java.util.List;

/**
 * Calculate the min time to move between two points
 * Moving is only allowed in either 3 ways: move horizontally, move vertically and move diagonally (in 45 degree angle)
 * The shortest distance is called Chebyshev distance
 *
 * Approach: Move Diagonally as much as possible
 *
 */
public class MockTestTwenty {
    public static void main(String[] args) {
        int[][] ints = Util.readInputArray("[[559,511],[932,618],[-623,-443],[431,91],[838,-127],[773,-917],[-500,-910],[830,-417],[-870,73],[-864,-600],[450,535],[-479,-370],[856,573],[-549,369],[529,-462],[-839,-856],[-515,-447],[652,197],[-83,345],[-69,423],[310,-737],[78,-201],[443,958],[-311,988],[-477,30],[-376,-153],[-272,451],[322,-125],[-114,-214],[495,33],[371,-533],[-393,-224],[-405,-633],[-693,297],[504,210],[-427,-231],[315,27],[991,322],[811,-746],[252,373],[-737,-867],[-137,130],[507,380],[100,-638],[-296,700],[341,671],[-944,982],[937,-440],[40,-929],[-334,60],[-722,-92],[-35,-852],[25,-495],[185,671],[149,-452]]");

        MockTestTwenty sol = new MockTestTwenty();
        System.out.println(sol.minTimeToVisitAllPoints(ints));

    }

    public int minTimeToVisitAllPoints(int[][] points) {
        //1) convert all the points in array to List of Points
        List<Point20> allPoints = convertToPoints(points);

        //2) iterate through a pair of points and calculate its time
        int time = 0;

        for (int i = 0; i < allPoints.size() - 1; i++) {
            //leave 1 for the last pair of points
            Point20 orig = allPoints.get(i);
            Point20 dest = allPoints.get(i + 1);

            int xDiff = Math.abs(orig.x() - dest.x());
            int yDiff = Math.abs(orig.y() - dest.y());

            time += Math.max(xDiff, yDiff);
        }

        return time;
    }

    private List<Point20> convertToPoints(int[][] points) {
        return Arrays.stream(points)
                     .map(this::createNewPoint)
                     .toList();
    }

    private Point20 createNewPoint(int[] p) {
        return new Point20(p[0], p[1]);
    }
}

record Point20(int x, int y) {
}