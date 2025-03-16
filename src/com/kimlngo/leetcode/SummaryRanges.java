package com.kimlngo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(summaryRanges(new int[]{0}));
        System.out.println(summaryRanges(new int[]{}));
    }

    private static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if(nums.length == 0) return result;

        List<Integer> inner = new ArrayList<>();
        inner.add(nums[0]);
        int pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - pre != 1) {
                addResult(result, inner);
                inner.clear();
            }
            inner.add(nums[i]);
            pre = nums[i];
        }

        //post processing
        addResult(result, inner);

        return result;
    }

    private static void addResult(List<String> result, List<Integer> inner) {
        if(inner.size() == 1)
            result.add(String.format("%d", inner.get(0)));
        else
            result.add(String.format("%d->%d", inner.get(0), inner.get(inner.size() - 1)));
    }
}
