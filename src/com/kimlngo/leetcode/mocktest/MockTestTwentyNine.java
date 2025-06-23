package com.kimlngo.leetcode.mocktest;

import com.kimlngo.leetcode.Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MockTestTwentyNine {

    public static void main(String[] args) {
        FibonacciSolutionByDP fib = new FibonacciSolutionByDP();
        System.out.println(fib.fib(1000));

        DistributedCandiesSolution distributedCandiesSolution = new DistributedCandiesSolution();
        System.out.println(distributedCandiesSolution.distributeCandies(new int[]{1,1,2,2,3,3})); //3
        System.out.println(distributedCandiesSolution.distributeCandies(new int[]{1,1,2,3})); //2
        System.out.println(distributedCandiesSolution.distributeCandies(new int[]{6,6,6,6})); //1
    }
}

class FibonacciSolutionByDP {
    private static final Map<Integer, Integer> CACHE = new HashMap<>();

    static {
        CACHE.put(0, 0);
        CACHE.put(1, 1);
    }

    public int fib(int n) {
        if (CACHE.get(n) != null) return CACHE.get(n);

        CACHE.put(n, fib(n - 1) + fib(n - 2));
        return CACHE.get(n);
    }

}

class DistributedCandiesSolution {

    public int distributeCandies(int[] candyType) {

        int typeCount = Arrays.stream(candyType)
                              .distinct()
                              .toArray().length;

        return Math.min(typeCount, candyType.length / 2);
    }
}