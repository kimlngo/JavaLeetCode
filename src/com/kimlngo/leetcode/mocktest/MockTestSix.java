package com.kimlngo.leetcode.mocktest;

import java.util.*;
import java.util.stream.Stream;

/**
 * You are asked to cut off all the trees in a forest for a golf event. The forest is represented as an m x n matrix. In this matrix:
 * •	0 means the cell cannot be walked through.
 * •	1 represents an empty cell that can be walked through.
 * •	A number greater than 1 represents a tree in a cell that can be walked through, and this number is the tree's height.
 * In one step, you can walk in any of the four directions: north, east, south, and west. If you are standing in a cell with a tree, you can choose whether to cut it off.
 * You must cut off the trees in order from shortest to tallest. When you cut off a tree, the value at its cell becomes 1 (an empty cell).
 * Starting from the point (0, 0), return the minimum steps you need to walk to cut off all the trees. If you cannot cut off all the trees, return -1.
 * Note: The input is generated such that no two trees have the same height, and there is at least one tree needs to be cut off.
 * <p>
 * Input: forest = [[1,2,3],[0,0,4],[7,6,5]]
 * <p>
 * 1 -> 2 -> 3
 *           |
 * 0    0    4
 *           |
 * 7 <- 6 <- 5
 * <p>
 * Output: 6
 * Explanation: Following the path above allows you to cut off the trees from shortest to tallest in 6 steps.
 *
 * Input: forest = [[1,2,3],[0,0,0],[7,6,5]]
 * Output: -1
 * 1    2    3
 *
 * 0    0    0
 *
 * 7    6    5
 * Explanation: The trees in the bottom row cannot be accessed as the middle row is blocked.
 *
 * Example 3:
 * Input: forest = [[2,3,4],[0,0,5],[8,7,6]]
 * Output: 6
 * Explanation: You can follow the same path as Example 1 to cut off all the trees.
 * Note that you can cut off the first tree at (0, 0) before making any steps.
 */
public class MockTestSix {
    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<Integer>> forest = new ArrayList<>();
        forest.add(Arrays.asList(1, 2, 3));
        forest.add(Arrays.asList(0, 0, 4));
        forest.add(Arrays.asList(7, 6, 5));

        System.out.println(sol.cutOffTree(forest));

        List<List<Integer>> forest2 = new ArrayList<>();
        forest2.add(Arrays.asList(1, 2, 3));
        forest2.add(Arrays.asList(0, 0, 0));
        forest2.add(Arrays.asList(7, 6, 5));

        System.out.println(sol.cutOffTree(forest2));

        List<List<Integer>> forest3 = new ArrayList<>();
        forest3.add(Arrays.asList(2, 3, 4));
        forest3.add(Arrays.asList(0, 0, 5));
        forest3.add(Arrays.asList(8, 7, 6));

        System.out.println(sol.cutOffTree(forest3));
    }
}

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int maxStepToCut = maxStepToCut(forest);

        int row = forest.size();
        int col = forest.getFirst()
                        .size();

        Stack<Integer> visited = new Stack<>();
        visited.push(forest.getFirst()
                           .getFirst());

        int r = 0, c = 0, count = 0;

        while (count < row * col) {
            Step east = c + 1 >= col ? null : new Step(forest.get(r)
                                                             .get(c + 1), r, c + 1);
            Step west = c - 1 < 0 ? null : new Step(forest.get(r)
                                                          .get(c - 1), r, c - 1);

            Step north = r - 1 < 0 ? null : new Step(forest.get(r - 1)
                                                           .get(c), r - 1, c);
            Step south = r + 1 >= row ? null : new Step(forest.get(r + 1)
                                                              .get(c), r + 1, c);

            List<Step> possibleSteps =
                    Stream.of(east, west, north, south)
                          .filter(step -> step != null && step.val() != 0 && !visited.contains(step.val()))
                          .sorted(Comparator.comparingInt(Step::val))
                          .toList();

            if (possibleSteps.isEmpty())
                break;
            else {
                Step nextStep = possibleSteps.getFirst();
                count++;
                visited.add(nextStep.val());
                r = nextStep.row();
                c = nextStep.col();
            }
        }
        if (count == maxStepToCut) return maxStepToCut;
        else return -1;

    }

    private int maxStepToCut(List<List<Integer>> forest) {
        int row = forest.size();
        int col = forest.getFirst()
                        .size();

        int zeroCount = (int) forest.stream()
                                    .flatMap(List::stream)
                                    .filter(i -> i == 0)
                                    .count();

        // minus 1 for the starting position of (0, 0)
        return (row * col) - zeroCount - 1;
    }
}

record Step(Integer val, int row, int col) {
}