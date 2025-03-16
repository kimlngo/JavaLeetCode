package com.kimlngo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(
                new int[][] {{1,3}, {2,6}, {8,10}, {15,18}}
        )));
        System.out.println(Arrays.toString(merge(
                new int[][] {{1,4}, {4,6}}
        )));

        System.out.println(Arrays.toString(merge(
                new int[][] {{1,4}, {2,3}}
        )));
    }

    private static int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;

        //sort the initial array
        List<List<Integer>> sortedIntervals = Arrays.stream(intervals)
                                            .map(interval -> Arrays.asList(interval[0], interval[1]))
                                            .sorted(Comparator.comparingInt(List::getFirst))
                                            .collect(Collectors.toList());

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        inner.add(sortedIntervals.getFirst().getFirst());
        inner.add(sortedIntervals.getFirst().getLast());

        for(int i = 1; i < sortedIntervals.size(); i++) {
            var interval = sortedIntervals.get(i);
            Integer start = interval.getFirst();
            Integer end = interval.getLast();
            Integer innerLast = inner.getLast();

            if(innerLast.compareTo(start) < 0) {
//            if(innerLast < start) {
                //non-overlapping case
                result.add(inner);
                inner = new ArrayList<>();
                inner.add(start);
                inner.add(end);
            } else {
                //overlap
                if(innerLast.compareTo(end) < 0) {
                    inner.removeLast();
                    inner.add(end);
                }
            }
        }

        result.add(inner);

        int[][] finalResult = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> range = result.get(i);
            int[] intRange = new int[]{range.getFirst(), range.getLast()};
            finalResult[i] = intRange;
        }

        return finalResult;
    }
}
