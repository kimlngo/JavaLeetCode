package com.kimlngo.leetcode.mocktest;

import com.kimlngo.leetcode.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MockTestThirtyEight {

    public static void main(String[] args) {
        var sol = new MockTestThirtyEight();

        Util.print2DArray(sol.merge(Util.readInput2DArray("[[1,4],[1,3],[8,10],[15,18]]")));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;

        //1) create sorted intervals
        List<Interval> sortedIntervals = convertIntervalList(intervals);

        //2) merging
        List<Interval> result = new ArrayList<>();
        Interval firstInterval = sortedIntervals.getFirst();

        Interval inner = new Interval(firstInterval.start(), firstInterval.end());

        for (int i = 1; i < sortedIntervals.size(); i++) {
            Interval candidate = sortedIntervals.get(i);

            int candidateStart = candidate.start();
            int candidateEnd = candidate.end();
            int innerEnd = inner.end();

            //3 > 2
            if (innerEnd >= candidateStart) {
                //Overlapping case
                if (innerEnd < candidateEnd)
                    inner = new Interval(inner.start(), candidateEnd);
            } else {
                //non-overlapping case
                result.add(inner);
                inner = new Interval(candidateStart, candidateEnd);
            }

        }
        result.add(inner);

        //convert List<Interval> back to int[][]
        return result.stream()
                     .map(Interval::convertToArray)
                     .toArray(int[][]::new);
    }

    private List<Interval> convertIntervalList(int[][] intervals) {
        return Arrays.stream(intervals)
                     .map(Interval::new)
                     .sorted(Comparator.comparingInt(Interval::start))
                     .toList();
    }
}

record Interval(int start, int end) {
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    Interval(int[] interval) {
        this(interval[0], interval[1]);
    }

    int[] convertToArray() {
        return new int[]{this.start, this.end};
    }
}