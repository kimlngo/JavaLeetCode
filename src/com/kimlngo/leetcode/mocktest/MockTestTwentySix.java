package com.kimlngo.leetcode.mocktest;

import java.util.*;

public class MockTestTwentySix {
    public static void main(String[] args) {
        MockTestTwentySix sol = new MockTestTwentySix();
//        System.out.println(sol.orangesRotting(new int[][]{
//                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
//        }));

//        System.out.println(sol.orangesRotting(new int[][]{
//                {2,0,1,1,1,1,1,1,1,1},
//                {1,0,1,0,0,0,0,0,0,1},
//                {1,0,1,0,1,1,1,1,0,1},
//                {1,0,1,0,1,0,0,1,0,1},
//                {1,0,1,0,1,0,0,1,0,1},
//                {1,0,1,0,1,1,0,1,0,1},
//                {1,0,1,0,0,0,0,1,0,1},
//                {1,0,1,1,1,1,1,1,0,1},
//                {1,0,0,0,0,0,0,0,0,1},
//                {1,1,1,1,1,1,1,1,1,1}}
//        ));

        sol.generateMatrix(2);
    }

    public int orangesRotting(int[][] grid) {
        //special case
        if(countByStatus(grid, 1) == 0) return 0;
        else if(countByStatus(grid, 2) == 0) return -1;

        //m x n matrix: m rows, n cols
        int rowSize = grid.length;
        int colSize = grid[0].length;

        int phaseCount = 0;
        int timeLapse = 0;

        printGrid(grid);
        Set<List<Integer>> visitedRotten = new HashSet<>();

        while (phaseCount < rowSize * colSize) {
            Set<List<Integer>> rottenCoordinates = new HashSet<>();

            for (int row = 0; row < rowSize; row++) {
                for (int col = 0; col < colSize; col++) {
                    if (grid[row][col] == 2 && !visitedRotten.contains(Arrays.asList(row, col))) {
                        //north
                        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                            //push this row-1 , col to candidate
                            rottenCoordinates.add(Arrays.asList(row - 1, col));
                        }
                        //south
                        if (row + 1 < rowSize && grid[row + 1][col] == 1) {
                            rottenCoordinates.add(Arrays.asList(row + 1, col));
                        }

                        //east
                        if (col + 1 < colSize && grid[row][col + 1] == 1) {
                            rottenCoordinates.add(Arrays.asList(row, col + 1));
                        }

                        //west
                        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                            rottenCoordinates.add(Arrays.asList(row, col - 1));
                        }

                        visitedRotten.add(Arrays.asList(row, col));
                    }
                }
            }

            //set the rotten
            if (!rottenCoordinates.isEmpty()) {
                for (var coors : rottenCoordinates) {
                    grid[coors.getFirst()][coors.getLast()] = 2;
                }
            }

            printGrid(grid);
            timeLapse++;

            if (isAllRotten(grid)) {
                return timeLapse;
            }


            phaseCount++;
        }
        return -1;
    }

    private boolean isAllRotten(int[][] grid) {
        for (int[] ints : grid) {
            for (int col = 0; col < grid[0].length; col++) {
                if (ints[col] == 1)
                    return false;
            }
        }

        //either all 0 or 2
        return true;
    }

    private void printGrid(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println("=============================");
    }

    private int countByStatus(int[][] grid, int status) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == status)
                    count++;
            }
        }

        return count;
    }

    public int[][] generateMatrix(int n) {
        int num = 1;

        int rowLow = 0, rowHigh = n;
        int colLow = 0, colHigh = n;

        int[][] grid = new int[n][n];
        int square = n * n;

        while(num <= square) {
            //row fix, col +
            for(int col = colLow; col < colHigh; col++) {
                grid[rowLow][col] = num++;
            }
            rowLow++;
            if(num == square + 1) break;

            //col fix, row +
            for (int r = rowLow; r < rowHigh; r++) {
                grid[r][colHigh - 1] = num++;
            }
            colHigh--;
            if(num == square + 1) break;

            //row fix, col -
            for (int col = colHigh - 1; col >= colLow; col--) {
                grid[rowHigh - 1][col] = num++;
            }
            rowHigh--;
            if(num == square + 1) break;

            //col fix, row -
            for (int row = rowHigh - 1; row >= rowLow; row--) {
                grid[row][colLow] = num++;
            }
            colLow++;
            if(num == square + 1) break;

        }
        return grid;
    }

    private void printMatrix(int[][] grid) {
        for(var row : grid) {
            for(var cell : row) {
                System.out.printf("%3d\t", cell);
            }
            System.out.println();
        }
        System.out.println("==================");
    }
}
