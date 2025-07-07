package com.kimlngo.leetcode.mocktest;

import com.kimlngo.leetcode.Util;

import java.util.Arrays;

public class MockTestThirtyFive {
    public static void main(String[] args) {
        int[] cells = Util.readInput1DArray("[1,0,0,1,0,0,1,0]");
        MockTestThirtyFive sol = new MockTestThirtyFive();

        System.out.println(Arrays.toString(sol.prisonAfterNDays(cells, 1000000000)));
    }

    public int[] prisonAfterNDays(int[] cells, int n) {
        int len = cells.length;

        int[] orig = copyArr(cells);
        int[] arr = new int[len];

        int dayCount = 0;
        if(n % 14 != 0) dayCount = n % 14;
        else dayCount = 14;

        for(int i = 1; i <= dayCount; i++) {
            for(int j = 1; j < len - 1; j++) {
                if(orig[j - 1] == orig[j + 1])
                    arr[j] = 1;
                else
                    arr[j] = 0;
            }

            arr[0] = 0;
            arr[len - 1] = 0;
            orig = copyArr(arr);
        }

        return arr;
    }

    private int[] copyArr(int[] orig) {
        int[] arr = new int[orig.length];

        for(int i = 0; i < orig.length; i++) {
            arr[i] = orig[i];
        }

        return arr;
    }
}
