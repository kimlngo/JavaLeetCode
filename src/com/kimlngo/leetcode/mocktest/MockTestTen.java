package com.kimlngo.leetcode.mocktest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MockTestTen {
    public static void main(String[] args) {
        MockTestTen sol = new MockTestTen();

        int[][] mat = new int[][]{{1, 1, 0, 0, 1, 0, 0, 1, 1, 0}, {1, 0, 0, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 0, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 0, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}};

        int[][] result = sol.updateMatrix(mat);

        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        List<List<P9Point>> pMatrix = new ArrayList<>();
        List<P9Point> zeroPoints = new ArrayList<>();

        //1) construct the point matrix
        // record all the zero points on the fly
        for (int row = 0; row < mat.length; row++) {
            List<P9Point> oneRow = new ArrayList<>();

            for (int col = 0; col < mat[row].length; col++) {
                P9Point p = new P9Point(mat[row][col], row, col);
                oneRow.add(p);

                if (p.getVal() == 0)
                    zeroPoints.add(p);
            }

            pMatrix.add(oneRow);
        }


        int[][] result = new int[mat.length][mat[0].length];

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                if (mat[row][col] == 0) {
                    result[row][col] = 0;
                    continue;
                }

                P9Point refPoint = pMatrix.get(row)
                                          .get(col);
                P9Point nearestZero = findNearestZeroPoint(refPoint, zeroPoints);
                result[row][col] = Math.abs(refPoint.getRow() - nearestZero.getRow()) + Math.abs(refPoint.getCol() - nearestZero.getCol());
            }
        }

        return result;

    }

    private P9Point findNearestZeroPoint(P9Point refPoint, List<P9Point> zeroPoints) {
        zeroPoints.forEach(p -> {
            p.setDist(
                    Math.abs(refPoint.getRow() - p.getRow()) + Math.abs(refPoint.getCol() - p.getCol()));
//                      p.setDist(Math.sqrt(
//                              (p.getRow() - refPoint.getRow()) * (p.getRow() - refPoint.getRow()) +
//                                      (p.getCol() - refPoint.getCol()) * (p.getCol() - refPoint.getCol())
//                      ));
        });

        return zeroPoints.stream()
                         .sorted(Comparator.comparingDouble(P9Point::getDist))
                         .toList()
                         .getFirst();
    }

}

class P9Point {
    private int val;
    private int row;
    private int col;
    private double dist;

    public P9Point(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }

    public int getVal() {
        return this.val;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public double getDist() {
        return this.dist;
    }

    public void setDist(double d) {
        this.dist = d;
    }

}