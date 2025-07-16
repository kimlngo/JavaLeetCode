package com.kimlngo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InsertMergeIntervals {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(insert(
//                new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}
//                , new int[]{4, 8})));

        System.out.println(merge(new int[][]{{1, 6}, {2, 8}, {7, 12}, {10, 16}}));

    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][]{{newInterval[0], newInterval[1]}};

        int[][] addedIntervals = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            addedIntervals[i][0] = interval[0];
            addedIntervals[i][1] = interval[1];
        }

        addedIntervals[intervals.length][0] = newInterval[0];
        addedIntervals[intervals.length][1] = newInterval[1];

        return merge(addedIntervals);
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        //sort the initial array
        List<List<Integer>> sortedIntervals = Arrays.stream(intervals)
                                                    .map(interval -> Arrays.asList(interval[0], interval[1]))
                                                    .sorted(Comparator.comparingInt(List::getFirst))
                                                    .toList();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        inner.add(sortedIntervals.getFirst()
                                 .getFirst());
        inner.add(sortedIntervals.getFirst()
                                 .getLast());

        for (int i = 1; i < sortedIntervals.size(); i++) {
            var interval = sortedIntervals.get(i);
            Integer start = interval.getFirst();
            Integer end = interval.getLast();
            Integer innerLast = inner.getLast();

            if (innerLast.compareTo(start) < 0) {
//            if(innerLast < start) {
                //non-overlapping case
                result.add(inner);
                inner = new ArrayList<>();
                inner.add(start);
                inner.add(end);
            } else {
                //overlap
                if (innerLast.compareTo(end) < 0) {
                    inner.removeLast();
                    inner.add(end);
                }
            }
        }

        result.add(inner);
        System.out.println(result);
        int[][] finalResult = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> range = result.get(i);
            int[] intRange = new int[]{range.getFirst(), range.getLast()};
            finalResult[i] = intRange;
        }

        return finalResult;
    }
}
